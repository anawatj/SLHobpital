/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.purchase;

import com.arg.arsoft.siantluis.domains.AbstractQuery;
import java.util.Date;

/**
 *
 * @author anawatj
 */
public class PurchaseQuery extends AbstractQuery{
    public PurchaseQuery()
    {
        
    }
    private String code;
    private String name;
    private Date purchaseDateStart;
    private Date purchaseDateEnd;
    private String purchaseBy;
    private String supplier;
    private String status;
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
     * @return the purchaseDateStart
     */
    public Date getPurchaseDateStart() {
        return purchaseDateStart;
    }

    /**
     * @param purchaseDateStart the purchaseDateStart to set
     */
    public void setPurchaseDateStart(Date purchaseDateStart) {
        this.purchaseDateStart = purchaseDateStart;
    }

    /**
     * @return the purchaseDateEnd
     */
    public Date getPurchaseDateEnd() {
        return purchaseDateEnd;
    }

    /**
     * @param purchaseDateEnd the purchaseDateEnd to set
     */
    public void setPurchaseDateEnd(Date purchaseDateEnd) {
        this.purchaseDateEnd = purchaseDateEnd;
    }

    /**
     * @return the purchaseBy
     */
    public String getPurchaseBy() {
        return purchaseBy;
    }

    /**
     * @param purchaseBy the purchaseBy to set
     */
    public void setPurchaseBy(String purchaseBy) {
        this.purchaseBy = purchaseBy;
    }

    /**
     * @return the supplier
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
