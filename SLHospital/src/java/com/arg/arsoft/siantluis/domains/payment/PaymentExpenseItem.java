/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.payment;

import com.arg.arsoft.siantluis.domains.master.Expense;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentExpenseItem extends PaymentItem {
    
    public PaymentExpenseItem()
    {
        
    }
    private Expense expense;
    private String referenceNo;

    /**
     * @return the expense
     */
    public Expense getExpense() {
        return expense;
    }

    /**
     * @param expense the expense to set
     */
    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    /**
     * @return the referenceNo
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * @param referenceNo the referenceNo to set
     */
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }
}
