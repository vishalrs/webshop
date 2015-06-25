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
package com.sogeti.webshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * The Class Product. An entity class which maintains the information of each Product
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jun 30, 2014, Sogeti B.V.
 */
@Entity
@Table(name="products")
public class Product implements Serializable
{

   //--------------------------------------------------Members------------------------------------------------------//
   
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = -3167122723956766619L;
   
   /** The id of the product. */
   @Id
   @GeneratedValue (strategy = GenerationType.AUTO)
   private Long id;
   
   
   /** The unique code of the product. */
   @Column(length = 36, unique = true)
   private final String code;
   
   /** The name of the product. */
   @NotNull
   @Column(length = 255)
   private String name;
   
   /** The description of the product. */
   @Column(length = 3000)
   private String description;
   
   /** The price of the product. */
   @NotNull
   @Digits(integer=8, fraction=2)
   @Column (precision = 8, scale = 2)
   private BigDecimal price;
   
   /**
    * <code>productCategory</code> indicates/is used for associating product category with this product.
    */
   @ManyToOne
   @JoinColumn(name="product_category_id")
   private ProductCategory productCategory;
   
   //------------------------------------------------Constructors----------------------------------------------------//

   /**
    * Constructor: Default constructor.
    */
   public Product()
   {
      this.code = UUID.randomUUID().toString().toUpperCase();
   }
   
   /**
    * Constructor: create a new Product.
    *
    * @param name the name
    * @param description the description
    * @param price the price
    */
   public Product(String name, String description, BigDecimal price)
   {
      this.code = UUID.randomUUID().toString().toUpperCase();
      this.name = name;
      this.description = description;
      this.price = price;
   }
   
   /**
    * Constructor: create a new Product.
    * @param productCategory
    * @param name
    * @param description
    * @param price
    */
   public Product(ProductCategory productCategory, String name, String description, BigDecimal price)
   {
      this.code = UUID.randomUUID().toString().toUpperCase();
      this.name = name;
      this.description = description;
      this.price = price;
   }
   
   //------------------------------------------------Getter/Setters--------------------------------------------------//

   /**
    * Get the id.
    *
    * @return Returns the id as a Long.
    */
   public Long getId()
   {
      return this.id;
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
    * Gets the code.
    *
    * @return the code
    */
   public String getCode()
   {
      return this.code;
   }

   /**
    * Get the name.
    *
    * @return Returns the name as a String.
    */
   public String getName()
   {
      return this.name;
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
      return this.description;
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
    * Get the price.
    *
    * @return Returns the price as a BigDecimal.
    */
   public BigDecimal getPrice()
   {
      return this.price;
   }

   /**
    * Set the price to the specified value.
    *
    * @param price The price to set.
    */
   public void setPrice(BigDecimal price)
   {
      this.price = price;
   }

   /**
    * Get the productCategory.
    *
    * @return Returns the productCategory as a ProductCategory.
    */
   public ProductCategory getProductCategory()
   {
      return this.productCategory;
   }

   /**
    * Set the productCategory to the specified value.
    *
    * @param productCategory The productCategory to set.
    */
   public void setProductCategory(ProductCategory productCategory)
   {
      this.productCategory = productCategory;
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
      result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
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
      if (!(obj instanceof Product))
      {
         return false;
      }
      Product other = (Product) obj;
      if (this.code == null)
      {
         if (other.code != null)
         {
            return false;
         }
      }
      else if (!this.code.equals(other.code))
      {
         return false;
      }
      return true;
   }

}
