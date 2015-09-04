/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository.imp;

import com.arg.arsoft.siantluis.Configs;
import com.arg.arsoft.siantluis.domains.reservation.Reservation;
import com.arg.arsoft.siantluis.domains.reservation.ReservationQuery;
import com.arg.arsoft.siantluis.repository.IReservationRepository;
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
@Repository(value = "reservationRepository")
public class ReservationRepository implements IReservationRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Reservation> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservation findByKey(Integer key) {
        Criteria criteria = factory.getCurrentSession().createCriteria(Reservation.class);
        criteria.add(Restrictions.eq("id", key));

        // Fetch Relation
        criteria.setFetchMode("reservationBy", FetchMode.JOIN);
        criteria.setFetchMode("approveBy", FetchMode.JOIN);
        criteria.setFetchMode("attachment", FetchMode.JOIN);

        // Fetch Collection
        criteria.setFetchMode("rooms", FetchMode.JOIN);
        criteria.setFetchMode("its", FetchMode.JOIN);
        criteria.setFetchMode("motors", FetchMode.JOIN);
        criteria.setFetchMode("rooms.equipment", FetchMode.JOIN);
        criteria.setFetchMode("its.equipment", FetchMode.JOIN);
        criteria.setFetchMode("motors.equipment", FetchMode.JOIN);

        List<Reservation> result = criteria.list();
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Reservation save(Reservation entity) {
        Reservation data = findByKey(entity.getId());
        Reservation result = (Reservation) factory.getCurrentSession().merge(entity);
        return result;
    }

    @Override
    public void remove(Integer key) {
        Reservation data = findByKey(key);
        factory.getCurrentSession().delete(data);

    }

    @Override
    public Map findByQuery(ReservationQuery query) {
        int pageSize = Configs.PAGE_SIZE;
        Criteria criteria = factory.getCurrentSession().createCriteria(Reservation.class);
        if (query.getCode() != null && !query.getCode().equals("")) {
            if (query.getCode().contains("*") || query.getCode().contains("?")) {
                criteria.add(Restrictions.like("code", query.getCode().replace("*", "%").replace("?", "_")));
            } else {
                criteria.add(Restrictions.eq("code", query.getCode()));
            }
        }
        if (query.getDescription() != null && !query.getDescription().equals("")) {
            if (query.getDescription().contains("*") || query.getDescription().contains("?")) {
                criteria.add(Restrictions.like("description", query.getDescription().replace("*", "%").replace("?", "*")));
            } else {
                criteria.add(Restrictions.eq("description", query.getDescription()));
            }
        }
        if (query.getRequestBy() != null && !query.getRequestBy().equals("")) {
            criteria.createAlias("reservationBy", "em", JoinType.LEFT_OUTER_JOIN);
            criteria.add(Restrictions.eq("em.code", query.getRequestBy()));
        }
        if (query.getReservationDateFrom() != null) {
            criteria.add(Restrictions.ge("reservationDate", query.getReservationDateFrom()));
        }
        if (query.getReservationDateTo() != null) {
            criteria.add(Restrictions.le("reservationDate", query.getReservationDateTo()));
        }

        long totalRecord = (long) criteria.setProjection(Projections.count(Projections.id().toString())).uniqueResult();
        int start = ((query.getPage() - 1) * pageSize);

        criteria.setProjection(null);
        
        criteria.setFetchMode("reservationBy", FetchMode.JOIN);
        
        List<Reservation> result =criteria
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
