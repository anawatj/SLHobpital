/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;


import com.arg.arsoft.siantluis.domains.IDomain;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author wongskont
 */
public interface Repository<E extends IDomain<K>,K extends Serializable> {
    
    public List<E> findAll();
    public E findByKey(K key);
    public E save(E entity);
    public void remove(K key);
}
