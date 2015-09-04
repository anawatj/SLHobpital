/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.supplier.Supplier;
import com.arg.arsoft.siantluis.domains.supplier.SupplierQuery;
import com.arg.arsoft.siantluis.repository.ISupplierRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anawatj
 */
@Repository(value = "supplierRepository")
public class SupplierRepository implements ISupplierRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Supplier> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Supplier findByKey(Integer key) {
        Criteria criteria = factory.getCurrentSession().createCriteria(Supplier.class);
        criteria.setFetchMode("address", FetchMode.JOIN);
        criteria.setFetchMode("contact", FetchMode.JOIN);
        criteria.setFetchMode("address.province", FetchMode.JOIN);
        criteria.setFetchMode("address.amphur", FetchMode.JOIN);

        criteria.add(Expression.eq("id", key));
        List<Supplier> result = criteria.list();
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Supplier save(Supplier entity) {
        Supplier data = findByKey(entity.getId());
        Supplier result = (Supplier) factory.getCurrentSession().merge(entity);
        return result;
    }

    @Override
    public void remove(Integer key) {
        Supplier data = findByKey(key);
        factory.getCurrentSession().delete(data);

    }

    @Override
    public Map findByQuery(SupplierQuery query) {
        int pageSize = Configs.PAGE_SIZE;
        Criteria criteria = factory.getCurrentSession().createCriteria(Supplier.class);
        
      //  criteria.createAlias("address.amphur","a",JoinType.LEFT_OUTER_JOIN);

        if (query.getCode() != null && !query.getCode().equals("")) {
            if (query.getCode().contains("*") || query.getCode().contains("?")) {
                criteria.add(Expression.like("code", query.getCode().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Expression.eq("code", query.getCode()));
            }
        }
        if (query.getName() != null && !query.getName().equals("")) {
            if (query.getName().contains("*") || query.getName().contains("?")) {
                criteria.add(Expression.like("name", query.getName().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Expression.eq("name", query.getName()));
            }
        }
        if (query.getCompany() != null && !query.getCompany().equals("")) {
            if (query.getCompany().contains("*") || query.getCompany().contains("?")) {
                criteria.add(Expression.like("compny", query.getCompany().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Expression.eq("compny", query.getCompany()));
            }
        }
        if (query.getContactName() != null && !query.getContactName().equals("")) {
            if (query.getContactName().contains("*") || query.getContactName().contains("?")) {
                criteria.add(Expression.like("contact.contactName", query.getContactName().replace("*", "%").replace("?", "_")));

            } else {
                criteria.add(Expression.eq("contact.contactName", query.getContactName()));
            }
        }
        if (query.getProvince() != null && query.getProvince() != 0) {
            criteria.createAlias("address.province", "p", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Expression.eq("p.id", query.getProvince()));
        }

        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();

        criteria.setProjection(null);

        int start = ((query.getPage() - 1) * pageSize);
        criteria.setFetchMode("address.province", FetchMode.JOIN);
        criteria.setFetchMode("address.amphur", FetchMode.JOIN);
        List<Supplier> result = criteria
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .setResultTransformer(Criteria.ROOT_ENTITY)
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

        System.out.println(pages.size());
        return data;
    }

}
