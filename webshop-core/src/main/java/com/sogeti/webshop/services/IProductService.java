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
package com.sogeti.webshop.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.model.ProductCategory;

/**
 * Interface to manage products.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jun 30, 2014, Sogeti B.V.
 */
public interface IProductService
{
   
   
   /**
    * Creates the new product in the system.
    *
    * @param product the product
    * @return the product
    */
   Product create(Product product);
   
   /**
    * Updates an existing product information.
    *
    * @param product the product
    * @return the updated product
    */
   Product update(Product product);
   
   /**
    * Deletes the product from the system.
    *
    * @param id the id
    * @return the product
    */
   Long delete(Long id);
   
   /**
    * Finds all the products in the system.
    *
    * @return the list
    */
   List<Product> findAll();
   
   /**
    * Finds a product category by id.
    *
    * @param id the id
    * @return the product
    */
   Product findById(Long id);
   

   /**
    * Finds the product by name.
    *
    * @param name the name
    * @return the product category
    */
   List<Product> findByName(String name);
   
   
   /**
    * Find by code.
    *
    * @param code the code
    * @return the product
    */
   Product findByCode(String code);
   
   
   /**
    * Find by description.
    *
    * @param desc the desc
    * @return the list
    */
   List<Product> findByDescription(String desc);
   
   /**
    * Find the list of products based on given product category.
    *
    * @param productCategory the product category
    * @return the list
    */
   List<Product> findByProductCategory (ProductCategory productCategory);
   
   /**
    * Finds all the products Pagewise.
    *
    * @param pageable the pageable
    * @return the page
    */
   Page<Product> findAll(Pageable pageable);
   
   
}
