/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.domains.attachment.Attachment;
import com.arg.arsoft.siantluis.repository.IAttachmentRepository;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tao
 */
@Repository(value = "attachmentRepository")
public class AttachmentRepository implements IAttachmentRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Attachment> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Attachment findByKey(Integer key) {
       Criteria criteria = factory.getCurrentSession().createCriteria(Attachment.class);
       criteria.add(Restrictions.eq("id", key));
       // Fetch Relation
       criteria.setFetchMode("attachBy", FetchMode.JOIN);
       
       //Fetch Collection
       criteria.setFetchMode("items", FetchMode.JOIN);
       criteria.setFetchMode("items.type", FetchMode.JOIN);
       
       List<Attachment> result = criteria.list();
       
       if(result!=null && result.size()>0)
       {
           return result.get(0);
       }else
       {
           return null;
       }
       
    }

    @Override
    public Attachment save(Attachment entity) {
       Attachment data = findByKey(entity.getId());
       Attachment result = (Attachment) factory.getCurrentSession().merge(entity);
       return result;
    }

    @Override
    public void remove(Integer key) {
       Attachment data = findByKey(key);
       factory.getCurrentSession().delete(data);
       
    }

}
