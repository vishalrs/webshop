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
package com.sogeti.webshop.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sogeti.webshop.model.ProductCategory;

/**
 * The Interface IProductCategoryService.
 * 
 *  Declares methods used to obtain and modify product category information.
 *  *
 *  @author Vishal.Shinde
 *  @version 1.0.0
 */
public interface IProductCategoryService
{
   
   /**
    * Creates a new product category.
    *
    * @param productCategory the product category
    * @return the product category
    */
   ProductCategory create(ProductCategory productCategory);
   
   /**
    * Updates an existing product category.
    *
    * @param productCategory the product category
    * @return the product category
    */
   ProductCategory update(ProductCategory productCategory);
   
   /**
    * Deletes the category from system.
    *
    * @param id the id
    * @return the long
    */
   Long delete(Long id);
   
   /**
    * Finds all the product category in the system.
    *
    * @return the list
    */
   List<ProductCategory> findAll();
   
   /**
    * Finds a product category by id.
    *
    * @param id the id
    * @return the product category
    */
   ProductCategory findById(Long id);
   

   /**
    * Finds the product category by name.
    *
    * @param name the name
    * @return the product category
    */
   ProductCategory findByName(String name);
   
   /**
    * Finds all the category pagewise.
    *
    * @param pageable the pageable
    * @return the page
    */
   Page<ProductCategory> findAll(Pageable pageable);

}
