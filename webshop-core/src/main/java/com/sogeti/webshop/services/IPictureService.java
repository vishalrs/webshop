/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 22, 2014 Sogeti Nederland B.V. All Rights Reserved.
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

import com.sogeti.webshop.model.Picture;
import com.sogeti.webshop.model.Product;

/**
 * Service to handle operations on picture entity.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 22, 2014, Sogeti B.V.
 */
public interface IPictureService
{
   
   /**
    * Creates the picture entity.
    *
    * @param picture the picture
    * @return the picture
    */
   Picture create(Picture picture);
   
   /**
    * Updates an existing picture for a given product.
    *
    * @param picture the picture
    * @return the picture
    */
   Picture update(Picture picture);
   
   /**
    * Deletes the picture from the repository.
    *
    * @param id the id
    * @return the picture
    */
   Long delete(Long id);
   
   /**
    * Finds all the picture in the system.
    *
    * @return the list
    */
   List<Picture> findAll();
   
   /**
    * Find all the picture page wise.
    *
    * @param pageable the pageable
    * @return the list
    */
   Page<Picture> findAll(Pageable pageable);
   
   /**
    * Finds the picture given an id.
    *
    * @param id the id
    * @return the picture
    */
   Picture findById(Long id);
   
   /**
    * Find picture for product.
    *
    * @param product the product
    * @return the list
    */
   List<Picture> findByProduct(Product product);
}
