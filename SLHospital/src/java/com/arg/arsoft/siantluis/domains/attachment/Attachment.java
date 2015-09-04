/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.attachment;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
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
public class Attachment extends AbstractDomain<Integer> {
    
    public Attachment()
    {
        this.items = new HashSet<AttachmentItem>();
    }
    private String code;
    private String description;
    private Employee attachBy;
    private Date attachDate;
    private Set<AttachmentItem> items;

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
     * @return the attachBy
     */
    public Employee getAttachBy() {
        return attachBy;
    }

    /**
     * @param attachBy the attachBy to set
     */
    public void setAttachBy(Employee attachBy) {
        this.attachBy = attachBy;
    }

    /**
     * @return the attachDate
     */
    public Date getAttachDate() {
        return attachDate;
    }

    /**
     * @param attachDate the attachDate to set
     */
    public void setAttachDate(Date attachDate) {
        this.attachDate = attachDate;
    }

    /**
     * @return the items
     */
    public Set<AttachmentItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Set<AttachmentItem> items) {
        this.items = items;
    }
    
}
