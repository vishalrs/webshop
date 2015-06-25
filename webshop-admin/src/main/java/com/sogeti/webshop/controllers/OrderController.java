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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sogeti.webshop.common.enums.Status;
import com.sogeti.webshop.common.wrappers.PageWrapper;
import com.sogeti.webshop.model.Order;
import com.sogeti.webshop.services.IOrderService;
import com.sogeti.webshop.services.IUserService;

/**
 * Controller handling operations related to Users model.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 18, 2014, Sogeti B.V.
 */
@Controller
public class OrderController
{

   /** The order service. */
   @Autowired
   private IOrderService orderService;

   @Autowired
   private IUserService userService;


   /**
    * Finds & shows all the order records in the system.
    *
    * @param pageable the pageable
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/orders", method=RequestMethod.GET)
   public String list(Pageable pageable, Model model) 
   {
      PageWrapper<Order> page = new PageWrapper<Order>(this.orderService.findAll(pageable),"orders.htm");
      model.addAttribute("page", page);
      return "orders/list";
   }

   /**
    * Shows order details.
    *
    * @param userId the order id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/orders/show", method=RequestMethod.GET)
   public String show(@RequestParam("order_id") Long orderId, Model model)
   {
      Order order = this.orderService.findById(orderId);
      model.addAttribute("order", order);
      model.addAttribute("statuses", Status.values());
      return "orders/show";
   }


   /**
    * Edits the order.
    *
    * @param userId the order id
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/orders/edit", method=RequestMethod.GET)
   public String edit(@RequestParam(value="order_id") long orderId, Model model)
   {
      Order order = this.orderService.findById(orderId);
      model.addAttribute("order", order);
      return "orders/edit";
   }

   /**
    * Updates order in the system.
    *
    * @param order the order
    * @param model the model
    * @return the string
    */
   @RequestMapping(value="/orders/edit", method=RequestMethod.POST)
   public String update(@ModelAttribute(value="order") Order order, Model model)
   {
      this.orderService.update(order);
      return "redirect:/orders.htm";
   }

   /**
    * Inits the binder.
    *
    * @param binder the binder
    * @throws Exception the exception
    **/
   @InitBinder
   protected void initBinder(WebDataBinder binder) throws Exception
   {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      binder.registerCustomEditor(Date.class, "orderDate", new CustomDateEditor(dateFormat, false));

     /* binder.registerCustomEditor(User.class,"user", new PropertyEditorSupport() 
      {
         public String getAsText() {
            return ((User)getValue()).getId().toString();
         }
         
         public void setAsText(String text) 
         {
            User user = userService.findById(Long.parseLong(text));
            setValue(user);
         }
      });*/
   }

}
