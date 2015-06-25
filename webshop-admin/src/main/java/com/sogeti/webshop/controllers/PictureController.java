/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 23, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.controllers;

import java.beans.PropertyEditorSupport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.LobCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sogeti.webshop.common.wrappers.PageWrapper;
import com.sogeti.webshop.model.Picture;
import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.services.IPictureService;
import com.sogeti.webshop.services.IProductService;

/**
 * Controller class handling all operations related to product pictures.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 23, 2014, Sogeti B.V.
 */
@Controller
public class PictureController
{
   
   /** The Constant logger. */
   private static final Logger LOGGER = LoggerFactory.getLogger(PictureController.class);

   /** The picture service. */
   @Autowired
   private IPictureService pictureService;

   /** The product service. */
   @Autowired
   private IProductService productService;

   /** The emf. */
   @Resource
   private EntityManagerFactory emf;

   /**
    * List.
    *
    * @param pageable the pageable
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/pictures", method = RequestMethod.GET)
   public String list(Pageable pageable, Model model)
   {
      PageWrapper<Picture> page = new PageWrapper<Picture>(this.pictureService.findAll(pageable),"pictures.htm");
      model.addAttribute("page", page);
      return "pictures/list";
   }

   @RequestMapping(value="/pictures/show")
   public String show(@RequestParam("pic_id") Long picId, Model model)
   {
      model.addAttribute("pic_id", picId);
      return "pictures/show";
   }
   
   @RequestMapping(value="/pictures/content")
   public void getPictureContent(@RequestParam("pic_id") Long picId, HttpServletResponse response) throws IOException{
      Picture picture = this.pictureService.findById(picId);
      response.setContentType(picture.getContentType());
      byte[] buffer;
      try
      {
         buffer = picture.getContent().getBytes(0, (int)picture.getContent().length()-1);
         InputStream in1 = new ByteArrayInputStream(buffer);
         IOUtils.copy(in1, response.getOutputStream());  
      }
      catch (SQLException e)
      {
         LOGGER.error("Error occured while getting picture content for id:" + picId + " Error Details:" + e.getMessage());
      }

   }


   /**
    * Loads the new picture.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/pictures/new", method=RequestMethod.GET)
   public String newPicture(Model model)
   {
      model.addAttribute("products", this.productService.findAll());
      if(!model.containsAttribute("picture"))
      {
         model.addAttribute("picture", new Picture());
      }
      return "pictures/new";
   }

   /**
    * Creates the new picture file in the system.
    *
    * @param picture the picture
    * @param file the file
    * @return the string
    */
   @RequestMapping(value="/pictures/new", method=RequestMethod.POST)
   public String create(@ModelAttribute("picture") Picture picture, @RequestParam MultipartFile file)
   {
      try
      {
         Blob blob = fileToBlob(file);
         picture.setContent(blob);
         picture.setContentType(file.getContentType());
         this.pictureService.create(picture);
      }
      catch (IOException e)
      {
         LOGGER.error("Error occured while creating picture with name: " + picture.getName() + " Error Details: " + e.getMessage());
      }
      return "redirect:/pictures.htm";
   }


   /**
    * Edits the.
    *
    * @param picId the pic id
    * @param model the model
    * @return the string
    * @throws SQLException 
    */
   @RequestMapping(value="/pictures/edit", method=RequestMethod.GET)
   public String edit(@RequestParam(value="pic_id") long picId, Model model) throws SQLException
   {
      List<Product> products = this.productService.findAll();
      model.addAttribute("products", products);
      Picture picture = this.pictureService.findById(picId);
      if(!model.containsAttribute("picture"))
      {
         model.addAttribute("picture", picture);
      }
      model.addAttribute("isFilePresent", (picture.getContent()!=null && picture.getContent().length() > 0));
      return "pictures/edit";
   }

   /**
    * Updates picture in the system.
    *
    * @param picture the picture
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/pictures/edit", method=RequestMethod.POST)
   public String update(@ModelAttribute(value="picture") Picture picture, @RequestParam("file") MultipartFile file)
   {
      
      try
      {
         Blob blob = fileToBlob(file);
         picture.setContent(blob);
         picture.setContentType(file.getContentType());
         this.pictureService.update(picture);
      }
      catch (IOException e)
      {
         LOGGER.error("Error occured while updating picture data:" + e.getMessage());
      }
      return "redirect:/pictures.htm";
   }

   /**
    * Deletes the picture from the system.
    *
    * @param picId the pic id
    * @return the string
    */
   @RequestMapping(value="/pictures/delete", method=RequestMethod.DELETE)
   public String delete(@RequestParam("pic_id") Long picId)
   {
      this.pictureService.delete(picId);
      return "redirect:/pictures.htm";
   }

   /**
    * Downloads the picture file from the system.
    *
    * @param fileId the file id
    * @param response the response
    * @return the string
    */
   @RequestMapping(value="/pictures/file/download", method=RequestMethod.GET)
   public String download(@RequestParam("file_id") Long fileId, HttpServletResponse response) 
   {
      Picture pic = this.pictureService.findById(fileId);
      try
      {
         response.setHeader("Content-Disposition", "attachment;filename=\"" + pic.getName() + "\"");
         OutputStream out = response.getOutputStream();
         response.setContentType(pic.getContentType());
         IOUtils.copy(pic.getContent().getBinaryStream(), out);
         out.flush();
         out.close();
      } 
      catch (IOException e) 
      {
         LOGGER.error("Error occured while downloading picture file: " + e.getMessage());
      } 
      catch (SQLException e) 
      {
         LOGGER.error("Error occured while downloading picture file: " + e.getMessage());
      }
      return null;
   }

   /**
    * Removes the content file from the system.
    *
    * @param picId the pic id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/pictures/file/delete", method=RequestMethod.GET)
   public String removeContent(@RequestParam("pic_id") Long picId, Model model)
   {
      Picture pic = this.pictureService.findById(picId);
      pic.setContent(null);
      this.pictureService.update(pic);      
      return "redirect:/pictures/edit.htm?pic_id=" + picId;
   }

   /**
    * Converts the File to Blob object.
    *
    * @param file the file
    * @return the blob
    * @throws IOException Signals that an I/O exception has occurred.
    */
   private Blob fileToBlob(MultipartFile file) throws IOException
   {
      if(file==null && file.getSize()<=0)
      {
         return null;
      }
      EntityManager em = this.emf.createEntityManager();
      Session session = em.unwrap(Session.class);
      LobCreator lc = Hibernate.getLobCreator(session);
      Blob blob = lc.createBlob(file.getInputStream(), file.getSize());
      return blob;
   }

   /**
    * Inits the binder.
    *
    * @param binder the binder
    * @throws Exception the exception
    */
   @InitBinder
   protected void initBinder(WebDataBinder binder) throws Exception
   {
      binder.registerCustomEditor(Product.class, "product", new PropertyEditorSupport() {
         @Override
         public void setAsText(String text) 
         {
            Product product = productService.findById(Long.parseLong(text));
            setValue(product);
         }
      });
   }
}
