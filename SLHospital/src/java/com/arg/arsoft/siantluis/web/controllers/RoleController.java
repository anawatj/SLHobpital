/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.user.RoleQuery;
import com.arg.arsoft.siantluis.repository.IRoleRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author anawatj
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {
    
    @Autowired
    private IRoleRepository rRepository;
    
    
    @RequestMapping(value = "/search",method=RequestMethod.POST)
    @Transactional
    public @ResponseBody Map search(@RequestBody RoleQuery query)
    {
        Map result = rRepository.findByQuery(query);
        return result;
    }
    
}
