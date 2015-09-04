/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.receive;

import com.arg.arsoft.siantluis.domains.order.Order;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiveOrder extends ReceiveItem {
    
    private Order order;

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }
    
}
