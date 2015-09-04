/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.product.Product;
import com.arg.arsoft.siantluis.domains.product.ProductQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anawatj
 */
public interface IProductRepository extends Repository<Product,Integer> {
    
    @Override
    public List<Product> findAll();
    
    @Override
    public Product findByKey(Integer key);
    
    @Override
    public Product save(Product entity);
    
    @Override
    public void remove(Integer key);
    
    
    public Map findByQuery(ProductQuery query);
    
}
