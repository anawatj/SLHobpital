/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.order.Order;
import com.arg.arsoft.siantluis.domains.order.OrderItem;
import com.arg.arsoft.siantluis.domains.order.OrderQuery;
import com.arg.arsoft.siantluis.repository.IOrderRepository;
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
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private IOrderRepository oRepository;

    @RequestMapping(value = "/getByKey", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody Order getByKey(@RequestParam Integer key, HttpServletResponse response) throws Exception {
        Order result = oRepository.findByKey(key);
        if(result==null)
        {
            result = new Order();
        }
        return result;
      /*  JSONSerializer serialize = new JSONSerializer();
        String json = serialize
                .exclude("*.class",
                        "*.educations",
                        "*.experiences",
                        "*.siblings",
                        "*.children",
                        "*.trainings",
                        "*.languages",
                        "*.references",
                        "approveBy.address",
                        "requestBy.address",
                        "approveBy.version",
                        "requestBy.version",
                        "*.hobbies",
                        "approveBy.department",
                        "requestBy.department",
                        "approveBy.position",
                        "requestBy.position",
                        "approveBy.branch",
                        "requestBy.branch",
                        "customer.address",
                        "customer.contact"
                )
                .include("items")
                .serialize(result);
        response.getOutputStream().print(json);*/
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Order save(@RequestBody Order entity, HttpServletResponse response) throws Exception {
        if (entity.getAddress() != null) {
            if (entity.getAddress().getAmphur() != null && (entity.getAddress().getAmphur().getId() == null || entity.getAddress().getAmphur().getId() == 0)) {
                entity.getAddress().setAmphur(null);
            }
            if (entity.getAddress().getProvince() != null && (entity.getAddress().getProvince().getId() == null || entity.getAddress().getProvince().getId() == 0)) {
                entity.getAddress().setProvince(null);
            }
        }
        if (entity.getRequestBy() != null && (entity.getRequestBy().getId() == null || entity.getRequestBy().getId() == 0)) {
            entity.setRequestBy(null);
        }
        if (entity.getApproveBy() != null && (entity.getApproveBy().getId() == null || entity.getApproveBy().getId() == 0)) {
            entity.setApproveBy(null);
        }
        if (entity.getCustomer() != null && (entity.getCustomer().getId() == null || entity.getCustomer().getId() == 0)) {
            entity.setCustomer(null);
        }
        if (entity.getShipper() != null && (entity.getShipper().getId() == null || entity.getShipper().getId() == 0)) {
            entity.setShipper(null);
        }
        for (OrderItem item : entity.getItems()) {
            if (item.getProduct() != null && (item.getProduct().getId() == null || item.getProduct().getId() == 0)) {
                item.setProduct(null);
            }
        }
        Order result = oRepository.save(entity);
        return result;
      /*  JSONSerializer serialize = new JSONSerializer();
        String json = serialize
                .exclude("*.class",
                        "*.educations",
                        "*.experiences",
                        "*.siblings",
                        "*.children",
                        "*.trainings",
                        "*.languages",
                        "*.references",
                        "approveBy.address",
                        "requestBy.address",
                        "approveBy.version",
                        "requestBy.version",
                        "*.hobbies",
                        "approveBy.department",
                        "requestBy.department",
                        "approveBy.position",
                        "requestBy.position",
                        "approveBy.branch",
                        "requestBy.branch",
                        "customer.address",
                        "customer.contact"
                )
                .include("items")
                .serialize(result);
        response.getOutputStream().print(json);*/

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Map search(@RequestBody OrderQuery query,HttpServletResponse response) throws Exception {
        Map result = oRepository.findByQuery(query);
        return result;
        /*JSONSerializer serialize = new JSONSerializer();
        String json = serialize
                .exclude("*.class",
                        "*.educations",
                        "*.experiences",
                        "*.siblings",
                        "*.children",
                        "*.trainings",
                        "*.languages",
                        "*.references",
                        "list.approveBy.address",
                        "list.requestBy.address",
                        "list.approveBy.version",
                        "list.requestBy.version",
                        "*.hobbies",
                        "list.approveBy.department",
                        "list.requestBy.department",
                        "list.approveBy.position",
                        "list.requestBy.position",
                        "list.approveBy.branch",
                        "list.requestBy.branch",
                        "list.customer.address",
                        "list.customer.contact",
                        "items"
                )
                .include("pages")
                .serialize(result);
        response.getOutputStream().print(json);*/
    }
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Order data,HttpServletResponse response) throws Exception 
    {
        oRepository.remove(data.getId());
        response.getOutputStream().print("Success");
    }
}
