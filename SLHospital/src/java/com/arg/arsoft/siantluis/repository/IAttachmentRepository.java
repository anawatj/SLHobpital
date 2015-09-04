/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.attachment.Attachment;
import java.util.List;

/**
 *
 * @author Tao
 */
public interface IAttachmentRepository extends Repository<Attachment,Integer> {
    
    @Override
    public List<Attachment> findAll();

    @Override
    public Attachment findByKey(Integer key);

    @Override
    public Attachment save(Attachment entity);

    @Override
    public void remove(Integer key);
    
    
}
