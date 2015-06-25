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

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
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
import com.sogeti.webshop.model.Role;
import com.sogeti.webshop.model.User;
import com.sogeti.webshop.services.IRoleService;
import com.sogeti.webshop.services.IUserService;

/**
 * Controller handling operations related to Users model.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 18, 2014, Sogeti B.V.
 */
@Controller
public class UserController
{
   
   /** The user service. */
   @Autowired
   private IUserService userService;

   /** The role service. */
   @Autowired
   private IRoleService roleService;

   /**
    * Finds & shows all the user records in the system.
    *
    * @param pageable the pageable
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/users", method=RequestMethod.GET)
   public String list(Pageable pageable, Model model) 
   {
      PageWrapper<User> page = new PageWrapper<User>(this.userService.findAll(pageable),"users.htm");
      model.addAttribute("page", page);
      return "users/list";
   }
   
   /**
    * Shows user details.
    *
    * @param userId the user id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/users/show", method=RequestMethod.GET)
   public String show(@RequestParam("user_id") Long userId, Model model)
   {
      User user = this.userService.findById(userId);
      model.addAttribute("user", user);
      model.addAttribute("roles", this.roleService.findAll());
      return "users/show";
   }

   /**
    * New user.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/users/new", method=RequestMethod.GET)
   public String newUser(Model model)
   {
      User user = new User();
      List<Role> roles = this.roleService.findAll(); 
      model.addAttribute("user", user);
      model.addAttribute("roles", roles);
      return "users/new";
   }

   /**
    * Creates the user.
    *
    * @param user the user
    * @param bindingResult the binding result
    * @return the string
    */
   @RequestMapping(value="/users/new", method=RequestMethod.POST)
   public String create(@Valid @ModelAttribute(value="user") User user, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors()) {
         return "users/new";
      }
      this.userService.create(user);
      return "redirect:/users.htm";
   }


   /**
    * Delete.
    *
    * @param userId the user id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/users/del", method=RequestMethod.GET)
   public String delete(@RequestParam(value="user_id") long userId, Model model)
   {
      this.userService.delete(userId);
      return "redirect:/users.htm";
   }

   /**
    * Edits the user.
    *
    * @param userId the user id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/users/edit", method=RequestMethod.GET)
   public String edit(@RequestParam(value="user_id") long userId, Model model)
   {
      List<Role> roles = this.roleService.findAll(); 
      model.addAttribute("roles", roles);
      if(!model.containsAttribute("user"))
      {
         model.addAttribute("user", this.userService.findById(userId));
      }
      return "users/edit";
   }

   /**
    * Updates user in the system.
    *
    * @param user the user
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/users/edit", method=RequestMethod.POST)
   public String update(@Valid @ModelAttribute(value="user") User user, BindingResult bindingResult, RedirectAttributes redirectAttrs)
   {
      if (bindingResult.hasErrors()) {
         redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
         redirectAttrs.addFlashAttribute("user", user);
         return "redirect:/users/edit.htm?user_id=" + user.getId();
      }
      this.userService.update(user);
      return "redirect:/users.htm";
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
      binder.registerCustomEditor(List.class, "roles", new CustomCollectionEditor(List.class) {
         protected Object convertElement(Object element) {
               Role role = roleService.findById(Long.valueOf((String)element));
               return role;
         }
      });
      binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));  
   }

}
