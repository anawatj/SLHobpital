/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.supplier.Supplier;
import com.arg.arsoft.siantluis.domains.supplier.SupplierQuery;
import com.arg.arsoft.siantluis.repository.ISupplierRepository;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value = "/supplier")
public class SupplierController {
    @Autowired
    private ISupplierRepository sRepository;
    
    
    @RequestMapping(value = "/getByKey",method=RequestMethod.GET)
    @Transactional
    public @ResponseBody Supplier getByKey(@RequestParam Integer key)
    {
        Supplier result =  sRepository.findByKey(key);
        if(result==null)
        {
            result = new Supplier();
        }
        return result;
    }
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    @Transactional
    public @ResponseBody Supplier save(@RequestBody Supplier entity,HttpServletResponse response) throws Exception
    {
     if (entity.getAddress() != null) {
            if (entity.getAddress().getProvince() != null && (entity.getAddress().getProvince().getId() == null || entity.getAddress().getProvince().getId() == 0)) {
                entity.getAddress().setProvince(null);
            }
            if (entity.getAddress().getAmphur() != null && (entity.getAddress().getAmphur().getId() == null || entity.getAddress().getAmphur().getId() == 0)) {
                entity.getAddress().setAmphur(null);

            }
        }
       Supplier result = sRepository.save(entity);
       return result;
        /* JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude("class","address.class","contact.class","address.province.class","address.amphur.class")
                .serialize(result);
        response.getOutputStream().print(json);*/
    }
    @RequestMapping(value = "/search",method=RequestMethod.POST)
    @Transactional
    public @ResponseBody Map search(@RequestBody SupplierQuery query,HttpServletResponse response) throws Exception
    {
        Map result = sRepository.findByQuery(query);
        return result;
       /* JSONSerializer serialize = new JSONSerializer();
        String json = serialize
                .exclude("list.class"
                        ,"list.address.class"
                        ,"list.contact.class"
                        ,"list.address.province.class"
                        ,"list.address.amphur.class"
                        ,"list.address.province.createBy"
                        ,"list.address.province.createDate"
                        ,"list.address.province.lastupdateBy"
                        ,"list.address.province.lastupdateDate"
                        ,"list.address.province.version"
                        ,"list.address.amphur.createBy"
                        ,"list.address.amphur.createDate"
                        ,"list.address.amphur.lastupdateBy"
                        ,"list.address.amphur.lastupdateDate"
                        ,"list.address.amphur.version")
                .serialize(result);
        response.getOutputStream().print(json);*/
    
    }
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Supplier data,HttpServletResponse response) throws Exception
    {
        sRepository.remove(data.getId());
        response.getOutputStream().print("Success");
    }
}
