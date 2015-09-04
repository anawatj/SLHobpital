/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.employee;


import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.master.EducationLevel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author wongskont
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Education extends AbstractDomain<Integer>{
    
   
    private Integer employeeId;
    private EducationLevel educationLevel;
    private String university;
    private String major;
    private Double gpa;
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
     * @return the educationLevel
     */
    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    /**
     * @param educationLevel the educationLevel to set
     */
    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * @return the university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the gpa
     */
    public Double getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(Double gpa) {
        this.gpa = gpa;
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
