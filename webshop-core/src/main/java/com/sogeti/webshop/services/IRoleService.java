/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 11, 2014 Sogeti Nederland B.V. All Rights Reserved.
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

import com.sogeti.webshop.model.Role;

/**
 * Service interface for managing role entities.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 11, 2014, Sogeti B.V.
 */
public interface IRoleService
{
   
   /**
    * Creates the new Role in the system.
    *
    * @param role the role
    * @return the role
    */
   Role create(Role role);
   
   /**
    * Updates an existing role in the system.
    *
    * @param role the role
    * @return the role
    */
   Role update(Role role);
   
   /**
    * Finds all the roles in the system.
    *
    * @return the list
    */
   List<Role> findAll();
   
   /**
    * Finds the Role by id.
    *
    * @param id the id
    * @return the role
    */
   Role findById(Long id);
   
   /**
    * Finds the role by name.
    *
    * @param name the name
    * @return the role
    */
   Role findByName(String name);

}
