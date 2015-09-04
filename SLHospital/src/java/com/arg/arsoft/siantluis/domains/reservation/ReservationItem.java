/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.reservation;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import java.util.Date;

/**
 *
 * @author Tao
 */
public abstract class ReservationItem extends AbstractDomain<Integer> {
    
    public ReservationItem()
    {
        
    }
    private Integer reservationId;
    private Date resvFromDate;
    private Date resvToDate;
    private String resvFromTime;
    private String resvToTime;
    private boolean selected;

    /**
     * @return the reservationId
     */
    public Integer getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId the reservationId to set
     */
    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * @return the resvFromDate
     */
    public Date getResvFromDate() {
        return resvFromDate;
    }

    /**
     * @param resvFromDate the resvFromDate to set
     */
    public void setResvFromDate(Date resvFromDate) {
        this.resvFromDate = resvFromDate;
    }

    /**
     * @return the resvToDate
     */
    public Date getResvToDate() {
        return resvToDate;
    }

    /**
     * @param resvToDate the resvToDate to set
     */
    public void setResvToDate(Date resvToDate) {
        this.resvToDate = resvToDate;
    }

    /**
     * @return the resvFromTime
     */
    public String getResvFromTime() {
        return resvFromTime;
    }

    /**
     * @param resvFromTime the resvFromTime to set
     */
    public void setResvFromTime(String resvFromTime) {
        this.resvFromTime = resvFromTime;
    }

    /**
     * @return the resvToTime
     */
    public String getResvToTime() {
        return resvToTime;
    }

    /**
     * @param resvToTime the resvToTime to set
     */
    public void setResvToTime(String resvToTime) {
        this.resvToTime = resvToTime;
    }

    /**
     * @return the selected
     */
    public boolean getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
}
