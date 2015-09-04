/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.reservation;

import com.arg.arsoft.siantluis.domains.master.ITEquipment;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationITItem extends ReservationItem {
    public ReservationITItem()
    {
        
    }
    private ITEquipment equipment;
    private String serialNo;

    /**
     * @return the equipment
     */
    public ITEquipment getEquipment() {
        return equipment;
    }

    /**
     * @param equipment the equipment to set
     */
    public void setEquipment(ITEquipment equipment) {
        this.equipment = equipment;
    }

    /**
     * @return the serialNo
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * @param serialNo the serialNo to set
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
