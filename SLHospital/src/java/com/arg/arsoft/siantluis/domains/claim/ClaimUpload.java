/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.claim;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import java.util.Date;

/**
 *
 * @author anawatj
 */
public class ClaimUpload extends AbstractDomain<Integer> {
    
    public ClaimUpload()
    {
        
    }
    private String code;
    private String desc;
    private String claimDate;
    private String claimTime;
    private String claimLocation;
    private String claimReason;

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
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the claimDate
     */
    public String getClaimDate() {
        return claimDate;
    }

    /**
     * @param claimDate the claimDate to set
     */
    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    /**
     * @return the claimTime
     */
    public String getClaimTime() {
        return claimTime;
    }

    /**
     * @param claimTime the claimTime to set
     */
    public void setClaimTime(String claimTime) {
        this.claimTime = claimTime;
    }

    /**
     * @return the claimLocation
     */
    public String getClaimLocation() {
        return claimLocation;
    }

    /**
     * @param claimLocation the claimLocation to set
     */
    public void setClaimLocation(String claimLocation) {
        this.claimLocation = claimLocation;
    }

    /**
     * @return the claimReason
     */
    public String getClaimReason() {
        return claimReason;
    }

    /**
     * @param claimReason the claimReason to set
     */
    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }
    
}
