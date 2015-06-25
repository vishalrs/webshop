/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 5, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sogeti.webshop.common.enums.Status;
import com.sogeti.webshop.model.Order;
import com.sogeti.webshop.model.OrderLine;
import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.model.ShoppingCart;
import com.sogeti.webshop.model.User;
import com.sogeti.webshop.services.IOrderService;
import com.sogeti.webshop.services.IUserService;

/**
 * Controller which handles all the operations related to order confirmation
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 5, 2014, Sogeti B.V.
 */
@Controller
@SessionAttributes({"cart"})
public class OrderController
{

   /**
    * <code>userRepository</code> is used for getting details of users.
    */
   @Autowired 
   private IUserService userService;

   /**
    * <code>orderService</code> is used for calling operations related orders.
    */
   @Autowired 
   private IOrderService orderService;

   /**
    * Displays the checkout page with cart details.
    *
    * @param cart the cart
    * @param model the model
    * @return the string
    */
   @RequestMapping("order/checkout")
   public String checkout(@ModelAttribute("cart") ShoppingCart cart, Model model)
   {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if(authentication !=null)
      {
         String username = authentication.getName();
         User authUser = this.userService.findByUsername(username);
         if (authUser !=null) 
         {
            model.addAttribute("auth_user", authUser);
         }

      }
      model.addAttribute("cart", cart);
      return "order/checkout";
   }

   /**
    * Cancels the checkout operation.
    *
    * @return the string
    */
   @RequestMapping("order/cancel")
   public String cancelCheckout()
   {
      return "redirect:/home.htm";
   }

   /**
    * Handler method handling confirmation of the order.
    *
    * @param req the req
    * @param cart the cart
    * @param model the model
    * @return the string
    */
   @RequestMapping("order/confirm")
   public String confirmOrder(HttpServletRequest req, @ModelAttribute("cart") ShoppingCart cart, Model model)
   {
      Long userId = Long.valueOf(req.getParameter("id"));
      User user = this.userService.findById(userId);

      Order order = new Order(new Date(), req.getParameter("address"), req.getParameter("city"), req.getParameter("pin"),Status.CONFIRMED, user);
      for (Entry<Product, Long> product : cart.getProducts().entrySet()) 
      {
         Product key = product.getKey();
         OrderLine line = new OrderLine(key, 1L, key.getPrice());
         order.addOrderLine(line);
      }

      Order orderCreated = this.orderService.create(order);
      model.addAttribute("order_no", orderCreated.getOrderNo());
      return "order/order_confirm";
   }

   /**
    * Gets the order history.
    *
    * @param name the name
    * @param model the model
    * @return the order history
    */
   @RequestMapping(value="order/history")
   public String getOrderHistory(@RequestParam(value = "name") String name, Model model)
   {
      User user = this.userService.findByUsername(name);
      List<Order> orders = this.orderService.findByUser(user);
      model.addAttribute("history_orders", orders);
      return "order/history";
   }
   
   /**
    * Gets the order details.
    *
    * @param orderNo the order no
    * @param model the model
    * @return the order details
    */
   @RequestMapping(value="order/details")
   public String getOrderDetails(@RequestParam(value="orderno") String orderNo, Model model)
   {
      Order order = this.orderService.findByOrderNo(orderNo);
      model.addAttribute("order", order);
      return "order/order_details";
   }
}
