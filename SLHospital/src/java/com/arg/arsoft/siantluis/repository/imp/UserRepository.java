/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.user.User;
import com.arg.arsoft.siantluis.domains.user.UserQuery;
import com.arg.arsoft.siantluis.repository.IUserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anawatj
 */
@Repository(value = "userRepository")
public class UserRepository implements IUserRepository{

      @Autowired
    private SessionFactory factory;
    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findByKey(Integer key) {
       Criteria criteria = factory.getCurrentSession().createCriteria(User.class);
       criteria.add(Restrictions.eq("id", key));
       
       criteria.setFetchMode("roles", FetchMode.JOIN);
       
       List<User> result = criteria.list();
       if(result!=null && result.size()>0)
       {
           return result.get(0);
       }else
       {
           return null;
       }
    }

    @Override
    public User save(User entity) {
       User data = findByKey(entity.getId());
       User result = (User) factory.getCurrentSession().merge(entity);
       return result;
    }

    @Override
    public void remove(Integer key) {
      User data = findByKey(key);
      data.getRoles().clear();
      factory.getCurrentSession().delete(data);
      
    }

    @Override
    public Map findByQuery(UserQuery query) {
        int pageSize = Configs.PAGE_SIZE;

        Criteria criteria = factory.getCurrentSession().createCriteria(User.class);

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
       
        List<User> result = criteria
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

        return data;
    }
    
}
