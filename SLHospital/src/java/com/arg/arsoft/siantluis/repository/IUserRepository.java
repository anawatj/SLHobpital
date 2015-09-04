/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.user.User;
import com.arg.arsoft.siantluis.domains.user.UserQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anawatj
 */
public interface IUserRepository extends Repository<User,Integer> {
    
    @Override
    public List<User> findAll();
    
    @Override
    public User findByKey(Integer key);
    
    @Override
    public User save(User entity);
    
    @Override
    public void remove(Integer key);
    
    
    public Map findByQuery(UserQuery query);
}
