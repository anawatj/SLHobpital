/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.project.Project;
import com.arg.arsoft.siantluis.domains.project.ProjectQuery;
import com.arg.arsoft.siantluis.repository.IProjectRepository;
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
@Repository(value = "projectRepository")
public class ProjectRepository implements IProjectRepository {

    @Autowired
    private SessionFactory factory;
    @Override
    public List<Project> findAll() {
        Criteria criteria = factory.getCurrentSession().createCriteria(Project.class);
        List<Project> result = criteria.list();
        return result;
    }

    @Override
    public Project findByKey(Integer key) {
        Criteria criteria = factory.getCurrentSession().createCriteria(Project.class);
        criteria.add(Restrictions.eq("id", key));
        criteria.setFetchMode("items", FetchMode.JOIN);
        criteria.setFetchMode("items.frms", FetchMode.JOIN);
        criteria.setFetchMode("items.frms.productGroup", FetchMode.JOIN);
        List<Project> result = criteria.list();
        if(result!=null && result.size()>0)
        {
            return result.get(0);
        }else
        {
            return null;
        }
    }

    @Override
    public Project save(Project entity) {
        Project data = findByKey(entity.getId());
        Project result = (Project) factory.getCurrentSession().merge(entity);
        return result;
    }

    @Override
    public void remove(Integer key) {
         Project data = (Project) factory.getCurrentSession().get(Project.class, key);
         factory.getCurrentSession().delete(data);
    }

    @Override
    public Map findByQuery(ProjectQuery query) {
       int pageSize = Configs.PAGE_SIZE;
       Criteria criteria = factory.getCurrentSession().createCriteria(Project.class);
       if(query.getCode()!=null && !query.getCode().equals(""))
       {
           if(query.getCode().contains("*") || query.getCode().contains("?"))
           {
               criteria.add(Restrictions.like("code", query.getCode().replace("*","%").replace("?","_")));
           }else
           {
               criteria.add(Restrictions.eq("code", query.getCode()));
           }
       }
       if(query.getName()!=null && !query.getName().equals(""))
       {
           if(query.getName().contains("*") || query.getName().contains("?"))
           {
               criteria.add(Restrictions.like("name", query.getName().replace("*","%").replace("?","_")));
           }else
           {
               criteria.add(Restrictions.eq("name", query.getName()));
           }
       }
       long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();
        criteria.setProjection(null);
         int start = ((query.getPage() - 1) * pageSize);
         List<Project> result = criteria
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
