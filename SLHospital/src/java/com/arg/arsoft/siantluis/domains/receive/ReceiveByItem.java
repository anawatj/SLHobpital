/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.receive;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ReceiveByItem extends AbstractDomain<Integer> {
    
    private Integer receiveId;
    private Double amount;

    /**
     * @return the receiveId
     */
    public Integer getReceiveId() {
        return receiveId;
    }

    /**
     * @param receiveId the receiveId to set
     */
    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
