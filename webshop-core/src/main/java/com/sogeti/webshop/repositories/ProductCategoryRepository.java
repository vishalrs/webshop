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
package com.sogeti.webshop.repositories;

import com.sogeti.webshop.model.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface ProductCategoryRepository.
 * 
 * Specifies methods used to obtain and modify product category related information
 * which is stored in the database
 * 
 * @version $Id:$
 * @author Vishal.Shinde (c) Jun 27, 2014, Sogeti B.V.
 */ 
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>
{
  
   /**
    * Finds the product category by name.
    *
    * @param name the name
    * @return the product category
    */
   public ProductCategory findByName(String name);
   

}
