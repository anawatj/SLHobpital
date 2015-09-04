/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.order;

import com.arg.arsoft.siantluis.domains.AbstractQuery;
import java.util.Date;

/**
 *
 * @author anawatj
 */
public class OrderQuery extends AbstractQuery {
    
    public OrderQuery()
    {
        
    }
    private String code;
    private String name;
    private Date orderDateStart;
    private Date orderDateEnd;
    private Date requireDateStart;
    private Date requireDateEnd;
    private String employee;
    private String customer;
    private Integer shipper;

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

    /**
     * @return the orderDateStart
     */
    public Date getOrderDateStart() {
        return orderDateStart;
    }

    /**
     * @param orderDateStart the orderDateStart to set
     */
    public void setOrderDateStart(Date orderDateStart) {
        this.orderDateStart = orderDateStart;
    }

    /**
     * @return the orderDateEnd
     */
    public Date getOrderDateEnd() {
        return orderDateEnd;
    }

    /**
     * @param orderDateEnd the orderDateEnd to set
     */
    public void setOrderDateEnd(Date orderDateEnd) {
        this.orderDateEnd = orderDateEnd;
    }

    /**
     * @return the requireDateStart
     */
    public Date getRequireDateStart() {
        return requireDateStart;
    }

    /**
     * @param requireDateStart the requireDateStart to set
     */
    public void setRequireDateStart(Date requireDateStart) {
        this.requireDateStart = requireDateStart;
    }

    /**
     * @return the requireDateEnd
     */
    public Date getRequireDateEnd() {
        return requireDateEnd;
    }

    /**
     * @param requireDateEnd the requireDateEnd to set
     */
    public void setRequireDateEnd(Date requireDateEnd) {
        this.requireDateEnd = requireDateEnd;
    }

    /**
     * @return the employee
     */
    public String getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(String employee) {
        this.employee = employee;
    }

    /**
     * @return the customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * @return the shipper
     */
    public Integer getShipper() {
        return shipper;
    }

    /**
     * @param shipper the shipper to set
     */
    public void setShipper(Integer shipper) {
        this.shipper = shipper;
    }
    
    
    
}
