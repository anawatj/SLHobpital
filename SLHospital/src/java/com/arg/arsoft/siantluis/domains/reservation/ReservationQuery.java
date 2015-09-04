/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.reservation;

import com.arg.arsoft.siantluis.domains.AbstractQuery;
import java.util.Date;

/**
 *
 * @author Tao
 */
public class ReservationQuery extends AbstractQuery {
    
    
    private String code;
    private String description;
    private String requestBy;
    private Date reservationDateFrom;
    private Date reservationDateTo;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the requestBy
     */
    public String getRequestBy() {
        return requestBy;
    }

    /**
     * @param requestBy the requestBy to set
     */
    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    /**
     * @return the reservationDateFrom
     */
    public Date getReservationDateFrom() {
        return reservationDateFrom;
    }

    /**
     * @param reservationDateFrom the reservationDateFrom to set
     */
    public void setReservationDateFrom(Date reservationDateFrom) {
        this.reservationDateFrom = reservationDateFrom;
    }

    /**
     * @return the reservationDateTo
     */
    public Date getReservationDateTo() {
        return reservationDateTo;
    }

    /**
     * @param reservationDateTo the reservationDateTo to set
     */
    public void setReservationDateTo(Date reservationDateTo) {
        this.reservationDateTo = reservationDateTo;
    }
}
