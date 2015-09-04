/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.arg.arsoft.siantluis.domains.employee.EmployeeQuery;
import com.arg.arsoft.siantluis.repository.IEmployeeRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wongskont
 */
@Repository(value = "employeeRepository")
public class EmployeeRepository implements IEmployeeRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Employee> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee findByKey(Integer key) {

        Session session = factory.getCurrentSession();
        Criteria criteria = session.createCriteria(Employee.class);

        criteria.add(Restrictions.eq("id", key));
        criteria.setFetchMode("title", FetchMode.JOIN);
        criteria.setFetchMode("position", FetchMode.JOIN);
        criteria.setFetchMode("department", FetchMode.JOIN);
        criteria.setFetchMode("branch", FetchMode.JOIN);
        criteria.setFetchMode("address.province", FetchMode.JOIN);
        criteria.setFetchMode("address.amphur", FetchMode.JOIN);

        criteria.setFetchMode("educations", FetchMode.JOIN);
        criteria.setFetchMode("hobbies", FetchMode.JOIN);
        criteria.setFetchMode("experiences", FetchMode.JOIN);
        criteria.setFetchMode("educations.educationLevel", FetchMode.JOIN);
        criteria.setFetchMode("siblings", FetchMode.JOIN);
        criteria.setFetchMode("children", FetchMode.JOIN);
        criteria.setFetchMode("trainings", FetchMode.JOIN);
        criteria.setFetchMode("languages", FetchMode.JOIN);
        criteria.setFetchMode("languages.language", FetchMode.JOIN);
        criteria.setFetchMode("references", FetchMode.JOIN);
        criteria.setFetchMode("siblings.title", FetchMode.JOIN);
        criteria.setFetchMode("children.title", FetchMode.JOIN);
        criteria.setFetchMode("references.title", FetchMode.JOIN);

        List<Employee> result = criteria.list();
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void remove(Integer key) {
        Session session = factory.getCurrentSession();
        Employee data = (Employee) factory.getCurrentSession().get(Employee.class, key);
        data.getHobbies().clear();
        if (data != null) {
            session.delete(data);
        }

    }

    /**
     *
     * @param entity
     * @return
     */
    @Override
    public Employee save(Employee entity) {

        Employee data = (Employee) factory.getCurrentSession().get(Employee.class, entity.getId());
        Employee result = (Employee) factory.getCurrentSession().merge(entity);
        return result;

    }

    @Override
    public Map findByQuery(EmployeeQuery query) {

        Session session = factory.getCurrentSession();
        Criteria criteria = session.createCriteria(Employee.class);
        if (query.getCode() != null && !query.getCode().equals("")) {
            if (query.getCode().contains("*") || query.getCode().contains("?")) {
                criteria.add(Expression.like("code", query.getCode().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Expression.eq("code", query.getCode()));
            }

        }
        if (query.getFirstName() != null && !query.getFirstName().equals("")) {
            if (query.getFirstName().contains("*") || query.getFirstName().contains("?")) {
                criteria.add(Expression.like("firstName", query.getFirstName().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Expression.eq("firstName", query.getFirstName()));
            }
        }
        if (query.getLastName() != null && !query.getLastName().equals("")) {
            if (query.getLastName().contains("*") || query.getLastName().contains("?")) {
                criteria.add(Expression.like("lastName", query.getLastName().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Expression.eq("lastName", query.getLastName()));
            }
        }

        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();
        long totalPage = totalRecord / Configs.PAGE_SIZE;
        if ((totalRecord % Configs.PAGE_SIZE) > 0) {
            totalPage++;
        }
        criteria.setProjection(null);
        int start = ((query.getPage() - 1) * Configs.PAGE_SIZE);//+ 1;
        List<Employee> result = criteria
                .setFetchMode("title", FetchMode.JOIN)
                .setFetchMode("position", FetchMode.JOIN)
                .setFirstResult(start)
                .setMaxResults(Configs.PAGE_SIZE)
                .setResultTransformer(Criteria.ROOT_ENTITY)
                .list();
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
