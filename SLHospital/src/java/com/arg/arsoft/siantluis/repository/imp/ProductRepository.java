/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.product.Product;
import com.arg.arsoft.siantluis.domains.product.ProductActive;
import com.arg.arsoft.siantluis.domains.product.ProductQuery;
import com.arg.arsoft.siantluis.repository.IProductRepository;
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
@Repository(value = "productRepository")
public class ProductRepository implements IProductRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findByKey(Integer key) {
        Criteria criteria = factory.getCurrentSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("id", key));
        criteria.setFetchMode("supplier", FetchMode.JOIN);
        List<Product> result = criteria.setResultTransformer(Criteria.ROOT_ENTITY).list();
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Product save(Product entity) {
        Product data = findByKey(entity.getId());
        Product result = (Product) factory.getCurrentSession().merge(entity);
        return result;
    }

    @Override
    public void remove(Integer key) {
        Product data = (Product) factory.getCurrentSession().get(Product.class, key);
        factory.getCurrentSession().delete(data);
    }

    @Override
    public Map findByQuery(ProductQuery query) {
        int pageSize = Configs.PAGE_SIZE;
        Criteria criteria = factory.getCurrentSession().createCriteria(Product.class);
        if (query.getCode() != null && !query.getCode().equals("")) {
            if (query.getCode().contains("*") || query.getCode().contains("?")) {
                criteria.add(org.hibernate.criterion.Restrictions.like("code", query.getCode().replace("*", "%").replace("?", "_")));

            } else {
                criteria.add(org.hibernate.criterion.Restrictions.eq("code", query.getCode()));
            }
        }
        if(query.getName()!=null && !query.getName().equals(""))
        {
            if(query.getName().contains("*")|| query.getName().contains("?"))
            {
                criteria.add(org.hibernate.criterion.Restrictions.like("name", query.getName().replace("*", "%").replace("?", "_")));
            }else
            {
                criteria.add(org.hibernate.criterion.Restrictions.eq("name", query.getName()));
            }
        }
        if(query.getSupplier()!=null && !query.getSupplier().equals(""))
        {
            criteria.createAlias("supplier","s",JoinType.LEFT_OUTER_JOIN);
            criteria.add(org.hibernate.criterion.Restrictions.eq("s.code", query.getSupplier()));
        }
        if(query.getActive()!=null && !query.getActive().equals(""))
        {
            ProductActive active = ProductActive.valueOf(query.getActive());
            criteria.add(org.hibernate.criterion.Restrictions.eq("active", active));
        }
        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();
        int start = ((query.getPage()-1)*pageSize);
        
        criteria.setProjection(null);
        criteria.setFetchMode("supplier", FetchMode.EAGER);
        List<Product> result = criteria
               .setFirstResult(start)
               .setMaxResults(pageSize)
               .setResultTransformer(Criteria.ROOT_ENTITY)
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
