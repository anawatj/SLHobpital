/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.user.Role;
import com.arg.arsoft.siantluis.domains.user.RoleQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anawatj
 */
public interface IRoleRepository extends Repository<Role,Integer> {
    
    @Override
    public List<Role> findAll();
    
    
    @Override
    public Role findByKey(Integer key);
    
    
    @Override
    public Role save(Role entity);
    
    @Override
    public void remove(Integer key);
    
    
    public Map findByQuery(RoleQuery query);
}
