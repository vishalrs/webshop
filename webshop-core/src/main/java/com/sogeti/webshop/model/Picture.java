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
package com.sogeti.webshop.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity to manage product pictures.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 22, 2014, Sogeti B.V.
 */
@Entity
@Table(name="product_pictures")
public class Picture implements Serializable
{
   
   //--------------------------------------------------Members------------------------------------------------------//

   
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 479589394734185257L;

   /** The id. */
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   
   /** The name. */
   @NotNull
   @Column(length=50)
   private String name;
   
   /** The description. */
   @Column(length=500)
   private String description;
   
   /** The content. */
   @Lob @Basic(fetch=FetchType.LAZY)
   private Blob content;
   
   /** The content type. */
   @Column(length=100)
   private String contentType;
   
   @ManyToOne
   @JoinColumn(name="product_id")
   private Product product;
   
   //--------------------------------------------------Getters/Setters----------------------------------------------//

   /**
    * Get the id.
    *
    * @return Returns the id as a Long.
    */
   public Long getId()
   {
      return id;
   }

   /**
    * Set the id to the specified value.
    *
    * @param id The id to set.
    */
   public void setId(Long id)
   {
      this.id = id;
   }

   /**
    * Get the name.
    *
    * @return Returns the name as a String.
    */
   public String getName()
   {
      return name;
   }

   /**
    * Set the name to the specified value.
    *
    * @param name The name to set.
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Get the description.
    *
    * @return Returns the description as a String.
    */
   public String getDescription()
   {
      return description;
   }

   /**
    * Set the description to the specified value.
    *
    * @param description The description to set.
    */
   public void setDescription(String description)
   {
      this.description = description;
   }

   /**
    * Get the content.
    *
    * @return Returns the content as a Blob.
    */
   public Blob getContent()
   {
      return content;
   }

   /**
    * Set the content to the specified value.
    *
    * @param content The content to set.
    */
   public void setContent(Blob content)
   {
      this.content = content;
   }

   /**
    * Get the contentType.
    *
    * @return Returns the contentType as a String.
    */
   public String getContentType()
   {
      return contentType;
   }

   /**
    * Set the contentType to the specified value.
    *
    * @param contentType The contentType to set.
    */
   public void setContentType(String contentType)
   {
      this.contentType = contentType;
   }

   /**
    * Get the product.
    *
    * @return Returns the product as a Product.
    */
   public Product getProduct()
   {
      return product;
   }

   /**
    * Set the product to the specified value.
    *
    * @param product The product to set.
    */
   public void setProduct(Product product)
   {
      this.product = product;
   }
   
}
