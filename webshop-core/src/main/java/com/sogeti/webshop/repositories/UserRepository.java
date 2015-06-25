/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 7, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.webshop.model.User;

/**
 * Repository for getting user details
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 7, 2014, Sogeti B.V.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
   
   /**
    * Find by username.
    *
    * @param username the username
    * @return the user
    */
   public User findByUsername(String username);
   
}
