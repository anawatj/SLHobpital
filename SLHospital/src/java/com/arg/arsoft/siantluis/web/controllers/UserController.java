/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.user.User;
import com.arg.arsoft.siantluis.domains.user.UserQuery;
import com.arg.arsoft.siantluis.repository.IUserRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author anawatj
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    
     @Autowired
     private IUserRepository uRepository;
     
    @RequestMapping(value = "/getByKey",method=RequestMethod.GET)
    @Transactional
    public @ResponseBody User getByKey(@RequestParam Integer key)
    {
        User result = uRepository.findByKey(key);
        if(result==null)
        {
            result  =new User();
        }
        return result;
    }
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    @Transactional
    public @ResponseBody User save(@RequestBody User entity)
    {
        User result = uRepository.save(entity);
        return result;
    }
    @RequestMapping(value = "/search",method=RequestMethod.POST)
    @Transactional
    public @ResponseBody Map search(@RequestBody UserQuery query)
    {
        Map result = uRepository.findByQuery(query);
        return result;
    }
}
