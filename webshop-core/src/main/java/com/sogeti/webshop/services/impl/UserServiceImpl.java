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
package com.sogeti.webshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.webshop.model.User;
import com.sogeti.webshop.repositories.UserRepository;
import com.sogeti.webshop.services.IUserService;

/**
 * Service implementation class for managing users
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 10, 2014, Sogeti B.V.
 */
@Service
public class UserServiceImpl implements IUserService
{
   
      
   /**
    * <code>userRepository</code> indicates/is used for operations regarding user entities.
    */
   @Autowired
   private UserRepository userRepository;
   
   /** The password encoder. */
   @Autowired
   private PasswordEncoder passwordEncoder;
   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IUserService#create(com.sogeti.webshop.model.User)
    */
   @Override
   @Transactional
   public User create(User user)
   {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      return this.userRepository.save(user);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IUserService#findAll()
    */
   @Override
   @Transactional(readOnly = true)
   public List<User> findAll()
   {
      return this.userRepository.findAll();
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IUserService#findById(java.lang.Long)
    */
   @Override
   @Transactional(readOnly = true)
   public User findById(Long id)
   {
      return this.userRepository.findOne(id);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IUserService#findByUsername(java.lang.String)
    */
   @Override
   @Transactional(readOnly = true)
   public User findByUsername(String username)
   {
      return this.userRepository.findByUsername(username);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IUserService#findAll(int)
    */
   @Override
   @Transactional(readOnly = true)
   public Page<User> findAll(Pageable pageable)
   {
       return this.userRepository.findAll(pageable);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IUserService#delete(java.lang.Long)
    */
   @Override
   @Transactional
   public Long delete(Long id)
   {
      this.userRepository.delete(id);
      return id;
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IUserService#update(com.sogeti.webshop.model.User)
    */
   @Override
   @Transactional
   public User update(User user)
   {
      return this.userRepository.save(user);
   }

}
