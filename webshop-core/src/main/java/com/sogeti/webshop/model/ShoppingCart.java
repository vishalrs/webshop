/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 4, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Shopping cart value object storing product & calculating order total details
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 4, 2014, Sogeti B.V.
 */
public class ShoppingCart
{
   
   //--------------------------------------------------Members------------------------------------------------------//
   /**
    * <code>products</code> indicates/is used for selected products by customer.
    */
   private Map<Product, Long> products;
   
   
   //--------------------------------------------------Constructors-------------------------------------------------//
   
   /**
    * Instantiates a new shopping cart.
    */
   public ShoppingCart()
   {
      this.products = new HashMap<Product, Long>();
   }
   
   
   //--------------------------------------------------Getter/Setters-----------------------------------------------//
   
   /**
    * Adds the product to the cart.
    *
    * @param product the product
    * @param qty the qty
    */
   public void addProduct(Product product, Long qty)
   {
      if(product!=null) 
      {
         this.products.put(product, qty);
      }
   }
   
   /**
    * Removes the product from the cart.
    *
    * @param product the product
    */
   public void removeProduct(Product product)
   {
       this.products.remove(product);
   }
   
    /**
    * Get the products.
    *
    * @return Returns the products as a List<Product>.
    */
   public Map<Product, Long> getProducts()
   {
      return this.products;
   }

   /**
    * Set the products to the specified value.
    *
    * @param products The products to set.
    */
   public void setProducts(Map<Product, Long> products)
   {
      this.products = products;
   }

   /**
    * Get the orderTotal for the products in the cart.
    *
    * @return Returns the orderTotal as a BigDecimal.
    */
   public BigDecimal getOrderTotal()
   {
      BigDecimal orderTotal = BigDecimal.ZERO;
      for (Entry<Product, Long> product : this.products.entrySet()) 
      {
         Product key = product.getKey();
         BigDecimal totalProductPrice = key.getPrice().multiply(BigDecimal.valueOf(product.getValue()));
         orderTotal = orderTotal.add(totalProductPrice);
      }
      return orderTotal;
   }
}
