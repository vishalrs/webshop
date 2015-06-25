/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jun 30, 2014 Sogeti Nederland B.V. All Rights Reserved.
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

import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.model.ProductCategory;
import com.sogeti.webshop.repositories.ProductRepository;
import com.sogeti.webshop.services.IProductService;


/**
 * Implementaiton of Product Service Interface
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jun 30, 2014, Sogeti B.V.
 */
@Service
public class ProductServiceImpl implements IProductService
{

   /**
    * <code>LOGGER</code> indicates/is used for logging outputs.
    */
   private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

   /**
    * <code>repository</code> indicates/is used for carrying db related operations.
    */
   @Autowired
   private ProductRepository repository;

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#create(com.sogeti.webshop.model.Product)
    */
   @Override
   @Transactional
   public Product create(Product product)
   {
      LOGGER.debug("Creating a new product with information: " + product);
      return this.repository.save(product);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#update(com.sogeti.webshop.model.Product)
    */
   @Override
   @Transactional
   public Product update(Product product)
   {
      LOGGER.debug("Updating an existing product with information: " + product);
      return this.repository.save(product);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#findAll()
    */
   @Override
   @Transactional(readOnly = true)
   public List<Product> findAll()
   {
      LOGGER.debug("Getting all the products registered in the system...");
      return this.repository.findAll();
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#findById(java.lang.Long)
    */
   @Override
   @Transactional(readOnly = true)
   public Product findById(Long id)
   {
      LOGGER.debug("Finding the product with the Id:" + id);
      return this.repository.findOne(id);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#findByName(java.lang.String)
    */
   @Override
   @Transactional(readOnly = true)
   public List<Product> findByName(String name)
   {
      LOGGER.debug("Finding the product by name :" + name);
      return this.repository.findByName(name);
   }
   
   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#findByCode(java.lang.String)
    */
   @Override
   @Transactional(readOnly = true)
   public Product findByCode(String code)
   {
      LOGGER.debug("Finding the product by code :" + code);
      return this.repository.findByCode(code);
   }
   

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#findByProductCategory(com.sogeti.webshop.model.ProductCategory)
    */
   @Override
   @Transactional(readOnly = true)
   public List<Product> findByProductCategory(ProductCategory productCategory)
   {
      LOGGER.debug("Finding the product by product category :" + productCategory.getName());
      return this.repository.findByProductCategory(productCategory);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#findByDescription(java.lang.String)
    */
   @Override
   @Transactional(readOnly = true)
   public List<Product> findByDescription(String desc)
   {
      LOGGER.debug("Finding the product by product description :" + desc);
      return this.repository.findByDescription(desc);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#findAll(org.springframework.data.domain.Pageable)
    */
   @Override
   @Transactional(readOnly = true)
   public Page<Product> findAll(Pageable pageable)
   {
      return this.repository.findAll(pageable);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IProductService#delete(java.lang.Long)
    */
   @Override
   @Transactional
   public Long delete(Long id)
   {
      this.repository.delete(id);
      return id;
   }

}
