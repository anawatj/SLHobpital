/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.purchase;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.arg.arsoft.siantluis.domains.master.Branch;
import com.arg.arsoft.siantluis.domains.master.Department;
import com.arg.arsoft.siantluis.domains.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Purchase extends AbstractDomain<Integer> {
    
    public Purchase()
    {
        this.products = new  HashSet<PurchaseItemProduct>();
        this.services = new HashSet<PurchaseItemService>();
    }
    
    private String code;
    private Date purchaseDate;
    private String description;
    private PurchaseStatus status;
    private Employee purchaseBy;
    private Employee approveBy;
    private Date approveDate;
    private Supplier supplier;
    private Branch branch;
    private Department department;
    private Set<PurchaseItemProduct> products;
    private Set<PurchaseItemService> services;
 

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
     * @return the purchaseDate
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * @param purchaseDate the purchaseDate to set
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public PurchaseStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }

    /**
     * @return the purchaseBy
     */
    public Employee getPurchaseBy() {
        return purchaseBy;
    }

    /**
     * @param purchaseBy the purchaseBy to set
     */
    public void setPurchaseBy(Employee purchaseBy) {
        this.purchaseBy = purchaseBy;
    }

    /**
     * @return the approveBy
     */
    public Employee getApproveBy() {
        return approveBy;
    }

    /**
     * @param approveBy the approveBy to set
     */
    public void setApproveBy(Employee approveBy) {
        this.approveBy = approveBy;
    }

    /**
     * @return the approveDate
     */
    public Date getApproveDate() {
        return approveDate;
    }

    /**
     * @param approveDate the approveDate to set
     */
    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
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
     * @return the items
     */
    /*public List<PurchaseItem> getItems() {
        return items;
    }*/

    /**
     * @param items the items to set
     */
  /*  public void setItems(List<PurchaseItem> items) {
        this.items = items;
    */

    /**
     * @return the branch
     */
    public Branch getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @return the products
     */
    public Set<PurchaseItemProduct> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Set<PurchaseItemProduct> products) {
        this.products = products;
    }

    /**
     * @return the services
     */
    public Set<PurchaseItemService> getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(Set<PurchaseItemService> services) {
        this.services = services;
    }

 
    
    
}
