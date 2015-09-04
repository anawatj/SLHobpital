/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.reservation;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.attachment.Attachment;
import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Tao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reservation extends AbstractDomain<Integer>{
    
    
    public Reservation()
    {
        this.rooms = new HashSet<ReservationRoomItem>();
        this.motors = new HashSet<ReservationMotorItem>();
        this.its = new HashSet<ReservationITItem>();
    }
    
    private String code;
    private String description;
    private Employee reservationBy;
    private Date reservationDate;
    private Employee approveBy;
    private Date approveDate;
    private Attachment attachment;
    
    private Set<ReservationRoomItem> rooms;
    private Set<ReservationMotorItem> motors;
    private Set<ReservationITItem> its;

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
     * @return the reservationBy
     */
    public Employee getReservationBy() {
        return reservationBy;
    }

    /**
     * @param reservationBy the reservationBy to set
     */
    public void setReservationBy(Employee reservationBy) {
        this.reservationBy = reservationBy;
    }

    /**
     * @return the reservationDate
     */
    public Date getReservationDate() {
        return reservationDate;
    }

    /**
     * @param reservationDate the reservationDate to set
     */
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    /**
     * @return the approveBy
     */
    public Employee getApproveBy() {
        return approveBy;
    }

    /**
     * @param approveBy the approveBy to set
     */
    public void setApproveBy(Employee approveBy) {
        this.approveBy = approveBy;
    }

    /**
     * @return the approveDate
     */
    public Date getApproveDate() {
        return approveDate;
    }

    /**
     * @param approveDate the approveDate to set
     */
    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    /**
     * @return the attachment
     */
    public Attachment getAttachment() {
        return attachment;
    }

    /**
     * @param attachment the attachment to set
     */
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    /**
     * @return the rooms
     */
    public Set<ReservationRoomItem> getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(Set<ReservationRoomItem> rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the motors
     */
    public Set<ReservationMotorItem> getMotors() {
        return motors;
    }

    /**
     * @param motors the motors to set
     */
    public void setMotors(Set<ReservationMotorItem> motors) {
        this.motors = motors;
    }

    /**
     * @return the its
     */
    public Set<ReservationITItem> getIts() {
        return its;
    }

    /**
     * @param its the its to set
     */
    public void setIts(Set<ReservationITItem> its) {
        this.its = its;
    }
  
    
    
}
