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
import com.sogeti.webshop.model.ProductCategory;
import com.sogeti.webshop.services.IProductCategoryService;

// TODO: Auto-generated Javadoc
/**
 * Controller handling operations related to ProductCategories  model.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 18, 2014, Sogeti B.V.
 */
@Controller
public class CategoryController
{
   
   /** The category service. */
   @Autowired
   private IProductCategoryService productCategoryService;

   
   
   /**
    * List.
    *
    * @param pageable the pageable
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/categories", method=RequestMethod.GET)
   public String list(Pageable pageable, Model model)
   {
      PageWrapper<ProductCategory> page = new PageWrapper<ProductCategory>(this.productCategoryService.findAll(pageable),"categories.htm");
      model.addAttribute("page", page);
      return "categories/list";
   }

   /**
    * New category.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/categories/new", method=RequestMethod.GET)
   public String newCategory(Model model)
   {
      ProductCategory category = new ProductCategory();
      model.addAttribute("category", category);
      return "categories/new";
   }

   /**
    * Creates a new category.
    *
    * @param category the category
    * @param bindingResult the binding result
    * @return the string
    */
   @RequestMapping(value="/categories/new", method=RequestMethod.POST)
   public String create(@Valid @ModelAttribute(value="category") ProductCategory category, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors()) {
         return "categories/new";
      }
      this.productCategoryService.create(category);
      return "redirect:/categories.htm";
   }


   /**
    * Deletes the category.
    *
    * @param catId the category id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/categories/del", method=RequestMethod.GET)
   public String delete(@RequestParam(value="cat_id") long catId, Model model)
   {
      this.productCategoryService.delete(catId);
      return "redirect:/categories.htm";
   }

   /**
    * Edits the category.
    *
    * @param catId the category id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/categories/edit", method=RequestMethod.GET)
   public String edit(@RequestParam(value="cat_id") long catId, Model model)
   {
      if(!model.containsAttribute("category"))
      {
         model.addAttribute("category", this.productCategoryService.findById(catId));
      }
      return "categories/edit";
   }

   /**
    * Updates category in the system.
    *
    * @param category the category
    * @param bindingResult the binding result
    * @param redirectAttrs the redirect attrs
    * @return the string
    */
   @RequestMapping(value="/categories/edit", method=RequestMethod.POST)
   public String update(@Valid @ModelAttribute(value="category") ProductCategory category, BindingResult bindingResult, RedirectAttributes redirectAttrs)
   {
      if (bindingResult.hasErrors()) {
         redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.category", bindingResult);
         redirectAttrs.addFlashAttribute("category", category);
         return "redirect:/categories/edit.htm?cat_id=" + category.getId();
      }
      this.productCategoryService.update(category);
      return "redirect:/categories.htm";
   }
   
   /**
    * Inits the binder & Converts empty strings into null when a form is submitted.
    *
    * @param binder the binder
    */
   @InitBinder     
   public void initBinder(WebDataBinder binder) {  
       binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));  
   }
}
