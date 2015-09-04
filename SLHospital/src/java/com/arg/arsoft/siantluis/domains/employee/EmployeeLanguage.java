/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.employee;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.master.Language;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeLanguage extends AbstractDomain<Integer> {
    
    public EmployeeLanguage()
    {
        
    }
    private Integer employeeId;
    private Language language;
    private FlagLanguage reading;
    private FlagLanguage writing;
    private FlagLanguage listing;
    private FlagLanguage speaking;
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
     * @return the language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    /**
     * @return the reading
     */
    public FlagLanguage getReading() {
        return reading;
    }

    /**
     * @param reading the reading to set
     */
    public void setReading(FlagLanguage reading) {
        this.reading = reading;
    }

    /**
     * @return the writing
     */
    public FlagLanguage getWriting() {
        return writing;
    }

    /**
     * @param writing the writing to set
     */
    public void setWriting(FlagLanguage writing) {
        this.writing = writing;
    }

    /**
     * @return the listing
     */
    public FlagLanguage getListing() {
        return listing;
    }

    /**
     * @param listing the listing to set
     */
    public void setListing(FlagLanguage listing) {
        this.listing = listing;
    }

    /**
     * @return the speaking
     */
    public FlagLanguage getSpeaking() {
        return speaking;
    }

    /**
     * @param speaking the speaking to set
     */
    public void setSpeaking(FlagLanguage speaking) {
        this.speaking = speaking;
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
