/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.attachment.Attachment;
import com.arg.arsoft.siantluis.domains.attachment.AttachmentItem;
import com.arg.arsoft.siantluis.repository.IAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tao
 */
@Controller
@RequestMapping(value = "/attachment")
public class AttachmentController {
     @Autowired
     private IAttachmentRepository aRepository;
     
     @RequestMapping(value = "/getByKey",method = RequestMethod.GET)
     @Transactional
     public @ResponseBody Attachment getByKey(@RequestParam Integer key)
     {
         Attachment result = aRepository.findByKey(key);
         if(result==null)
         {
             result = new Attachment();
         }
         return result;
     }
     @RequestMapping(value = "/store",method=RequestMethod.POST)
     @Transactional
     public @ResponseBody Attachment save(@RequestBody Attachment entity)
     {
         if(entity.getAttachBy()!=null && (entity.getAttachBy().getId()==null || entity.getAttachBy().getId()==0))
         {
             entity.setAttachBy(null);
         }
         for(AttachmentItem item : entity.getItems())
         {
             if(item.getType()!=null && (item.getType().getId()==null || item.getType().getId()==0))
             {
                 item.setType(null);
             }
             
         }
         Attachment result = aRepository.save(entity);
         return result;
     }
     
}
