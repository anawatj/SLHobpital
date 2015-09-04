/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;


import com.arg.arsoft.siantluis.domains.MasterDataObject;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 *
 * @author wongskont
 */
@Repository(value = "masterDataObjectRepository")
public class MasterDataObjectRepository {
    @Autowired
     private SessionFactory factory;
    

     
    
     public List<MasterDataObject> findAll(Class clazz)
     {
        
  
         Criteria criteria = factory.getCurrentSession().createCriteria(clazz);
         List<MasterDataObject> result = criteria.list();
         return result;
     }
     


     

}
