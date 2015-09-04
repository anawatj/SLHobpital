/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.supplier.Supplier;
import com.arg.arsoft.siantluis.domains.supplier.SupplierQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anawatj
 */
public interface ISupplierRepository extends Repository<Supplier,Integer> {

    @Override
   public List<Supplier> findAll();
   @Override
   public Supplier findByKey(Integer key);
   @Override
   public Supplier save(Supplier entity);
   
   @Override
   public void remove(Integer key);
   
   public Map findByQuery(SupplierQuery query);
   
   
    
    
}
