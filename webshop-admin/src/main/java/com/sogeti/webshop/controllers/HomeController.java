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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * The Class HomeController.
 * 
 * {Purpose of This Class}
 *  
 * {Other Notes Relating to This Class (Optional)}
 *  
 */
@Controller
public class HomeController
{

   /** The Constant logger. */
   private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
      
   /**
    * Home.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value = "/home", method = RequestMethod.GET)
   public String home(Model model)
   {
      return "home";
   }
   
   /**
    * Login.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login(Model model) {
       return "login";
   }
   
}
