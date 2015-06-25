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
package com.sogeti.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sogeti.webshop.model.Role;

/**
 * Repository class for managing roles
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 11, 2014, Sogeti B.V.
 */
public interface RoleRepository extends JpaRepository<Role, Long>
{
        
        /**
         * Finds the role by name.
         *
         * @param name the name
         * @return the role
         */
        public Role findByName(String name);
}
