/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.domains.master.Amphur;
import com.arg.arsoft.siantluis.domains.master.Province;
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

@Repository(value = "addressRepository")
public class AddressRepository {
    
    @Autowired
    private SessionFactory factory;
    
    public List<Province> findAllProvince()
    {
        Criteria criteria = factory.getCurrentSession().createCriteria(Province.class);
        List<Province> result = criteria.list();
        return result;
    }
    public List<Amphur> findAllAmphur(Integer provinceId)
    {
        Criteria criteria = factory.getCurrentSession().createCriteria(Amphur.class);
        criteria.add(Expression.eq("provinceId",provinceId));
        List<Amphur> result = criteria.list();
        return result;
    }
    
}
