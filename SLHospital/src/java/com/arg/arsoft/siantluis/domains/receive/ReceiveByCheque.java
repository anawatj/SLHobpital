/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.receive;

import com.arg.arsoft.siantluis.domains.master.Bank;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiveByCheque extends ReceiveByItem {
    
    private String chequeNo;
    private Date chequeDate;
    private Bank bank;
    private String branch;
    private String chequeBy;

    /**
     * @return the chequeNo
     */
    public String getChequeNo() {
        return chequeNo;
    }

    /**
     * @param chequeNo the chequeNo to set
     */
    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    /**
     * @return the chequeDate
     */
    public Date getChequeDate() {
        return chequeDate;
    }

    /**
     * @param chequeDate the chequeDate to set
     */
    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

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
     * @return the chequeBy
     */
    public String getChequeBy() {
        return chequeBy;
    }

    /**
     * @param chequeBy the chequeBy to set
     */
    public void setChequeBy(String chequeBy) {
        this.chequeBy = chequeBy;
    }
}
