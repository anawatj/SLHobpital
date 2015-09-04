/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.customer;

import com.arg.arsoft.siantluis.domains.AbstractQuery;

/**
 *
 * @author anawatj
 */
public class CustomerQuery extends AbstractQuery {
    
    
    private String code;
    private String name;
    private String company;
    private String contactName;
    private Integer province;
    private String flagPersonal;
    private String flagCompany;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName the contactName to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return the province
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * @return the flagPersonal
     */
    public String getFlagPersonal() {
        return flagPersonal;
    }

    /**
     * @param flagPersonal the flagPersonal to set
     */
    public void setFlagPersonal(String flagPersonal) {
        this.flagPersonal = flagPersonal;
    }

    /**
     * @return the flagCompany
     */
    public String getFlagCompany() {
        return flagCompany;
    }

    /**
     * @param flagCompany the flagCompany to set
     */
    public void setFlagCompany(String flagCompany) {
        this.flagCompany = flagCompany;
    }
    
}
