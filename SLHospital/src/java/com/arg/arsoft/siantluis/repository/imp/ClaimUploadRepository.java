/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.domains.claim.ClaimUpload;
import com.arg.arsoft.siantluis.repository.IClaimUploadRepository;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anawatj
 */
@Repository(value = "claimUploadRepository")
public class ClaimUploadRepository implements IClaimUploadRepository {

     @Autowired
    private SessionFactory factory;
    @Override
    public List<ClaimUpload> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClaimUpload findByKey(Integer key) {
       Criteria criteria = factory.getCurrentSession().createCriteria(ClaimUpload.class);
       criteria.add(Expression.eq("id", key));
       List<ClaimUpload> result = criteria.list();
       if(result!=null && result.size()>0)
       {
           return result.get(0);
       }else
       {
           return null;
       }
    }

    @Override
    public ClaimUpload save(ClaimUpload entity) {
      System.out.println(entity.getId()+"Start");
      ClaimUpload data = (ClaimUpload) factory.getCurrentSession().get(ClaimUpload.class, entity.getId());
      ClaimUpload result = (ClaimUpload) factory.getCurrentSession().merge(entity);
      return result;
    }

    @Override
    public void remove(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClaimUpload findByCode(String code) {
      Criteria criteria = factory.getCurrentSession().createCriteria(ClaimUpload.class);
      criteria.add(Expression.eq("code", code));
      List<ClaimUpload> result = criteria.list();
      if(result!=null && result.size()>0)
      {
          return result.get(0);
      }else
      {
          return null;
      }
    }
    
}
