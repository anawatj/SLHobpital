/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.receive;

import com.arg.arsoft.siantluis.domains.master.Income;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiveIncome extends ReceiveItem {
    
    private Income income;
    private String referenceNo;

    /**
     * @return the income
     */
    public Income getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(Income income) {
        this.income = income;
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
