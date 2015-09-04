/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.payment;

import com.arg.arsoft.siantluis.domains.AbstractQuery;
import java.util.Date;

/**
 *
 * @author Tao
 */
public class PaymentQuery extends AbstractQuery {
    
    public PaymentQuery()
    {
        
    }
    private String code;
    private String name;
    private String paymentBy;
    private Date paymentDateFrom;
    private Date paymentDateTo;
    private Integer department;
    private Integer branch;

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
     * @return the paymentBy
     */
    public String getPaymentBy() {
        return paymentBy;
    }

    /**
     * @param paymentBy the paymentBy to set
     */
    public void setPaymentBy(String paymentBy) {
        this.paymentBy = paymentBy;
    }

    /**
     * @return the paymentDateFrom
     */
    public Date getPaymentDateFrom() {
        return paymentDateFrom;
    }

    /**
     * @param paymentDateFrom the paymentDateFrom to set
     */
    public void setPaymentDateFrom(Date paymentDateFrom) {
        this.paymentDateFrom = paymentDateFrom;
    }

    /**
     * @return the paymentDateTo
     */
    public Date getPaymentDateTo() {
        return paymentDateTo;
    }

    /**
     * @param paymentDateTo the paymentDateTo to set
     */
    public void setPaymentDateTo(Date paymentDateTo) {
        this.paymentDateTo = paymentDateTo;
    }

    /**
     * @return the department
     */
    public Integer getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Integer department) {
        this.department = department;
    }

    /**
     * @return the branch
     */
    public Integer getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(Integer branch) {
        this.branch = branch;
    }
}
