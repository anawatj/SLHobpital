/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.product.Product;
import com.arg.arsoft.siantluis.domains.purchase.Purchase;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseItemProduct;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseItemService;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseQuery;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseStatus;
import com.arg.arsoft.siantluis.repository.IProductRepository;
import com.arg.arsoft.siantluis.repository.IPurchaseRepository;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import java.util.Date;
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
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired
    IPurchaseRepository pRepository;
    @Autowired
    IProductRepository prRepository;

    @RequestMapping(value = "/getByKey", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody Purchase getByKey(@RequestParam Integer key)  {

        Purchase result = pRepository.findByKey(key);
        if(result==null)
        {
            result = new Purchase();
        }
        return result;
        /* JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude("*.class",
                "purchaseBy.educations",
                "purchaseBy.experiences",
                "purchaseBy.siblings",
                "purchaseBy.chidren",
                "purchaseBy.trainings",
                "purchaseBy.languages",
                "purchaseBy.references",
                "purchaseBy.position",
                "purchaseBy.department",
                "purchaseBy.address",
                "purchaseBy.createBy",
                "purchaseBy.createDate",
                "purchaseBy.lastupdateBy",
                "purchaseBy.lastupdateDate",
                "purchaseBy.branch",
                "purchaseBy.version",
                "approveBy.educations",
                "approveBy.experiences",
                "approveBy.siblings",
                "approveBy.chidren",
                "approveBy.trainings",
                "approveBy.languages",
                "approveBy.references",
                "approveBy.position",
                "approveBy.department",
                "approveBy.createBy",
                "approveBy.createDate",
                "approveBy.lastupdateBy",               
                "approveBy.lastupdateDate",
                "approveBy.branch",
                "approveBy.version",
                "approveBy.address",
                "supplier.address",
                "supplier.contact",
                "supplier.createBy",
                "supplier.createDate",
                "supplier.lastupdateBy",
                "supplier.lastupdateDate",
                "supplier.version",
                "products.product.supplier",
                "products.product.unitPrice",
                "products.product.unitInStock",
                "products.product.unitOnOrder",
                "products.product.active",
                "products.product.createBy",
                "products.product.createDate",
                "products.product.lastupdateBy",
                "products.product.lastupdateDate",
                "products.product.version",
                "services.service.createBy",
                "services.service.createDate",
                "services.service.lastupdateBy",
                "services.service.lastupdateDate",
                "department.createBy",
                "department.createDate",
                "department.lastupdateBy",
                "department.lastupdateDate",
                "department.version",
                "branch.createBy",
                "branch.createDate",
                "branch.lastupdateBy",
                "branch.lastupdateDate"
        ).include(
                "products",
                "services",
                "products.product",
                "services.service",
                "purchaseBy.title",
                "approveBy.title"
        ).transform(new DateTransformer("yyyy-MM-dd'T'HH:mm:ssZ"), Date.class)
                .serialize(result);
        response.getOutputStream().print(json);*/
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Purchase save(@RequestBody Purchase entity){
        if (entity.getApproveBy() != null && (entity.getApproveBy().getId() == null || entity.getApproveBy().getId() == 0)) {
            entity.setApproveBy(null);
        }
        if (entity.getPurchaseBy() != null && (entity.getPurchaseBy().getId() == null || entity.getPurchaseBy().getId() == 0)) {
            entity.setPurchaseBy(null);
        }
        if (entity.getBranch() != null && (entity.getBranch().getId() == null || entity.getBranch().getId() == 0)) {
            entity.setBranch(null);
        }
        if (entity.getDepartment() != null && (entity.getDepartment().getId() == null || entity.getDepartment().getId() == 0)) {
            entity.setDepartment(null);
        }
        if (entity.getSupplier() != null && (entity.getSupplier().getId() == null || entity.getSupplier().getId() == 0)) {
            entity.setSupplier(null);

        }
        for (PurchaseItemProduct product : entity.getProducts()) {
            if (product.getProduct() != null && (product.getProduct().getId() == null || product.getProduct().getId() == 0)) {
                product.setProduct(null);
            }

        }
        for (PurchaseItemService service : entity.getServices()) {
            if (service.getService() != null && (service.getService().getId() == null || service.getService().getId() == 0)) {
                service.setService(null);

            }
        }
        Purchase result = pRepository.save(entity);

        if (entity.getStatus() == PurchaseStatus.A) {
            for (PurchaseItemProduct product : result.getProducts()) {
                Product data = prRepository.findByKey(product.getProduct().getId());
                data.setUnitInStock(data.getUnitInStock() + product.getQuantity());
                prRepository.save(data);
            }
        }
        return result;
      /*  JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude("*.class",
                "purchaseBy.educations",
                "purchaseBy.experiences",
                "purchaseBy.siblings",
                "purchaseBy.chidren",
                "purchaseBy.trainings",
                "purchaseBy.languages",
                "purchaseBy.references",
                "purchaseBy.position",
                "purchaseBy.department",
                "purchaseBy.address",
                "purchaseBy.createBy",
                "purchaseBy.createDate",
                "purchaseBy.lastupdateBy",
                "purchaseBy.lastupdateDate",
                "purchaseBy.branch",
                "purchaseBy.version",
                "approveBy.educations",
                "approveBy.experiences",
                "approveBy.siblings",
                "approveBy.chidren",
                "approveBy.trainings",
                "approveBy.languages",
                "approveBy.references",
                "approveBy.position",
                "approveBy.department",
                "approveBy.createBy",
                "approveBy.createDate",
                "approveBy.lastupdateBy",               
                "approveBy.lastupdateDate",
                "approveBy.branch",
                "approveBy.version",
                "approveBy.address",
                "supplier.address",
                "supplier.contact",
                "supplier.createBy",
                "supplier.createDate",
                "supplier.lastupdateBy",
                "supplier.lastupdateDate",
                "supplier.version",
                "products.product.supplier",
                "products.product.unitPrice",
                "products.product.unitInStock",
                "products.product.unitOnOrder",
                "products.product.active",
                "products.product.createBy",
                "products.product.createDate",
                "products.product.lastupdateBy",
                "products.product.lastupdateDate",
                "products.product.version",
                "services.service.createBy",
                "services.service.createDate",
                "services.service.lastupdateBy",
                "services.service.lastupdateDate",
                "department.createBy",
                "department.createDate",
                "department.lastupdateBy",
                "department.lastupdateDate",
                "department.version",
                "branch.createBy",
                "branch.createDate",
                "branch.lastupdateBy",
                "branch.lastupdateDate"
        ).include(
                "products",
                "services",
                "products.product",
                "services.service",
                "purchaseBy.title",
                "approveBy.title"
        ).transform(new DateTransformer("yyyy-MM-dd'T'HH:mm:ssZ"), Date.class)
                .serialize(result);
        response.getOutputStream().print(json);*/

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Map search(@RequestBody PurchaseQuery query)  {
        Map result = pRepository.findByQuery(query);
        return result;
        /*JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude("*.class",
                "list.purchaseBy.educations",
                "list.purchaseBy.experiences",
                "list.purchaseBy.siblings",
                "list.purchaseBy.chidren",
                "list.purchaseBy.trainings",
                "list.purchaseBy.languages",
                "list.purchaseBy.references",
                "list.purchaseBy.position",
                "list.purchaseBy.department",
                "list.purchaseBy.address",
                "list.purchaseBy.createBy",
                "list.purchaseBy.createDate",
                "list.purchaseBy.lastupdateBy",
                "list.purchaseBy.lastupdateDate",
                "list.purchaseBy.branch",
                "list.purchaseBy.version",
                "list.approveBy",
                "list.supplier.address",
                "list.supplier.contact",
                "list.supplier.createBy",
                "list.supplier.createDate",
                "list.supplier.lastupdateBy",
                "list.supplier.lastupdateDate",
                "list.supplier.version",
                "list.products",
                "list.services",
                "list.products.product",
                "list.services.service",
                "list.department.createBy",
                "list.department.createDate",
                "list.department.lastupdateBy",
                "list.department.lastupdateDate",
                "list.department.version",
                "list.branch.createBy",
                "list.branch.createDate",
                "list.branch.lastupdateBy",
                "list.branch.lastupdateDate"
        ).include("pages")
                .transform(new DateTransformer("dd/MM/yyyy"), Date.class)
                .serialize(result);
        response.getOutputStream().print(json);*/
    }
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Purchase data,HttpServletResponse response) throws Exception
    {
       
        pRepository.remove(data.getId());
        response.getOutputStream().print("success");
    }
}
