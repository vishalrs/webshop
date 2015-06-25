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
package com.sogeti.webshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.webshop.model.Order;
import com.sogeti.webshop.model.User;
import com.sogeti.webshop.repositories.OrderRepository;
import com.sogeti.webshop.services.IOrderService;

/**
 * Implementation class for IOrderService
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 8, 2014, Sogeti B.V.
 */
@Service
public class OrderServiceImpl implements IOrderService
{
   
   /**
    * <code>orderRepository</code> indicates/is used for getting order data.
    */
   @Autowired
   private OrderRepository orderRepository;

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IOrderService#create(com.sogeti.webshop.model.Order)
    */
   @Override
   @Transactional
   public Order create(Order newOrder)
   {
      Order order  = this.orderRepository.save(newOrder);
      return order;
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IOrderService#findAll()
    */
   @Override
   @Transactional(readOnly = true)
   public List<Order> findAll()
   {
      return this.orderRepository.findAll();
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IOrderService#findById(java.lang.Long)
    */
   @Override
   @Transactional(readOnly = true)
   public Order findById(Long id)
   {
      return this.orderRepository.findOne(id);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IOrderService#findByUser(com.sogeti.webshop.model.User)
    */
   @Override
   @Transactional(readOnly = true)
   public List<Order> findByUser(User user)
   {
      return this.orderRepository.findByUser(user);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IOrderService#findByOrderNo(java.lang.String)
    */
   @Override
   @Transactional(readOnly = true)
   public Order findByOrderNo(String orderNo)
   {
      return this.orderRepository.findByOrderNo(orderNo);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IOrderService#update(com.sogeti.webshop.model.Order)
    */
   @Override
   @Transactional
   public Order update(Order order)
   {
      return this.orderRepository.save(order);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IOrderService#findAll(org.springframework.data.domain.Pageable)
    */
   @Override
   @Transactional(readOnly=true)
   public Page<Order> findAll(Pageable pageable)
   {
      return this.orderRepository.findAll(pageable);
   }

}
