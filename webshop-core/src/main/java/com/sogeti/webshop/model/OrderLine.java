/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 8, 2014 Sogeti Nederland B.V. All Rights Reserved.
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The entity representing order line.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 8, 2014, Sogeti B.V.
 */
@Entity
@Table(name="order_lines")
public class OrderLine implements Serializable
{
   
   
   //--------------------------------------------------Members------------------------------------------------------//

   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = -6689465124754514896L;

   /**
    * <code>id</code> indicates the unique id associated with order line.
    */
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   
   /**
    * <code>qty</code> indicates the quantity ordered.
    */
   private Long qty;
   
   /**
    * <code>price</code> indicates the price at which the product was ordered for.
    */
   @Column(precision = 8, scale = 2)
   private BigDecimal price;
   
   /**
    * <code>product</code> indicates the product belonging to the orderline.
    */
   @ManyToOne
   @JoinColumn(name="product_id")
   private Product product;
   

   //--------------------------------------------------Members------------------------------------------------------//
   
   /**
    * Constructor: create a new OrderLine.
    */
   public OrderLine()
   {
      
   }
   
   
   /**
    * Instantiates a new order line.
    *
    * @param product the product
    * @param qty the qty
    * @param price the price
    */
   public OrderLine(Product product, Long qty, BigDecimal price)
   {
      this.qty = qty;
      this.price = price;
      this.product = product;
   }

   //--------------------------------------------------Getters/Setters------------------------------------------------//

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
    * Get the qty.
    *
    * @return Returns the qty as a Long.
    */
   public Long getQty()
   {
      return this.qty;
   }


   /**
    * Set the qty to the specified value.
    *
    * @param qty The qty to set.
    */
   public void setQty(Long qty)
   {
      this.qty = qty;
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
    * Get the product.
    *
    * @return Returns the product as a Product.
    */
   public Product getProduct()
   {
      return this.product;
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
