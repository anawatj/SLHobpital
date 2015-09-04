/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.product.Product;
import com.arg.arsoft.siantluis.domains.product.ProductQuery;
import com.arg.arsoft.siantluis.repository.IProductRepository;
import flexjson.JSONSerializer;
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
@RequestMapping(value = "/product")
public class ProductController {
    
    @Autowired
    private IProductRepository pRepository;
    
    @RequestMapping(value = "/getByKey", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody Product getByKey(@RequestParam Integer key) {
        
        Product result = pRepository.findByKey(key);
        if (result == null) {
            result = new Product();
        }
        return result;
      /*  JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude(
                "class",
                "supplier.class",
                "supplier.address",
                "supplier.contact",
                "supplier.address.province",
                "supplier.address.amphur"
        )
                .include("supplier")
                .serialize(result);
        response.getOutputStream().print(json);*/
        
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Product save(@RequestBody Product entity, HttpServletResponse response) throws Exception {
        if (entity.getSupplier() != null && (entity.getSupplier().getId() == null || entity.getSupplier().getId() == 0)) {
            entity.setSupplier(null);
        }
        
        Product result = pRepository.save(entity);
        return result;
        /*JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude(   "class",
                "supplier.class",
                "supplier.address",
                "supplier.contact",
                "supplier.address.province",
                "supplier.address.amphur"
        )
                .include("supplier")
                .serialize(result);
        response.getOutputStream().print(json);*/
       
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Map search(@RequestBody ProductQuery query)  {
        
        Map result = pRepository.findByQuery(query);
        return result;
        /*  JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude(   "list.class",
                "list.supplier.class",
                "list.supplier.address",
                "list.supplier.contact",
                "list.supplier.address.province",
                "list.supplier.address.amphur"
        ).serialize(result);
        response.getOutputStream().print(json);*/
    }
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Product data ,HttpServletResponse response) throws Exception
    {
        pRepository.remove(data.getId());
        response.getOutputStream().print("Success");
    }
}
