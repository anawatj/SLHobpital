/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.project.Project;
import com.arg.arsoft.siantluis.domains.purchase.Purchase;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseQuery;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseStatus;
import com.arg.arsoft.siantluis.repository.IPurchaseRepository;
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
@Repository(value = "purchaseRepository")
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Purchase> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase findByKey(Integer key) {
        Criteria criteria = factory.getCurrentSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.eq("id", key));
        criteria.setFetchMode("approveBy", FetchMode.JOIN);
        criteria.setFetchMode("purchaseBy", FetchMode.JOIN);
        criteria.setFetchMode("department", FetchMode.JOIN);
        criteria.setFetchMode("supplier", FetchMode.JOIN);
        criteria.setFetchMode("branch", FetchMode.JOIN);

        criteria.setFetchMode("products", FetchMode.JOIN);
        criteria.setFetchMode("services", FetchMode.JOIN);
        criteria.setFetchMode("products.product", FetchMode.JOIN);
        criteria.setFetchMode("services.service", FetchMode.JOIN);

        List<Purchase> result = criteria.list();
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Purchase save(Purchase entity) {
        Purchase data = findByKey(entity.getId());
        Purchase result = (Purchase) factory.getCurrentSession().merge(entity);
        return result;
    }

    @Override
    public void remove(Integer key) {
        Purchase data = (Purchase) factory.getCurrentSession().get(Purchase.class, key);
        factory.getCurrentSession().delete(data);

    }

    @Override
    public Map findByQuery(PurchaseQuery query) {
        int pageSize = Configs.PAGE_SIZE;
        Criteria criteria = factory.getCurrentSession().createCriteria(Purchase.class);
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
        if (query.getPurchaseDateStart() != null) {
            criteria.add(Restrictions.ge("purchaseDate", query.getPurchaseDateStart()));
        }
        if (query.getPurchaseDateEnd() != null) {
            criteria.add(Restrictions.le("purchaseDate", query.getPurchaseDateEnd()));
        }
        if (query.getPurchaseBy() != null && !query.getPurchaseBy().equals("")) {
            criteria.createAlias("purchaseBy", "e", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("e.code", query.getPurchaseBy()));
        }
        if (query.getSupplier() != null && !query.getSupplier().equals("")) {
            criteria.createAlias("supplier", "s", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("s.code", query.getSupplier()));
        }
        if (query.getDepartment() != null && query.getDepartment() != 0) {
            criteria.createAlias("department", "d", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("d.id", query.getDepartment()));
        }
        if (query.getBranch() != null && query.getBranch() != 0) {
            criteria.createAlias("branch", "b", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("b.id", query.getBranch()));
        }
        if (query.getStatus() != null && !query.getStatus().equals("")) {
            PurchaseStatus status = PurchaseStatus.valueOf(query.getStatus());
            criteria.add(Restrictions.eq("status", status));
        }

        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();
        criteria.setProjection(null);
        int start = ((query.getPage() - 1) * pageSize);
        criteria.setFetchMode("department", FetchMode.JOIN);
        criteria.setFetchMode("branch", FetchMode.JOIN);
        criteria.setFetchMode("supplier", FetchMode.JOIN);
        criteria.setFetchMode("purchaseBy", FetchMode.JOIN);
        List<Purchase> result = criteria
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
