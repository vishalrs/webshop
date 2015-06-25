/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 18, 2014 Sogeti Nederland B.V. All Rights Reserved.
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
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sogeti.webshop.common.wrappers.PageWrapper;
import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.model.ProductCategory;
import com.sogeti.webshop.services.IProductCategoryService;
import com.sogeti.webshop.services.IProductService;

/**
 * Controller handling operations related to Product model.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 18, 2014, Sogeti B.V.
 */
@Controller
public class ProductController
{
   
   /** The product service. */
   @Autowired
   private IProductService productService;
   
   @Autowired
   private IProductCategoryService productCategoryService;

   /**
    * Finds & shows all the product records in the system.
    *
    * @param pageable the pageable
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/products", method=RequestMethod.GET)
   public String list(Pageable pageable, Model model) 
   {
      PageWrapper<Product> page = new PageWrapper<Product>(this.productService.findAll(pageable),"products.htm");
      model.addAttribute("page", page);
      return "products/list";
   }

   /**
    * New product.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/products/new", method=RequestMethod.GET)
   public String newUser(Model model)
   {
      List<ProductCategory> categories = this.productCategoryService.findAll(); 
      model.addAttribute("categories", categories);
      if(!model.containsAttribute("product"))
      {
         model.addAttribute("product", new Product());
      }
      return "products/new";
   }

   /**
    * Creates the product.
    *
    * @param product the product
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/products/new", method=RequestMethod.POST)
   public String create(@Valid @ModelAttribute(value="product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttrs)
   {
      if (bindingResult.hasErrors()) {
         redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.product", bindingResult);
         redirectAttrs.addFlashAttribute("product", product);
         return "redirect:/products/new.htm";
      }
      this.productService.create(product);
      return "redirect:/products.htm";
   }


   /**
    * Delete.
    *
    * @param userId the product id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/products/del", method=RequestMethod.GET)
   public String delete(@RequestParam(value="prod_id") long prodId, Model model)
   {
      this.productService.delete(prodId);
      return "redirect:/products.htm";
   }

   /**
    * Edits the product.
    *
    * @param userId the product id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/products/edit", method=RequestMethod.GET)
   public String edit(@RequestParam(value="prod_id") long prodId, Model model)
   {
      List<ProductCategory> categories = this.productCategoryService.findAll(); 
      model.addAttribute("categories", categories);
      if(!model.containsAttribute("product"))
      {
         model.addAttribute("product", this.productService.findById(prodId));
      }
      return "products/edit";
   }

   /**
    * Updates product in the system.
    *
    * @param product the product
    * @param bindingResult the binding result
    * @param redirectAttrs the redirect attrs
    * @return the string
    */
   @RequestMapping(value="/products/edit", method=RequestMethod.POST)
   public String update(@Valid @ModelAttribute(value="product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttrs)
   {
      if (bindingResult.hasErrors()) {
         redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.product", bindingResult);
         redirectAttrs.addFlashAttribute("product", product);
         return "redirect:/products/edit.htm?prod_id=" + product.getId();
      }
      this.productService.update(product);
      return "redirect:/products.htm";
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
      binder.registerCustomEditor(ProductCategory.class, "productCategory", new PropertyEditorSupport() {
         @Override
         public void setAsText(String text) 
         {
            ProductCategory category = productCategoryService.findById(Long.parseLong(text));
            setValue(category);
         }
      });
      binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));  

   }

   

}
