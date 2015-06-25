/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 10, 2014 Sogeti Nederland B.V. All Rights Reserved.
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

import com.sogeti.webshop.model.User;

/**
 * Service interface to manage user entities
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 10, 2014, Sogeti B.V.
 */
public interface IUserService
{
   
   /**
    * Creates a new user in the system.
    *
    * @param user the user
    * @return the user
    */
   User create(User user);
   
   /**
    * Updates the user information in the system.
    *
    * @param user the user
    * @return the user
    */
   User update(User user);
   
   /**
    * Deletes the user from the system.
    *
    * @param id the id
    * @return the long
    */
   Long delete(Long id);
   
   /**
    * Finds all the user in the system.
    *
    * @return the list
    */
   List<User> findAll();
   
   /**
    * Finds the user by id.
    *
    * @param id the id
    * @return the user
    */
   User findById(Long id);
   
   /**
    * Find by username.
    *
    * @param username the username
    * @return the user
    */
   User findByUsername(String username);

   /**
    * Find all the users records by page.
    *
    * @param pageable the pageable
    * @return the list
    */
   Page<User> findAll(Pageable pageable);
}
