/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.customer.Customer;
import com.arg.arsoft.siantluis.domains.customer.CustomerQuery;
import com.arg.arsoft.siantluis.domains.customer.CustomerType;
import com.arg.arsoft.siantluis.domains.supplier.Supplier;
import com.arg.arsoft.siantluis.repository.ICustomerRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anawatj
 */
@Repository(value = "customerRepository")
public class CustomerRepository implements ICustomerRepository {

    @Autowired
    private SessionFactory factory;
    @Override
    public List<Customer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findByKey(Integer key) {
       Criteria criteria = factory.getCurrentSession().createCriteria(Customer.class);
       criteria.add(Expression.eq("id", key));
       criteria.setFetchMode("address.province", FetchMode.JOIN);
       criteria.setFetchMode("address.amphur", FetchMode.JOIN);
       List<Customer> result = criteria.list();
       if(result!=null && result.size()>0)
       {
           return result.get(0);
       }else
       {
           return null;
       }
    }

    @Override
    public Customer save(Customer entity) {
       
        Customer data = findByKey(entity.getId());
        Customer result = (Customer) factory.getCurrentSession().merge(entity);
        return result;
    }

    @Override
    public void remove(Integer key) {
      Customer data = (Customer) factory.getCurrentSession().get(Customer.class,key);
      factory.getCurrentSession().delete(data);
      
    }

    @Override
    public Map findByQuery(CustomerQuery query) {
        int pageSize = Configs.PAGE_SIZE;
       Criteria criteria = factory.getCurrentSession().createCriteria(Customer.class);
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
                criteria.add(Expression.like("company", query.getCompany().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Expression.eq("company", query.getCompany()));
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
        List<CustomerType> types = new ArrayList<CustomerType>();
        if(query.getFlagCompany().equals("Y"))
        {
            types.add(CustomerType.C);
        }
        if(query.getFlagPersonal().equals("Y"))
        {
            types.add(CustomerType.P);
        }
        
        if(types.size()>0)
        {
            criteria.add(Expression.in("customerType", types.toArray()));
        }

        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();

        criteria.setProjection(null);
        
         int start = ((query.getPage() - 1) * pageSize);
        criteria.setFetchMode("address.province", FetchMode.JOIN);
        criteria.setFetchMode("address.amphur", FetchMode.JOIN);
        List<Customer> result = criteria
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
