/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.payment;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.attachment.Attachment;
import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.arg.arsoft.siantluis.domains.master.Branch;
import com.arg.arsoft.siantluis.domains.master.Department;
import com.arg.arsoft.siantluis.domains.purchase.Purchase;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment extends AbstractDomain<Integer> {
    
    public Payment()
    {
        this.expenses = new HashSet<PaymentExpenseItem>();
        this.purchases = new HashSet<PaymentPurchaseItem>();
        this.cashes = new HashSet<PaymentByCash>();
        this.cheques = new HashSet<PaymentByCheque>();
        this.credits = new HashSet<PaymentByCredit>();
        this.transfers = new HashSet<PaymentByTransfer>();
    }
    private String code;
    private String name;
    private Date paymentDate;
    private Employee paymentBy;
    private PaymentStatus status;
    private Date approveDate;
    private Employee approveBy;
    private Department department;
    private Branch branch;
    private Attachment attachment;
    private Set<PaymentExpenseItem> expenses;
    private Set<PaymentPurchaseItem> purchases;
    private Set<PaymentByCash> cashes;
    private Set<PaymentByCheque> cheques;
    private Set<PaymentByCredit> credits;
    private Set<PaymentByTransfer> transfers;
   

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
     * @return the paymentDate
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the paymentBy
     */
    public Employee getPaymentBy() {
        return paymentBy;
    }

    /**
     * @param paymentBy the paymentBy to set
     */
    public void setPaymentBy(Employee paymentBy) {
        this.paymentBy = paymentBy;
    }

    /**
     * @return the status
     */
    public PaymentStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(PaymentStatus status) {
        this.status = status;
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
     * @return the expenses
     */
    public Set<PaymentExpenseItem> getExpenses() {
        return expenses;
    }

    /**
     * @param expenses the expenses to set
     */
    public void setExpenses(Set<PaymentExpenseItem> expenses) {
        this.expenses = expenses;
    }

    /**
     * @return the purchases
     */
    public Set<PaymentPurchaseItem> getPurchases() {
        return purchases;
    }

    /**
     * @param purchases the purchases to set
     */
    public void setPurchases(Set<PaymentPurchaseItem> purchases) {
        this.purchases = purchases;
    }

    /**
     * @return the cashes
     */
    public Set<PaymentByCash> getCashes() {
        return cashes;
    }

    /**
     * @param cashes the cashes to set
     */
    public void setCashes(Set<PaymentByCash> cashes) {
        this.cashes = cashes;
    }

    /**
     * @return the cheques
     */
    public Set<PaymentByCheque> getCheques() {
        return cheques;
    }

    /**
     * @param cheques the cheques to set
     */
    public void setCheques(Set<PaymentByCheque> cheques) {
        this.cheques = cheques;
    }

    /**
     * @return the credits
     */
    public Set<PaymentByCredit> getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(Set<PaymentByCredit> credits) {
        this.credits = credits;
    }

    /**
     * @return the transfers
     */
    public Set<PaymentByTransfer> getTransfers() {
        return transfers;
    }

    /**
     * @param transfers the transfers to set
     */
    public void setTransfers(Set<PaymentByTransfer> transfers) {
        this.transfers = transfers;
    }
    
}
