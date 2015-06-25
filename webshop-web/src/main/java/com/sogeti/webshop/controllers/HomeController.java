/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 3, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.h2.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sogeti.webshop.model.Picture;
import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.model.ProductCategory;
import com.sogeti.webshop.model.Role;
import com.sogeti.webshop.model.ShoppingCart;
import com.sogeti.webshop.model.User;
import com.sogeti.webshop.services.IMailService;
import com.sogeti.webshop.services.IPictureService;
import com.sogeti.webshop.services.IProductCategoryService;
import com.sogeti.webshop.services.IProductService;
import com.sogeti.webshop.services.IRoleService;
import com.sogeti.webshop.services.IUserService;


/**
 * The Class HomeController.
 * 
 * {Purpose of This Class}
 *  
 * {Other Notes Relating to This Class (Optional)}
 *  
 */
@Controller
@SessionAttributes({"cart"})
public class HomeController
{

   /** The Constant logger. */
   private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
   
   /**
    * <code>productCategoryService</code> indicates/is used for.
    */
   @Autowired
   private IProductCategoryService productCategoryService;
   
   /**
    * <code>productService</code> indicates/is used for.
    */
   @Autowired
   private IProductService productService;
   
   /** The user service. */
   @Autowired
   private IUserService userService;
   
   /** The role service. */
   @Autowired
   private IRoleService roleService;
   
   /**
    * <code>pictureService</code> indicates/is used for doing operations related to pictures.
    */
   @Autowired
   private IPictureService pictureService;
   
   /**
    * <code>mailService</code> indicates/is used for sending mails.
    */
   @Autowired
   private IMailService mailService;
   
   /**
    * <code>fromAddress</code> indicates/is used for mail from address from where the mail is going to be sent.
    */
   @Value("${email.settings.fromaddress}")
   private String fromAddress;
   
   /**
    * <code>subject</code> indicates/is used for mail subject line.
    */
   @Value("${email.settings.subject}")
   private String subject;
   
   /** The body. */
   @Value("${email.settings.body}")
   private String body;
   
   /**
    * Home.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value = "/home", method = RequestMethod.GET)
   public String home(Model model)
   {
      List<ProductCategory> productCategories = this.productCategoryService.findAll();
      List <Product> products = this.productService.findAll();
      
      //Create a cart if one does not exist in session
      if(!model.containsAttribute("cart")) 
      {
         model.addAttribute("cart", new ShoppingCart());
      }
      model.addAttribute("categories", productCategories);
      model.addAttribute("products", products);
      return "home";
   }
   
   /**
    * Controller method for handling product search based on name/description.
    *
    * @param param the name of the parameter
    * @param value the value based on the search
    * @param model the model
    * @return the view name
    */
   @RequestMapping(value = "search", method = RequestMethod.GET)
   public String search(@RequestParam(value = "param") String param, @RequestParam(value = "value") String value, Model model)
   {

      List<Product> products  = new ArrayList<Product>();
      
      switch(param)
      {
         //Search by name
         case "name":   
         {
            products = this.productService.findByName(value.toLowerCase());
            break;
         }
         //Search by product description
         case "desc":   
         {
            products = this.productService.findByDescription(value.toLowerCase());
            break;
         }
         //Search by product category
         case "category":
         {
            ProductCategory productCategory = this.productCategoryService.findById(Long.valueOf(value));
            products = this.productService.findByProductCategory(productCategory);
            break;            
         }
         default:
            break;
      }
      List<ProductCategory> productCategories = this.productCategoryService.findAll();
      model.addAttribute("categories", productCategories);
      model.addAttribute("products", products);
      return "home";
   }
   
   /**
    * Adds the product to the shopping cart.
    *
    * @param request the request
    * @param cart the cart
    * @return the string
    */
   @RequestMapping(value = "addProduct", method = RequestMethod.POST)
   public String addProduct(HttpServletRequest request, @ModelAttribute("cart") ShoppingCart cart) 
   {
     Long productId = Long.valueOf(request.getParameter("product_id"));
     Long qty = Long.valueOf(request.getParameter("qty"));
     Product product = this.productService.findById(Long.valueOf(productId));
     cart.addProduct(product,qty);
     return "redirect:/home.htm";
   }
   
   /**
    * Removes the product.
    *
    * @param productId the product id
    * @param cart the cart
    * @return the string
    */
   @RequestMapping(value = "removeProduct", method = RequestMethod.GET)
   public String removeProduct(@RequestParam(value = "product_id") String productId, @ModelAttribute("cart") ShoppingCart cart)
   {
      Product product = this.productService.findById(Long.valueOf(productId));
      cart.removeProduct(product);
      return "redirect:/home.htm";
   }
   
   /**
    * Shopping cart checkout handler .
    *
    * @param cart the cart
    * @param model the model
    * @return the string
    */
   public String checkout(@ModelAttribute("cart") ShoppingCart cart, Model model)
   {
      return "redirect:/home.htm";
   }
   
   /**
    * Opens up the new registration.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value = "/new")
   public String newRegistration(Model model) 
   {
        
       model.addAttribute("user", new User());
       return "register/new";
   }
   
   /**
    * Registers new user.
    *
    * @param user the user
    * @param bindingResult the binding result
    * @return the string
    */
   @RequestMapping(value = "register", method = RequestMethod.POST)
   public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors()) {
         return "register/new";
      }
      
      Role role = this.roleService.findByName("ROLE_CUSTOMER");
      user.addRole(role);
      this.userService.create(user);
      //this.mailService.sendMail(this.fromAddress, user.getEmail(), this.subject, this.body);
      return "register/confirm";
   }
   
   /**
    * Confirms registration by clicking on the link given in mail.
    *
    * @param userId the user id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value = "confirm", method = RequestMethod.GET)
   public String confirmRegistration(@RequestParam("user_id") Long userId, Model model)
   {
      User user = this.userService.findById(userId);
      user.setAccountEnabled(Boolean.TRUE);
      this.userService.update(user);
      return "register/mail_confirm";
   }
   
   /**
    * Shows the product picture page with pictures.
    *
    * @param picId the pic id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/show_picture")
   public String show(@RequestParam("prod_id") Long prodId, Model model)
   {
      Product product = this.productService.findById(prodId);
      List<Picture> pictures = this.pictureService.findByProduct(product);
      model.addAttribute("pictures", pictures);
      return "show";
   }
   
   /**
    * Gets the picture content.
    *
    * @param picId the pic id
    * @param response the response
    * @return the picture content
    * @throws IOException Signals that an I/O exception has occurred.
    */
   @RequestMapping(value="/content")
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
         e.printStackTrace();
      }
   }
   
   /**
    * Inits the binder & Converts empty strings into null when a form is submitted 
    *
    * @param binder the binder
    */
   @InitBinder     
   public void initBinder(WebDataBinder binder) {  
       binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));  
   }
  
}
