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
package com.sogeti.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.model.ProductCategory;



/**
 * The Interface ProductRepository.
 * 
 * Specifies methods used to obtain and modify product related information
 * which is stored in the database
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jun 30, 2014, Sogeti B.V.
 */
public interface ProductRepository extends JpaRepository<Product, Long>
{
   
   /**
    * Find by code.
    *
    * @param code the code
    * @return the product
    */
   public Product findByCode(String code);
   
   /**
    * Find by name.
    *
    * @param name the name
    * @return the product
    */
   @Query("SELECT p FROM Product p WHERE LOWER(p.name) like LOWER(concat('%',:name,'%'))")
   public List<Product> findByName(@Param("name") String name);
   
   /**
    * Find by product category.
    *
    * @param productCategory the product category
    * @return the list
    */
   public List<Product> findByProductCategory(ProductCategory productCategory);
   
   /**
    * Find by description.
    *
    * @param desc the desc
    * @return the list
    */
   @Query("SELECT p FROM Product p WHERE LOWER(p.description) like LOWER(concat('%',:desc,'%'))")
   public List<Product> findByDescription(@Param("desc") String desc);

}
