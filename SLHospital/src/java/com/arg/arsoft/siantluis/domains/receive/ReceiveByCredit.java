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
public class ReceiveByCredit extends ReceiveByItem {

    private String creditCardNo;
    private Date paymentDate;
    private Bank bank;
    private String barnch;

    /**
     * @return the creditCardNo
     */
    public String getCreditCardNo() {
        return creditCardNo;
    }

    /**
     * @param creditCardNo the creditCardNo to set
     */
    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
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
     * @return the barnch
     */
    public String getBarnch() {
        return barnch;
    }

    /**
     * @param barnch the barnch to set
     */
    public void setBarnch(String barnch) {
        this.barnch = barnch;
    }
}
