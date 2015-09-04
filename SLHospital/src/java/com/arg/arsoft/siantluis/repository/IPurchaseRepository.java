/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.purchase.Purchase;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anawatj
 */
public interface IPurchaseRepository extends Repository<Purchase,Integer> {
    
    @Override
    public List<Purchase> findAll();
    
    @Override
    public Purchase findByKey(Integer key);
    
    @Override
    public Purchase save(Purchase entity);
    
    @Override
    public void remove(Integer key);
    
    public Map findByQuery(PurchaseQuery query);
}
