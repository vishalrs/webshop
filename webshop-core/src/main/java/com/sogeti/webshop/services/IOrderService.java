/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 8, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sogeti.webshop.model.Order;
import com.sogeti.webshop.model.User;

/**
 * Service interface for handling order related operations
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 8, 2014, Sogeti B.V.
 */
public interface IOrderService
{
   
   /**
    * Creates the new customer order.
    *
    * @param order the order
    * @return the order
    */
   Order create(Order order);
   
   /**
    * alters the order.
    *
    * @param order the order
    * @return the order
    */
   Order update(Order order);
   
   /**
    * Finds all the orders for a given customer.
    *
    * @return the list
    */
   List<Order> findAll();
   
   /**
    * Find by id.
    *
    * @param id the id
    * @return the order
    */
   Order findById(Long id);
   
   /**
    * Finds orders confirmed by customer.
    *
    * @param user the user
    * @return the list
    */
   List<Order> findByUser(User user);
   
   
   /**
    * Find by order no.
    *
    * @param orderNo the order no
    * @return the order
    */
   Order findByOrderNo(String orderNo);
   
   /**
    * Finds all the order pagewise.
    *
    * @param pageable the pageable
    * @return the page
    */
   Page<Order> findAll(Pageable pageable);
}
