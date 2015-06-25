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
package com.sogeti.webshop.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.webshop.model.Role;
import com.sogeti.webshop.repositories.UserRepository;

/**
 * A custom {@link UserDetailsService} where user information
 * is retrieved from a JPA repository
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 7, 2014, Sogeti B.V.
 */
@Service
@Transactional(readOnly = true)
public class SecurityServiceImpl implements UserDetailsService
{
   
   /** The Constant LOGGER. */
   private static final Logger LOGGER = LoggerFactory.getLogger(SecurityServiceImpl.class);


   /**
    * <code>userRepository</code> is used for querying the user repository.
    */
   @Autowired
   private UserRepository userRepository;
   
      
   /*
    * (non-Javadoc)
    * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
    */
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
   {
      
      try
      {
         LOGGER.debug("Retrieving user given username: " + username);
         com.sogeti.webshop.model.User domainUser = this.userRepository.findByUsername(username);
         boolean enabled = domainUser.getAccountEnabled();
         boolean accountNonExpired = true;
         boolean credentialsNonExpired = true;
         boolean accountNonLocked = true;
         return new User(
               domainUser.getUsername(), 
               domainUser.getPassword(),
               enabled,
               accountNonExpired,
               credentialsNonExpired,
               accountNonLocked,
               this.getGrantedAuthorities(domainUser.getRoles()));
      }
      catch(UsernameNotFoundException e)
      {
         LOGGER.error("Error occured while retrieving user by username:" + e.toString());
         throw new RuntimeException(e);
      }
   }
   
   /**
    * Gets the granted authorities.
    *
    * @param roles the roles
    * @return the granted authorities
    */
   private List<GrantedAuthority> getGrantedAuthorities(List<Role> roles) 
   {
      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
      for (Role role : roles) 
      {
         authorities.add(new SimpleGrantedAuthority(role.getName()));
      }
      return authorities;
   }

}
