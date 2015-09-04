/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.order.Order;
import com.arg.arsoft.siantluis.domains.order.OrderQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anawatj
 */
public interface IOrderRepository extends Repository<Order,Integer> {
    
    @Override
    public List<Order> findAll();
    
    @Override
    public Order findByKey(Integer key);
    
    @Override
    public Order save(Order entity);
    
    @Override
    public void remove(Integer key);
    
    public Map findByQuery(OrderQuery query);
}
