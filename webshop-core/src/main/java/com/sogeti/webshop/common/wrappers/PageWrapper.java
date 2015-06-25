/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 18, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.common.wrappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * Adapter class to wrap Spring data Page interface.
 *
 * @param <T> the generic type
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 18, 2014, Sogeti B.V.
 */
public class PageWrapper<T>
{
   
   /** The Constant MAX_PAGE_ITEM_DISPLAY. */
   public static final int MAX_PAGE_ITEM_DISPLAY = 1;
   
   /** The page. */
   private Page<T> page;
   
   /** The items. */
   private List<PageItem> items;
   
   /** The current number. */
   private int currentNumber;
   
   /** The url. */
   private String url;

   /**
    * Gets the url.
    *
    * @return the url
    */
   public String getUrl() 
   {
      return this.url;
   }

   /**
    * Sets the url.
    *
    * @param url the new url
    */
   public void setUrl(String url)
   {
      this.url = url;
   }

   /**
    * Instantiates a new page wrapper.
    *
    * @param page the page
    * @param url the url
    */
   public PageWrapper(Page<T> page, String url)
   {
      this.page = page;
      this.url = url;
      this.items = new ArrayList<PageItem>();

      this.currentNumber = page.getNumber() + 1; //start from 1 to match page.page

      int start, size;
      if (page.getTotalPages() <= MAX_PAGE_ITEM_DISPLAY)
      {
         start = 1;
         size = page.getTotalPages();
      } 
      else 
      {
         if (this.currentNumber <= MAX_PAGE_ITEM_DISPLAY - MAX_PAGE_ITEM_DISPLAY/2)
         {
            start = 1;
            size = MAX_PAGE_ITEM_DISPLAY;
         } else if (this.currentNumber >= page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY/2)
         {
            start = page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY + 1;
            size = MAX_PAGE_ITEM_DISPLAY;
         } else 
         {
            start = this.currentNumber - MAX_PAGE_ITEM_DISPLAY/2;
            size = MAX_PAGE_ITEM_DISPLAY;
         }
      }

      for (int i = 0; i<size; i++)
      {
         this.items.add(new PageItem(start+i, (start+i)==this.currentNumber));
      }
   }

   /**
    * Gets the items.
    *
    * @return the items
    */
   public List<PageItem> getItems()
   {
      return this.items;
   }

   /**
    * Gets the number.
    *
    * @return the number
    */
   public int getNumber()
   {
      return this.currentNumber;
   }

   /**
    * Gets the content.
    *
    * @return the content
    */
   public List<T> getContent()
   {
      return this.page.getContent();
   }

   /**
    * Gets the size.
    *
    * @return the size
    */
   public int getSize()
   {
      return this.page.getSize();
   }

   /**
    * Gets the total pages.
    *
    * @return the total pages
    */
   public int getTotalPages()
   {
      return this.page.getTotalPages();
   }

   /**
    * Checks if is first page.
    *
    * @return true, if is first page
    */
   public boolean isFirstPage()
   {
      return this.page.isFirstPage();
   }

   /**
    * Checks if is last page.
    *
    * @return true, if is last page
    */
   public boolean isLastPage()
   {
      return this.page.isLastPage();
   }

   /**
    * Checks if is checks for previous page.
    *
    * @return true, if is checks for previous page
    */
   public boolean isHasPreviousPage()
   {
      return this.page.hasPreviousPage();
   }

   /**
    * Checks if is checks for next page.
    *
    * @return true, if is checks for next page
    */
   public boolean isHasNextPage()
   {
      return this.page.hasNextPage();
   }

   /**
    * The Class PageItem.
    * 
    * 
    * 
    */
   public class PageItem 
   {
      
      /** The number. */
      private int number;
      
      /** The current. */
      private boolean current;
      
      /**
       * Instantiates a new page item.
       *
       * @param number the number
       * @param current the current
       */
      public PageItem(int number, boolean current)
      {
         this.number = number;
         this.current = current;
      }

      /**
       * Gets the number.
       *
       * @return the number
       */
      public int getNumber()
      {
         return this.number;
      }

      /**
       * Checks if is current.
       *
       * @return true, if is current
       */
      public boolean isCurrent()
      {
         return this.current;
      }
   }
}
