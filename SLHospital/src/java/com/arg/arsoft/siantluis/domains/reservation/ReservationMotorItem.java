/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.reservation;

import com.arg.arsoft.siantluis.domains.master.MotorEquipment;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Tao
 */
@JsonInclude
public class ReservationMotorItem extends ReservationItem {
    
   public ReservationMotorItem()
   {
       
   }
   private MotorEquipment equipment;
   private Integer quantity;

    /**
     * @return the equipment
     */
    public MotorEquipment getEquipment() {
        return equipment;
    }

    /**
     * @param equipment the equipment to set
     */
    public void setEquipment(MotorEquipment equipment) {
        this.equipment = equipment;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
