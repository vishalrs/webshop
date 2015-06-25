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
package com.sogeti.webshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.webshop.model.Picture;
import com.sogeti.webshop.model.Product;
import com.sogeti.webshop.repositories.PictureRepository;
import com.sogeti.webshop.services.IPictureService;

/**
 * Service implementation for Picture entity
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 22, 2014, Sogeti B.V.
 */
@Service
public class PictureServiceImpl implements IPictureService
{
   
   @Autowired 
   private PictureRepository pictureRepository;

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IPictureService#create(com.sogeti.webshop.model.Picture)
    */
   @Override
   @Transactional
   public Picture create(Picture picture)
   {
      return this.pictureRepository.save(picture);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IPictureService#update(com.sogeti.webshop.model.Picture)
    */
   @Override
   @Transactional
   public Picture update(Picture picture)
   {
      return this.pictureRepository.save(picture);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IPictureService#delete(java.lang.Long)
    */
   @Override
   @Transactional
   public Long delete(Long id)
   {
      this.pictureRepository.delete(id);
      return id;
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IPictureService#findAll()
    */
   @Override
   @Transactional(readOnly = true)
   public List<Picture> findAll()
   {
      return this.pictureRepository.findAll();
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IPictureService#findAll(org.springframework.data.domain.Pageable)
    */
   @Override
   @Transactional(readOnly = true)
   public Page<Picture> findAll(Pageable pageable)
   {
      return this.pictureRepository.findAll(pageable);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IPictureService#findById(java.lang.Long)
    */
   @Override
   @Transactional(readOnly = true)
   public Picture findById(Long id)
   {
      return this.pictureRepository.findOne(id);
   }

   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IPictureService#findPictureForProduct(com.sogeti.webshop.model.Product)
    */
   @Override
   @Transactional(readOnly = true)
   public List<Picture> findByProduct(Product product)
   {
      return this.pictureRepository.findByProduct(product);
   }

}
