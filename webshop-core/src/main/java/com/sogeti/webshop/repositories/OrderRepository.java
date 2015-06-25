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
package com.sogeti.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sogeti.webshop.model.Order;
import com.sogeti.webshop.model.User;

/**
 * The Interface ProductRepository.
 * 
 * Specifies methods used to obtain and modify order related information
 * which is stored in the database 
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 8, 2014, Sogeti B.V.
 */
public interface OrderRepository extends JpaRepository<Order, Long>
{
   
   /**
    * Find the orders by user.
    *
    * @param user the user
    * @return the list
    */
   public List<Order> findByUser(User user);
   
   /**
    * Find by order no.
    *
    * @param orderNo the order no
    * @return the order
    */
   public Order findByOrderNo(String orderNo);
}
