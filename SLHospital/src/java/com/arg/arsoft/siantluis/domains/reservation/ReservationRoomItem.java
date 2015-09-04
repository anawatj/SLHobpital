/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.reservation;

import com.arg.arsoft.siantluis.domains.master.RoomEquipment;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRoomItem extends ReservationItem {
    public ReservationRoomItem()
    {
        
    }
    private RoomEquipment equipment;

    /**
     * @return the equipment
     */
    public RoomEquipment getEquipment() {
        return equipment;
    }

    /**
     * @param equipment the equipment to set
     */
    public void setEquipment(RoomEquipment equipment) {
        this.equipment = equipment;
    }
    
}
