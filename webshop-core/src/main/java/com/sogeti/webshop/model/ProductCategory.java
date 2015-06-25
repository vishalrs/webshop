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

package com.sogeti.webshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The Class ProductCategory. An entity class which maintains the information of Product Category
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jun 27, 2014, Sogeti B.V.
 */ 
@Entity
@Table(name = "product_categories")
public class ProductCategory implements Serializable
{

   //--------------------------------------------------Members------------------------------------------------------//
   
   /**
    * <code>serialVersionUID</code> indicates/is used for serialVersionUID.
    */
   private static final long serialVersionUID = 7075733112145419416L;

   /** The id. */
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;

   /** The name. */
   @NotNull
   @Column(length = 100)
   private String name;

   //------------------------------------------------Constructors----------------------------------------------------//

   /**
    * Constructor: Default constructor.
    */
   public ProductCategory()
   {

   }

   /**
    * Instantiates a new product category.
    * 
    * @param categoryName the new category name
    */
   public ProductCategory(String categoryName)
   {
      this.name = categoryName;
   }

   //------------------------------------------------Getter/Setters--------------------------------------------------//
   /**
    * Gets the id.
    * 
    * @return the id
    */
   public Long getId()
   {
      return this.id;
   }

   /**
    * Sets the id.
    * 
    * @param id the new id
    */
   public void setId(Long id)
   {
      this.id = id;
   }

   /**
    * Gets the name.
    * 
    * @return the name
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Sets the name.
    * 
    * @param name the new name
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
      return result;
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (obj == null)
      {
         return false;
      }
      if (!(obj instanceof ProductCategory))
      {
         return false;
      }
      ProductCategory other = (ProductCategory) obj;
      if (this.name == null)
      {
         if (other.name != null)
         {
            return false;
         }
      } 
      else if (!this.name.equals(other.name))
      {
         return false;
      }
      return true;
   }

}
