/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.receive;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiveByCash extends ReceiveByItem {
    
    private Date receiveDate;

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
    
}
