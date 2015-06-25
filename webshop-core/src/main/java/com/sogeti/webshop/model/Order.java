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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.sogeti.webshop.common.enums.Status;

/**
 * The entity representing dfd customer order.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 8, 2014, Sogeti B.V.
 */
@Entity
@Table(name="orders")
public class Order implements Serializable
{

   //--------------------------------------------------Members------------------------------------------------------//
   /**
    * <code>serialVersionUID</code> indicates/is used as unique serialVersionUID.
    */
   private static final long serialVersionUID = -6148625327113960995L;
   
   /**
    * <code>id</code> is used as the primary key for the order entity.
    */
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   
   /**
    * <code>orderNo</code> indicates used for unique order no.
    */
   @NotNull
   @Column(name="order_no", length=50)
   private String orderNo;
   
   /**
    * <code>orderDate</code> indicates used for order date.
    */
   @NotNull
   @Column(name="order_date")
   @Temporal(TemporalType.DATE)
   private Date orderDate;
   
   /**
    * <code>shippingAddress</code> is used for shipping address of the customer.
    */
   @NotNull
   @Column(name="shipping_address", length=500)
   private String shippingAddress;
   
   /**
    * <code>shippingCity</code> is used for the city part of the shipping address.
    */
   @NotNull
   @Column(name="shipping_city", length=50)
   private String shippingCity;
   
   /**
    * <code>shippingPin</code> is used for pincode part of the address.
    */
   @NotNull
   @Column(name="shipping_pin", length=10)
   private String shippingPin;
   
   /**
    * <code>status</code> indicates status of the order.
    */
   @Enumerated(EnumType.STRING)
   private Status status;
   
   
   /**
    * <code>user</code> indicates the customer who this order belongs to.
    */
   @ManyToOne
   @JoinColumn(name="user_id")
   private User user;
   
   /**
    * <code>orderLines</code> indicates order lines associated with order.
    */
   @OneToMany (cascade = CascadeType.ALL)
   @JoinColumn(name="order_id")
   private List<OrderLine> orderLines;
   
   //--------------------------------------------------Constructors------------------------------------------------------//
   
   /**
    * Instantiates a new order.
    */
   public Order() 
   {
      this.orderNo = UUID.randomUUID().toString();
   }


   /**
    * Constructor: create a new Order.
    *
    * @param orderDate the order date
    * @param shippingAddress the shipping address
    * @param shippingCity the shipping city
    * @param shippingPin the shipping pin
    * @param status the status
    */
   public Order(Date orderDate, String shippingAddress, String shippingCity, String shippingPin, Status status)
   {
      this.orderNo = UUID.randomUUID().toString();
      this.orderDate = orderDate;
      this.shippingAddress = shippingAddress;
      this.shippingCity = shippingCity;
      this.shippingPin = shippingPin;
      this.status = status;
   }

 
   /**
    * Instantiates a new order.
    *
    * @param orderDate the order date
    * @param shippingAddress the shipping address
    * @param shippingCity the shipping city
    * @param shippingPin the shipping pin
    * @param status the status
    * @param user the user
    */
   public Order(Date orderDate, String shippingAddress, String shippingCity, String shippingPin, Status status, User user)
   {
      this.orderNo = UUID.randomUUID().toString();;
      this.orderDate = orderDate;
      this.shippingAddress = shippingAddress;
      this.shippingCity = shippingCity;
      this.shippingPin = shippingPin;
      this.status = status;
      this.user = user;
   }
   
   
   //--------------------------------------------------Getters/Setters------------------------------------------------------//


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
    * Get the orderNo.
    *
    * @return Returns the orderNo as a String.
    */
   public String getOrderNo()
   {
      return this.orderNo;
   }


   /**
    * Set the orderNo to the specified value.
    *
    * @param orderNo The orderNo to set.
   
   public void setOrderNo(String orderNo)
   {
      this.orderNo = orderNo;
   } */


   /**
    * Get the orderDate.
    *
    * @return Returns the orderDate as a Date.
    */
   public Date getOrderDate()
   {
      return this.orderDate;
   }


   /**
    * Set the orderDate to the specified value.
    *
    * @param orderDate The orderDate to set.
    */
   public void setOrderDate(Date orderDate)
   {
      this.orderDate = orderDate;
   }


   /**
    * Get the shippingAddress.
    *
    * @return Returns the shippingAddress as a String.
    */
   public String getShippingAddress()
   {
      return this.shippingAddress;
   }


   /**
    * Set the shippingAddress to the specified value.
    *
    * @param shippingAddress The shippingAddress to set.
    */
   public void setShippingAddress(String shippingAddress)
   {
      this.shippingAddress = shippingAddress;
   }


   /**
    * Get the shippingCity.
    *
    * @return Returns the shippingCity as a String.
    */
   public String getShippingCity()
   {
      return this.shippingCity;
   }


   /**
    * Set the shippingCity to the specified value.
    *
    * @param shippingCity The shippingCity to set.
    */
   public void setShippingCity(String shippingCity)
   {
      this.shippingCity = shippingCity;
   }


   /**
    * Get the shippingPin.
    *
    * @return Returns the shippingPin as a String.
    */
   public String getShippingPin()
   {
      return this.shippingPin;
   }


   /**
    * Set the shippingPin to the specified value.
    *
    * @param shippingPin The shippingPin to set.
    */
   public void setShippingPin(String shippingPin)
   {
      this.shippingPin = shippingPin;
   }


   /**
    * Get the status.
    *
    * @return Returns the status as a String.
    */
   public Status getStatus()
   {
      return this.status;
   }


   /**
    * Set the status to the specified value.
    *
    * @param status The status to set.
    */
   public void setStatus(Status status)
   {
      this.status = status;
   }


   /**
    * Get the user.
    *
    * @return Returns the user as a User.
    */
   public User getUser()
   {
      return this.user;
   }


   /**
    * Set the user to the specified value.
    *
    * @param user The user to set.
    */
   public void setUser(User user)
   {
      this.user = user;
   }


   /**
    * Get the orderLines.
    *
    * @return Returns the orderLines as a List<OrderLine>.
    */
   public List<OrderLine> getOrderLines()
   {
      return this.orderLines;
   }


   /**
    * Set the orderLines to the specified value.
    *
    * @param orderLines The orderLines to set.
    */
   public void setOrderLines(List<OrderLine> orderLines)
   {
      this.orderLines = orderLines;
   }
   
   /**
    * Adds the order line.
    *
    * @param line the line
    */
   public void addOrderLine(OrderLine line)
   {
      if(this.orderLines == null)
      {
         this.orderLines = new ArrayList<OrderLine>();
      }
      this.orderLines.add(line);
   }
   

}
