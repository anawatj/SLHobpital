/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.order.Order;
import com.arg.arsoft.siantluis.domains.order.OrderQuery;
import com.arg.arsoft.siantluis.repository.IOrderRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anawatj
 */
@Repository(value = "orderRepository")
public class OrderRepository implements IOrderRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Order> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order findByKey(Integer key) {
        Criteria criteria = factory.getCurrentSession().createCriteria(Order.class);
        criteria.add(Restrictions.eq("id", key));

        criteria.setFetchMode("requestBy", FetchMode.JOIN);
        criteria.setFetchMode("approveBy", FetchMode.JOIN);
        criteria.setFetchMode("customer", FetchMode.JOIN);
        criteria.setFetchMode("shipper", FetchMode.JOIN);
        criteria.setFetchMode("address.province", FetchMode.JOIN);
        criteria.setFetchMode("address.amphur", FetchMode.JOIN);

        criteria.setFetchMode("items", FetchMode.JOIN);
        criteria.setFetchMode("items.product", FetchMode.JOIN);

        List<Order> result = criteria.list();
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Order save(Order entity) {
        Order data = findByKey(entity.getId());
        Order result = (Order) factory.getCurrentSession().merge(entity);
        return result;
    }

    @Override
    public void remove(Integer key) {
        Order data = findByKey(key);
        factory.getCurrentSession().delete(data);

    }

    @Override
    public Map findByQuery(OrderQuery query) {
        int pageSize = Configs.PAGE_SIZE;
        Criteria criteria = factory.getCurrentSession().createCriteria(Order.class);

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
        if (query.getEmployee() != null && !query.getEmployee().equals("")) {
            criteria.createAlias("requestBy", "e", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("e.code", query.getCode()));
        }
        if (query.getCustomer() != null && !query.getCustomer().equals("")) {
            criteria.createAlias("customer", "c", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("c.code", query.getCustomer()));
        }
        if (query.getShipper() != null && query.getShipper() != 0) {
            criteria.createAlias("shipper", "s", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("s.id", query.getShipper()));
        }
        if (query.getOrderDateStart() != null) {
            criteria.add(Restrictions.ge("orderDate", query.getOrderDateStart()));
        }
        if (query.getOrderDateEnd() != null) {
            criteria.add(Restrictions.le("orderDate", query.getOrderDateEnd()));
        }
        if (query.getRequireDateStart() != null) {
            criteria.add(Restrictions.ge("requireDate", query.getRequireDateStart()));
        }
        if (query.getRequireDateEnd() != null) {
            criteria.add(Restrictions.le("requireDate", query.getRequireDateEnd()));
        }
        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();
        int start = ((query.getPage() - 1) * pageSize);
        
        criteria.setProjection(null);
        criteria.setFetchMode("requestBy", FetchMode.JOIN);
        criteria.setFetchMode("approveBy", FetchMode.JOIN);
        criteria.setFetchMode("customer", FetchMode.JOIN);
        criteria.setFetchMode("shipper", FetchMode.JOIN);
        criteria.setFetchMode("address.amphur", FetchMode.JOIN);
        criteria.setFetchMode("address.province", FetchMode.JOIN);
        
        List<Order> result = criteria
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
         long totalPage= totalRecord /pageSize;
        if((totalRecord%pageSize)>0)
        {
            totalPage++;
        }
        List<Integer> pages = new ArrayList<Integer>();
        for(int index=1;index<=totalPage;index++)
        {
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
