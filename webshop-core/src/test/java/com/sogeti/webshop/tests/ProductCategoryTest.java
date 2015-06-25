/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: vshinde
 ** Copyright: (c) Jun 27, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.tests;

import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.webshop.model.ProductCategory;
import com.sogeti.webshop.services.IProductCategoryService;



/**
 * Test class for unit testing Product Category service
 * 
 * @version $Id:$
 * @author vshinde (c) Jun 27, 2014, Sogeti B.V.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class ProductCategoryTest
{

   /**
    * <code>service</code> indicates/is used for.
    */
   @Autowired
   IProductCategoryService service;

   
   /**
    * Test creation of an product category entity.
    */
   @Test
   public void testCreate()
   {
      ProductCategory productCategory = new ProductCategory("Music");
      productCategory = this.service.create(productCategory);
      Long id = productCategory.getId();
      Assert.assertNotNull(id);
      
      ProductCategory newProductCategory = this.service.findById(id);
      Assert.assertEquals("Music", newProductCategory.getName());
   }
   
   /**
    * Test updation of an product category entity.
    */
   @Test
   public void testUpdate()
   {
      ProductCategory productCategory = new ProductCategory("Music");
      productCategory = this.service.create(productCategory);
      Long id = productCategory.getId();
      Assert.assertNotNull(id);
      
      ProductCategory updateProductCategory = this.service.findById(id);
      updateProductCategory.setName("Musik");
      this.service.update(updateProductCategory);
      
      
      ProductCategory updatedProductCategory = this.service.findById(id);
      Assert.assertEquals("Musik", updatedProductCategory.getName());
      
   }
   
   /**
    * Test getting a product category by id.
    */
   @Test
   public void testFindById() 
   {
      ProductCategory productCategory = new ProductCategory("Music");
      productCategory = this.service.create(productCategory);
      Long id = productCategory.getId();
      Assert.assertNotNull(id);
      
      ProductCategory storedProductCategory = this.service.findById(id);
      Assert.assertEquals(id, storedProductCategory.getId());      
   }
   
   /**
    * Test getting all the product categories stored 
    */
   @Test
   public void testFindAll()
   {
      ProductCategory productCategory1 = new ProductCategory("Music");
      ProductCategory productCategory2 = new ProductCategory("Furniture");
      ProductCategory productCategory3 = new ProductCategory("Movies");
      this.service.create(productCategory1);
      this.service.create(productCategory2);
      this.service.create(productCategory3);

      List<ProductCategory> productCategories = this.service.findAll();
      Assert.assertEquals(3, productCategories.size());
   }

   
   /**
    * Test getting a product category by name. 
    */
   @Test
   public void testFindByName()
   {
      ProductCategory productCategory1 = new ProductCategory("Music");
      ProductCategory productCategory2 = new ProductCategory("Furniture");
      ProductCategory productCategory3 = new ProductCategory("Movies");
      this.service.create(productCategory1);
      this.service.create(productCategory2);
      this.service.create(productCategory3);

      ProductCategory productCategory = this.service.findByName("Furniture");
      Assert.assertEquals("Furniture", productCategory.getName());
   }
   
   /**
    * Test finding a product category by name which does not exist.
    */
   @Test
   public void testFindProductCategoryByNameReturnNone()
   {
      ProductCategory productCategory1 = new ProductCategory("Music");
      ProductCategory productCategory2 = new ProductCategory("Furniture");
      ProductCategory productCategory3 = new ProductCategory("Movies");
      this.service.create(productCategory1);
      this.service.create(productCategory2);
      this.service.create(productCategory3);

      ProductCategory productCategory = this.service.findByName("Furniture1");
      Assert.assertNull(productCategory);
   }


   /**
    * Test to validate the ProductCategory with name as blank
    */
   @Test
   public void testCreatingProductCategoryWithNameNull() 
   {
      try
      {
         this.service.create(new ProductCategory());
      }
      catch(ConstraintViolationException e)
      {
         Assert.assertEquals(1, e.getConstraintViolations().size());
         ConstraintViolation<?> violation = e.getConstraintViolations().iterator().next();
         Assert.assertEquals("name", violation.getPropertyPath().toString());
      }
   }

}
