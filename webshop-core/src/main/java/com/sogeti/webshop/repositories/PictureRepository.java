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
package com.sogeti.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sogeti.webshop.model.Picture;
import com.sogeti.webshop.model.Product;

/**
 * Repository to manage picture's entities
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 22, 2014, Sogeti B.V.
 */
public interface PictureRepository extends JpaRepository<Picture, Long>
{
   
   /**
    * Find by product.
    *
    * @param product the product
    * @return the list
    */
   List<Picture> findByProduct(Product product);
}
