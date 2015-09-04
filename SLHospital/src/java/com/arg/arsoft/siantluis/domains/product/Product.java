/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.product;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends AbstractDomain<Integer> {
    
    private String code;
    private String name;
    private Supplier supplier;
    private Double unitPrice;
    private Integer unitInStock;
    private Integer unitOnOrder;
    private ProductActive active;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

 

    /**
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the unitInStock
     */
    public Integer getUnitInStock() {
        return unitInStock;
    }

    /**
     * @param unitInStock the unitInStock to set
     */
    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    /**
     * @return the unitOnOrder
     */
    public Integer getUnitOnOrder() {
        return unitOnOrder;
    }

    /**
     * @param unitOnOrder the unitOnOrder to set
     */
    public void setUnitOnOrder(Integer unitOnOrder) {
        this.unitOnOrder = unitOnOrder;
    }

    /**
     * @return the active
     */
    public ProductActive getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(ProductActive active) {
        this.active = active;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
