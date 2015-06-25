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

import java.math.BigDecimal;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.model.ProductCategory;
import com.sogeti.webshop.services.IProductCategoryService;
import com.sogeti.webshop.services.IProductService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;



/**
 * Test class for unit testing Product productService
 * 
 * @version $Id:$
 * @author vshinde (c) Jun 27, 2014, Sogeti B.V.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class ProductTest
{

   /**
    * <code>Product productService</code> indicates/is used for performing product entity related operations.
    */
   @Autowired
   private IProductService productService;

   /**
    * <code>productCategoryService</code> indicates/is used for performing product category entity related operations.
    */
   @Autowired
   private IProductCategoryService productCategoryService;
   
   /**
    * Test creation of an product entity.
    */
   @Test
   public void testCreate()
   {
      Product product = new Product("Pink Floyd", "Music Album of  Pink Floyd", new BigDecimal(20.00));
      product = this.productService.create(product);
      Long id = product.getId();
      Assert.assertNotNull(id);
      
      Product newProduct = this.productService.findById(id);
      Assert.assertEquals("Pink Floyd", newProduct.getName());
   }

   /**
    * Testing creation of product entity attached to a product category
    */
   @Test
   public void testCreateWithProductCategory()
   {
      
      ProductCategory productCategory_Music = new ProductCategory("Music");
      productCategory_Music = this.productCategoryService.create(productCategory_Music);
      
      Product product = new Product(productCategory_Music, "Pink Floyd", "Music Album of  Pink Floyd", new BigDecimal(20.00));
      product = this.productService.create(product);
      Long id = product.getId();
      Assert.assertNotNull(id);
      
      Product newProduct = this.productService.findById(id);
      Assert.assertEquals("Pink Floyd", newProduct.getName());
   }

   /**
    * Test updation of an product entity.
    */
   @Test
   public void testUpdate()
   {
      Product product = new Product("Pink Floyd", "Music Album of  Pink Floyd", new BigDecimal(10.00));
      product = this.productService.create(product);
      Long id = product.getId();
      Assert.assertNotNull(id);
      
      Product updateProduct = this.productService.findById(id);
      updateProduct.setDescription("Complete Music Album of  Pink Floyd");
      this.productService.update(updateProduct);
      
      Product updatedProduct = this.productService.findById(id);
      Assert.assertEquals("Complete Music Album of  Pink Floyd", updatedProduct.getDescription());
      
   }
   
   /**
    * Test getting a product category by id.
    */
   @Test
   public void testFindById() 
   {
      Product product = new Product("Pink Floyd", "Music Album of  Pink Floyd", new BigDecimal(10.00));
      product = this.productService.create(product);
      Long id = product.getId();
      Assert.assertNotNull(id);
      
      Product storedProduct = this.productService.findById(id);
      Assert.assertEquals(id, storedProduct.getId());      
   }
   
   /**
    * Test getting all the product stored 
    */
   @Test
   public void testFindAll()
   {
      Product product1 = new Product("Pink Floyd", "Music Album of  Pink Floyd", new BigDecimal(10.00));
      Product product2 = new Product("Michael Jackson", "Album: Dangerous", new BigDecimal(30.40));
      Product product3 = new Product("Sound of Music", "A musical film", new BigDecimal(40.00));
      this.productService.create(product1);
      this.productService.create(product2);
      this.productService.create(product3);

      List<Product> productCategories = this.productService.findAll();
      Assert.assertEquals(3, productCategories.size());
   }

   
   /**
    * Test getting a product by name. 
    */
   @Test
   public void testFindByName()
   {
      Product product1 = new Product("Pink Floyd", "Music Album of  Pink Floyd", new BigDecimal(10.00));
      Product product2 = new Product("Michael Jackson", "Album: Dangerous", new BigDecimal(30.40));
      Product product3 = new Product("Sound of Music", "A musical film", new BigDecimal(40.00));
      this.productService.create(product1);
      this.productService.create(product2);
      this.productService.create(product3);

      List<Product> products = this.productService.findByName("Music");
      Assert.assertEquals(1, products.size());
   }
   
   /**
    * Test finding a product by name which does not exist.
    */
   @Test
   public void testFindProductByNameReturnNone()
   {
      Product product1 = new Product("Pink Floyd", "Music Album of  Pink Floyd", new BigDecimal(10.00));
      Product product2 = new Product("Michael Jackson", "Album: Dangerous", new BigDecimal(30.40));
      Product product3 = new Product("Sound of Music", "A musical film", new BigDecimal(40.00));
      this.productService.create(product1);
      this.productService.create(product2);
      this.productService.create(product3);

      List<Product> products = this.productService.findByName("Sting");
      Assert.assertEquals(0, products.size());
   }


   /**
    * Test to validate the Product with name as blank
    */
   @Test
   public void testCreatingProductWithNameNull() 
   {
      try
      {
         this.productService.create(new Product("", "Null product", new BigDecimal(0.00)));
      }
      catch(ConstraintViolationException e)
      {
         Assert.assertEquals(1, e.getConstraintViolations().size());
         ConstraintViolation<?> violation = e.getConstraintViolations().iterator().next();
         Assert.assertEquals("name", violation.getPropertyPath().toString());
      }
   }

}
