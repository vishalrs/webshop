/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 7, 2014 Sogeti Nederland B.V. All Rights Reserved.
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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The entity representing Role for a user
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 7, 2014, Sogeti B.V.
 */
@Entity
@Table(name="roles")
public class Role implements Serializable
{

   //--------------------------------------------------Members------------------------------------------------------//
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 2130790118776185320L;
   
   
   /**
    * <code>id</code> indicates/is used for identifying the role entity.
    */
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   
   /**
    * <code>name</code> indicates/is used for naming the role.
    */
   @Column(name = "name", length=50)
   private String name;
   
   
   //--------------------------------------------------Constructors---------------------------------------------------//
   
   /**
    * Constructor: Default constructor for creating a new Role.
    */
   public Role()
   {
      
   }
  
   /**
    * Constructor: create a new Role by specifying name.
    * @param roleName the name
    */
   public Role(String roleName)
   {
      this.name = roleName;
   }
   
  //--------------------------------------------------Getters/Setters----------------------------------------------//

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
      if (!(obj instanceof Role))
      {
         return false;
      }
      Role other = (Role) obj;
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
