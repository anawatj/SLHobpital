/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.receive;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.attachment.Attachment;
import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.arg.arsoft.siantluis.domains.master.Branch;
import com.arg.arsoft.siantluis.domains.master.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Receive extends AbstractDomain<Integer> {
    
    private String code;
    private String description;
    private Date receiveDate;
    private Employee receiveBy;
    private Date approveDate;
    private Employee approveBy;
    private ReceiveStatus status;
    private Department department;
    private Branch branch;
    private Attachment attachment;
    
    private Set<ReceiveOrder> orders;
    private Set<ReceiveIncome> incomes;
    private Set<ReceiveByCash> cashes;
    private Set<ReceiveByCheque> cheques;
    private Set<ReceiveByCredit> credits;
    private Set<ReceiveByTransfer> transfers;

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
     * @return the receiveDate
     */
    public Date getReceiveDate() {
        return receiveDate;
    }

    /**
     * @param receiveDate the receiveDate to set
     */
    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    /**
     * @return the receiveBy
     */
    public Employee getReceiveBy() {
        return receiveBy;
    }

    /**
     * @param receiveBy the receiveBy to set
     */
    public void setReceiveBy(Employee receiveBy) {
        this.receiveBy = receiveBy;
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
     * @return the status
     */
    public ReceiveStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ReceiveStatus status) {
        this.status = status;
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
     * @return the attachment
     */
    public Attachment getAttachment() {
        return attachment;
    }

    /**
     * @param attachment the attachment to set
     */
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    /**
     * @return the orders
     */
    public Set<ReceiveOrder> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Set<ReceiveOrder> orders) {
        this.orders = orders;
    }

    /**
     * @return the incomes
     */
    public Set<ReceiveIncome> getIncomes() {
        return incomes;
    }

    /**
     * @param incomes the incomes to set
     */
    public void setIncomes(Set<ReceiveIncome> incomes) {
        this.incomes = incomes;
    }

    /**
     * @return the cashes
     */
    public Set<ReceiveByCash> getCashes() {
        return cashes;
    }

    /**
     * @param cashes the cashes to set
     */
    public void setCashes(Set<ReceiveByCash> cashes) {
        this.cashes = cashes;
    }

    /**
     * @return the cheques
     */
    public Set<ReceiveByCheque> getCheques() {
        return cheques;
    }

    /**
     * @param cheques the cheques to set
     */
    public void setCheques(Set<ReceiveByCheque> cheques) {
        this.cheques = cheques;
    }

    /**
     * @return the credits
     */
    public Set<ReceiveByCredit> getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(Set<ReceiveByCredit> credits) {
        this.credits = credits;
    }

    /**
     * @return the transfers
     */
    public Set<ReceiveByTransfer> getTransfers() {
        return transfers;
    }

    /**
     * @param transfers the transfers to set
     */
    public void setTransfers(Set<ReceiveByTransfer> transfers) {
        this.transfers = transfers;
    }
}
