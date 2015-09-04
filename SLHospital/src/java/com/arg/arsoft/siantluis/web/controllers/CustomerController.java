/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.customer.Customer;
import com.arg.arsoft.siantluis.domains.customer.CustomerQuery;
import com.arg.arsoft.siantluis.repository.ICustomerRepository;
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
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerRepository cRepository;

    @RequestMapping(value = "/getByKey", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    Customer getByKey(@RequestParam Integer key) {
        Customer result = cRepository.findByKey(key);
        if (result == null) {
            result = new Customer();
        }
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Customer save(@RequestBody Customer entity)  {
        if (entity.getAddress() != null) {
            if (entity.getAddress().getProvince() != null && (entity.getAddress().getProvince().getId() == null || entity.getAddress().getProvince().getId() == 0)) {
                entity.getAddress().setProvince(null);
            }
            if (entity.getAddress().getAmphur() != null && (entity.getAddress().getAmphur().getId() == null || entity.getAddress().getAmphur().getId() == 0)) {
                entity.getAddress().setAmphur(null);

            }
        }
        Customer result = cRepository.save(entity);
        return result;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody
    Map search(@RequestBody CustomerQuery query) {
        Map result = cRepository.findByQuery(query);
        return result;
    }
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Customer data,HttpServletResponse response) throws Exception
    {
        cRepository.remove(data.getId());
        response.getOutputStream().print("Success");
        
    }
}
