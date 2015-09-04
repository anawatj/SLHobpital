/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.payment.Payment;
import com.arg.arsoft.siantluis.domains.payment.PaymentQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tao
 */
public interface IPaymentRepository extends Repository<Payment,Integer> {

    @Override
    public List<Payment> findAll();

    @Override
    public void remove(Integer key);

    @Override
    public Payment findByKey(Integer key);

    @Override
    public Payment save(Payment entity);
    
    public Map findByQuery(PaymentQuery query);
    
    
    
}
