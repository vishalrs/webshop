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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The entity carrying user information.
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 7, 2014, Sogeti B.V.
 */
@Entity
@Table(name="users")
public class User implements Serializable
{
   
    //--------------------------------------------------Members------------------------------------------------------//

   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 2285888163313017522L;
   
   
   /**
    * <code>id</code> indicates/is used as primary key.
    */
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   
   /**
    * <code>firstName</code> indicates/is used for representing the first name of the user.
    */
   @NotNull
   @Column(name="first_name", length=50)
   private String firstName;
   
   /**
    * <code>lastName</code> indicates/is used for representing the last name of the user.
    */
   @NotNull
   @Column(name="last_name", length=50)
   private String lastName;
   
   /**
    * <code>email</code> indicates/is used for representing the email of the user.
    */
   @NotNull
   @Column(name="email", length=50)
   private String email;
   
   /**
    * <code>username</code> indicates/is used for representing the unique username chosen by the user.
    */
   @NotNull
   @Column(name="username", length=30, unique = true)
   private String username;
   
   /**
    * <code>password</code> indicates/is used for representing the password of the user.
    */
   @NotNull
   @Size(min=5, max=30)
   @Column(name="password", length=30)
   private String password;
   
   /**
    * <code>address</code> indicates/is used for representing the address of the user.
    */
   @NotNull
   @Column(name="address", length=250) 
   private String address;
   
   /**
    * <code>city</code> indicates/is used for representing the users city.
    */
   @NotNull
   @Column(name="city", length=50)
   private String city;
   
   /**
    * <code>pincode</code> indicates/is used for representing the users pincode.
    */
   @NotNull
   @Column(name="pincode", length=10)
   private String pincode;
   
   /**
    * <code>roles</code> indicates the role(s) the user has.
    */
   @ManyToMany
   @JoinTable(name="user_roles", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
   private List<Role> roles;
   
   @Column(name="accountEnabled")
   private Boolean accountEnabled;
   
   //--------------------------------------------------Constructors---------------------------------------------------//
   
   /**
    * Constructor: Default constructor for creating a new User.
    */
   public User()
   {
      this.roles = new ArrayList<Role>();
      this.accountEnabled = Boolean.FALSE;
   }
   
   
   /**
    * Instantiates a new user.
    *
    * @param firstName the first name
    * @param lastName the last name
    * @param email the email
    * @param username the username
    * @param password the password
    * @param address the address
    * @param city the city
    * @param pincode the pincode
    */
   public User(String firstName, String lastName, String email, String username, String password, String address, String city, String pincode)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.username = username;
      this.password = password;
      this.address = address;
      this.city = city;
      this.pincode = pincode;
      this.roles = new ArrayList<Role>();
      this.accountEnabled = Boolean.FALSE;
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
    * Get the firstName.
    *
    * @return Returns the firstName as a String.
    */
   public String getFirstName()
   {
      return this.firstName;
   }

   /**
    * Set the firstName to the specified value.
    *
    * @param firstName The firstName to set.
    */
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   /**
    * Get the lastName.
    *
    * @return Returns the lastName as a String.
    */
   public String getLastName()
   {
      return this.lastName;
   }

   /**
    * Set the lastName to the specified value.
    *
    * @param lastName The lastName to set.
    */
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   /**
    * Get the email.
    *
    * @return Returns the email as a String.
    */
   public String getEmail()
   {
      return this.email;
   }

   /**
    * Set the email to the specified value.
    *
    * @param email The email to set.
    */
   public void setEmail(String email)
   {
      this.email = email;
   }

   /**
    * Get the username.
    *
    * @return Returns the username as a String.
    */
   public String getUsername()
   {
      return this.username;
   }

   /**
    * Set the username to the specified value.
    *
    * @param username The username to set.
    */
   public void setUsername(String username)
   {
      this.username = username;
   }

   /**
    * Get the password.
    *
    * @return Returns the password as a String.
    */
   public String getPassword()
   {
      return this.password;
   }

   /**
    * Set the password to the specified value.
    *
    * @param password The password to set.
    */
   public void setPassword(String password)
   {
      this.password = password;
   }

   /**
    * Get the address.
    *
    * @return Returns the address as a String.
    */
   public String getAddress()
   {
      return this.address;
   }

   /**
    * Set the address to the specified value.
    *
    * @param address The address to set.
    */
   public void setAddress(String address)
   {
      this.address = address;
   }

   /**
    * Get the city.
    *
    * @return Returns the city as a String.
    */
   public String getCity()
   {
      return this.city;
   }

   /**
    * Set the city to the specified value.
    *
    * @param city The city to set.
    */
   public void setCity(String city)
   {
      this.city = city;
   }

   /**
    * Get the pincode.
    *
    * @return Returns the pincode as a String.
    */
   public String getPincode()
   {
      return this.pincode;
   }

   /**
    * Set the pincode to the specified value.
    *
    * @param pincode The pincode to set.
    */
   public void setPincode(String pincode)
   {
      this.pincode = pincode;
   }

   /**
    * Get the roles.
    *
    * @return Returns the roles as a List<Role>.
    */
   public List<Role> getRoles()
   {
      return this.roles;
   }

   /**
    * Set the roles to the specified value.
    *
    * @param roles The roles to set.
    */
   public void setRoles(List<Role> roles)
   {
      this.roles = roles;
   }
   
   /**
    * Adds the role.
    *
    * @param role the role
    */
   public void addRole(Role role)
   {
      if(role!=null) 
      {
         this.roles.add(role);
      }
   }
   
   /**
    * Get the account enabled.
    *
    * @return Returns the accountEnabled as a Boolean.
    */
   public Boolean getAccountEnabled()
   {
      return this.accountEnabled;
   }


   /**
    * Set the account enabled to the specified value.
    *
    * @param accountEnabled the new account enabled
    */
   public void setAccountEnabled(Boolean accountEnabled)
   {
      this.accountEnabled = accountEnabled;
   }


   /**
    * Removes the role.
    *
    * @param role the role
    */
   public void removeRole(Role role)
   {
      this.roles.remove(role);
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
      result = prime * result + ((username == null) ? 0 : username.hashCode());
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
      if (!(obj instanceof User))
      {
         return false;
      }
      User other = (User) obj;
      if (username == null)
      {
         if (other.username != null)
         {
            return false;
         }
      }
      else if (!username.equals(other.username))
      {
         return false;
      }
      return true;
   }
   
   
  
}
