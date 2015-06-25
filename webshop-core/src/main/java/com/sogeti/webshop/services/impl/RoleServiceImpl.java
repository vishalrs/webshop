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
package com.sogeti.webshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.webshop.model.Role;
import com.sogeti.webshop.repositories.RoleRepository;
import com.sogeti.webshop.services.IRoleService;

/**
 * Service implementation for Role Service interface
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 11, 2014, Sogeti B.V.
 */
@Service
public class RoleServiceImpl implements IRoleService
{
   
   /**
    * <code>roleRepository</code> is used for doing operations on role entities.
    */
   @Autowired
   private RoleRepository roleRepository;

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IRoleService#create(com.sogeti.webshop.model.Role)
    */
   @Override
   @Transactional
   public Role create(Role role)
   {
      return this.roleRepository.save(role);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IRoleService#update(com.sogeti.webshop.model.Role)
    */
   @Override
   @Transactional
   public Role update(Role role)
   {
      return this.roleRepository.save(role);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IRoleService#findAll()
    */
   @Override
   @Transactional(readOnly = true)
   public List<Role> findAll()
   {
      return this.roleRepository.findAll();
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IRoleService#findById(java.lang.Long)
    */
   @Override
   @Transactional(readOnly = true)
   public Role findById(Long id)
   {
      return this.roleRepository.findOne(id);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IRoleService#findByName(java.lang.String)
    */
   @Override
   @Transactional(readOnly = true)
   public Role findByName(String name)
   {
      return this.roleRepository.findByName(name);
   }

}
