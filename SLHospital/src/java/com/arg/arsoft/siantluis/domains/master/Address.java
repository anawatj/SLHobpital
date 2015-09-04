/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.master;

import com.arg.arsoft.siantluis.domains.master.Amphur;
import com.arg.arsoft.siantluis.domains.master.Province;
import java.io.Serializable;

/**
 *
 * @author anawatj
 */
public class Address implements Serializable {
    
    private String addressNo;
    private String road;
    private String soi;
    private String moo;
    private String district;
    private Amphur amphur;
    private Province province;

    /**
     * @return the addressNo
     */
    public String getAddressNo() {
        return addressNo;
    }

    /**
     * @param addressNo the addressNo to set
     */
    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    /**
     * @return the road
     */
    public String getRoad() {
        return road;
    }

    /**
     * @param road the road to set
     */
    public void setRoad(String road) {
        this.road = road;
    }

    /**
     * @return the soi
     */
    public String getSoi() {
        return soi;
    }

    /**
     * @param soi the soi to set
     */
    public void setSoi(String soi) {
        this.soi = soi;
    }

    /**
     * @return the moo
     */
    public String getMoo() {
        return moo;
    }

    /**
     * @param moo the moo to set
     */
    public void setMoo(String moo) {
        this.moo = moo;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the amphur
     */
    public Amphur getAmphur() {
        return amphur;
    }

    /**
     * @param amphur the amphur to set
     */
    public void setAmphur(Amphur amphur) {
        this.amphur = amphur;
    }

    /**
     * @return the province
     */
    public Province getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(Province province) {
        this.province = province;
    }
   
}
