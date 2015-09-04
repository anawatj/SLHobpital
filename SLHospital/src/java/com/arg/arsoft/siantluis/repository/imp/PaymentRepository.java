/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.payment.Payment;
import com.arg.arsoft.siantluis.domains.payment.PaymentQuery;
import com.arg.arsoft.siantluis.repository.IPaymentRepository;
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
 * @author Tao
 */
@Repository(value = "paymentRepository")
public class PaymentRepository implements IPaymentRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Payment> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer key) {
        Payment data = findByKey(key);
        factory.getCurrentSession().delete(data);
    }

    @Override
    public Payment findByKey(Integer key) {
        Criteria criteria = factory.getCurrentSession().createCriteria(Payment.class);
        criteria.add(Restrictions.eq("id", key));

        // fetch assocication
        criteria.setFetchMode("paymentBy", FetchMode.JOIN);
        criteria.setFetchMode("approveBy", FetchMode.JOIN);
        criteria.setFetchMode("department", FetchMode.JOIN);
        criteria.setFetchMode("branch", FetchMode.JOIN);
        criteria.setFetchMode("attachment", FetchMode.JOIN);

        // fetch collection
        criteria.setFetchMode("purchases", FetchMode.JOIN);
        criteria.setFetchMode("expenses", FetchMode.JOIN);
        criteria.setFetchMode("purchases.purchase", FetchMode.JOIN);
        criteria.setFetchMode("expenses.expense", FetchMode.JOIN);
        criteria.setFetchMode("cashes", FetchMode.JOIN);
        criteria.setFetchMode("cheques", FetchMode.JOIN);
        criteria.setFetchMode("cheques.bank", FetchMode.JOIN);
        criteria.setFetchMode("credits", FetchMode.JOIN);
        criteria.setFetchMode("credits.bank", FetchMode.JOIN);
        criteria.setFetchMode("transfers", FetchMode.JOIN);
        criteria.setFetchMode("transfers.bank", FetchMode.JOIN);

        List<Payment> result = criteria.list();
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Payment save(Payment entity) {
        Payment data = findByKey(entity.getId());
        Payment result = (Payment) factory.getCurrentSession().merge(entity);
        return result;
    }

    @Override
    public Map findByQuery(PaymentQuery query) {
             int pageSize = Configs.PAGE_SIZE;
        Criteria criteria = factory.getCurrentSession().createCriteria(Payment.class);
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
        if (query.getPaymentBy() != null && !query.getPaymentBy().equals("")) {
            criteria.createAlias("paymentBy", "p", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("p.code", query.getCode()));
        }
        if (query.getPaymentDateFrom() != null) {
            criteria.add(Restrictions.ge("paymentDate", query.getPaymentDateFrom()));
        }
        if (query.getPaymentDateTo() != null) {
            criteria.add(Restrictions.le("paymentDate", query.getPaymentDateTo()));
        }
        if (query.getDepartment() != null && query.getDepartment() != 0) {
            criteria.createAlias("department", "d", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("d.id", query.getDepartment()));
        }
        if (query.getBranch() != null && query.getBranch() != 0) {
            criteria.createAlias("branch", "b", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("b.id", query.getBranch()));
        }
        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();

        criteria.setProjection(null);

        int start = ((query.getPage() - 1) * pageSize);
        
        // fetch assco
        criteria.setFetchMode("paymentBy", FetchMode.JOIN);
        criteria.setFetchMode("department", FetchMode.JOIN);
        criteria.setFetchMode("branch", FetchMode.JOIN);
        
        List<Payment> result = criteria
                .setResultTransformer(Criteria.ROOT_ENTITY)
                .setFirstResult(start)
                .setMaxResults(pageSize)
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
