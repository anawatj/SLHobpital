/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.order.Order;
import com.arg.arsoft.siantluis.domains.user.Role;
import com.arg.arsoft.siantluis.domains.user.RoleQuery;
import com.arg.arsoft.siantluis.repository.IRoleRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anawatj
 */
@Repository(value = "roleRepository")
public class RoleRepository implements IRoleRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Role> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role findByKey(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role save(Role entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map findByQuery(RoleQuery query) {
        int pageSize = Configs.PAGE_SIZE;

        Criteria criteria = factory.getCurrentSession().createCriteria(Role.class);

        if (query.getCode() != null && !query.getCode().equals("")) {
            if (query.getCode().contains("*") || query.getCode().contains("?")) {
                criteria.add(Restrictions.like("code", query.getCode().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Restrictions.eq("code", query.getCode()));
            }
        }
        if (query.getName() != null && !query.getName().equals("")) {
            if (query.getName().contains("*") || query.getName().contains("?")) {
                criteria.add(Restrictions.like("name", query.getName().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Restrictions.eq("name", query.getName()));
            }
        }
        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();
        int start = ((query.getPage() - 1) * pageSize);
        criteria.setProjection(null);

        List<Role> result = criteria
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        long totalPage = totalRecord / pageSize;
        if ((totalRecord % pageSize) > 0) {
            totalPage++;
        }
        List<Integer> pages = new ArrayList<Integer>();
        for (int index = 1; index <= totalPage; index++) {
            pages.add(index);
        }
        Map data = new HashMap();
        data.put("list", result);
        data.put("totalPage", totalPage);
        data.put("totalRecord", totalRecord);
        data.put("pages", pages);

        return data;
    }

}
