/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.payment;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.master.Expense;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class PaymentItem extends AbstractDomain<Integer>{
    private Integer paymentId;
    private Date expenseDate;
    private String expenseTime;
    private Double expenseAmount;
 



    /**
     * @return the expenseDate
     */
    public Date getExpenseDate() {
        return expenseDate;
    }

    /**
     * @param expenseDate the expenseDate to set
     */
    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    /**
     * @return the expenseTime
     */
    public String getExpenseTime() {
        return expenseTime;
    }

    /**
     * @param expenseTime the expenseTime to set
     */
    public void setExpenseTime(String expenseTime) {
        this.expenseTime = expenseTime;
    }

    /**
     * @return the expenseAmount
     */
    public Double getExpenseAmount() {
        return expenseAmount;
    }

    /**
     * @param expenseAmount the expenseAmount to set
     */
    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    /**
     * @return the paymentId
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }


}
