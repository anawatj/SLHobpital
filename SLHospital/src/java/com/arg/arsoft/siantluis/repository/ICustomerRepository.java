/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.customer.Customer;
import com.arg.arsoft.siantluis.domains.customer.CustomerQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anawatj
 */
public interface ICustomerRepository extends Repository<Customer,Integer>{
    
    @Override
    public List<Customer> findAll();
    
    @Override
    public Customer findByKey(Integer key);
    
    @Override
    public Customer save(Customer entity);
    
    @Override
    public void remove(Integer key);
    
    public Map findByQuery(CustomerQuery query);
}
