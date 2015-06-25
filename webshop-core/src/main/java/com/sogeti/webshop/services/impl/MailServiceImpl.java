/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: Vishal.Shinde
 ** Copyright: (c) Jul 28, 2014 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sogeti.webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.sogeti.webshop.services.IMailService;

/**
 * Service implementation of IMailService interface
 *
 * @version $Id:$
 * @author Vishal.Shinde (c) Jul 28, 2014, Sogeti B.V.
 */
@Service
public class MailServiceImpl implements IMailService
{

   @Autowired
   private MailSender mailSender;
   /*
    * (non-Javadoc)
    * @see com.sogeti.webshop.services.IMailService#sendMail(java.lang.String, java.lang.String, java.lang.String)
    */
   @Override
   public void sendMail(String from, String to, String subject, String body)
   {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(from);
      message.setTo(to);
      message.setSubject(subject);
      message.setText(body);
      mailSender.send(message);
   }

}
