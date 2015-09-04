/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.payment;

import com.arg.arsoft.siantluis.domains.master.Bank;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentByTransfer extends PaymentByItem{
    
    private Bank bank;
    private String branch;
    private Date trsnsferDate;
    private String transferTime;
    private String bkBankNo;
    private Double fee;

    /**
     * @return the bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the trsnsferDate
     */
    public Date getTrsnsferDate() {
        return trsnsferDate;
    }

    /**
     * @param trsnsferDate the trsnsferDate to set
     */
    public void setTrsnsferDate(Date trsnsferDate) {
        this.trsnsferDate = trsnsferDate;
    }

    /**
     * @return the transferTime
     */
    public String getTransferTime() {
        return transferTime;
    }

    /**
     * @param transferTime the transferTime to set
     */
    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }

    /**
     * @return the bkBankNo
     */
    public String getBkBankNo() {
        return bkBankNo;
    }

    /**
     * @param bkBankNo the bkBankNo to set
     */
    public void setBkBankNo(String bkBankNo) {
        this.bkBankNo = bkBankNo;
    }

    /**
     * @return the fee
     */
    public Double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }
    
    
}
