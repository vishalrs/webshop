/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jun 27, 2014 Sogeti Nederland B.V. All Rights Reserved.
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.webshop.model.ProductCategory;
import com.sogeti.webshop.repositories.ProductCategoryRepository;
import com.sogeti.webshop.services.IProductCategoryService;

/**
 * This implementation of the ProductCategory interface communicates with
 * the database by using a Spring Data JPA repository.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jun 27, 2014, Sogeti B.V.
 */ 
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService
{

   /** The Constant LOGGER. */
   private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

   /** The repository. */
   @Autowired
   ProductCategoryRepository repository;
   
   
   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductCategoryService#create(com.sogeti.webshop.model.ProductCategory)
    */
   @Override
   @Transactional
   public ProductCategory create(ProductCategory productCategory)
   {
      LOGGER.debug("Creating a new product category with information: " + productCategory);
      return this.repository.save(productCategory);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductCategoryService#update(com.sogeti.webshop.model.ProductCategory)
    */
   @Override
   @Transactional
   public ProductCategory update(ProductCategory productCategory)
   {
      LOGGER.debug("Updating an existing product category: " + productCategory.getName());
      return this.repository.saveAndFlush(productCategory);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductCategoryService#findAll()
    */
   @Override
   @Transactional(readOnly = true)
   public List<ProductCategory> findAll()
   {
      LOGGER.debug("Fing all product categories");
      return this.repository.findAll();
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductCategoryService#findById(java.lang.Long)
    */
   @Override
   @Transactional(readOnly = true)
   public ProductCategory findById(Long id)
   {
      LOGGER.debug("Finding product category by id: " + id);
      return this.repository.findOne(id);
   }
   
   

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductCategoryService#findByName(java.lang.String)
    */
   @Override
   @Transactional(readOnly = true)
   public ProductCategory findByName(String name)
   {
      LOGGER.debug("Finding product category by name: " + name);
      return this.repository.findByName(name);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductCategoryService#findAll(org.springframework.data.domain.Pageable)
    */
   @Override
   @Transactional(readOnly = true)
   public Page<ProductCategory> findAll(Pageable pageable)
   {
      return this.repository.findAll(pageable);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductCategoryService#delete(com.sogeti.webshop.model.ProductCategory)
    */
   @Override
   @Transactional
   public Long delete(Long id)
   {
      this.repository.delete(id);
      return id;
   }

}
