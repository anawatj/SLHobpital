/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.employee;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Experience extends AbstractDomain<Integer> {
    
    public Experience()
    {
        
    }
    private Integer employeeId;
    private String company;
    private String position;
    private String reponsiability;
    private Date hiredDate;
    private Date resignedDate;
    private Double salary;
    private String reasonOfResign;
    private boolean selected;
    /**
     * @return the employeeId
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the reponsiability
     */
    public String getReponsiability() {
        return reponsiability;
    }

    /**
     * @param reponsiability the reponsiability to set
     */
    public void setReponsiability(String reponsiability) {
        this.reponsiability = reponsiability;
    }

    /**
     * @return the hiredDate
     */
    public Date getHiredDate() {
        return hiredDate;
    }

    /**
     * @param hiredDate the hiredDate to set
     */
    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * @return the resignedDate
     */
    public Date getResignedDate() {
        return resignedDate;
    }

    /**
     * @param resignedDate the resignedDate to set
     */
    public void setResignedDate(Date resignedDate) {
        this.resignedDate = resignedDate;
    }

    /**
     * @return the salary
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * @return the reasonOfResign
     */
    public String getReasonOfResign() {
        return reasonOfResign;
    }

    /**
     * @param reasonOfResign the reasonOfResign to set
     */
    public void setReasonOfResign(String reasonOfResign) {
        this.reasonOfResign = reasonOfResign;
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
