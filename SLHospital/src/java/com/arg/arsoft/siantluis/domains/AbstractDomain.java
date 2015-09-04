/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;



/**
 *
 * @author wongskont
 * @param <K>
 */

public abstract class AbstractDomain<K extends Serializable> implements IDomain<K>,Serializable {

   
    private K id;
  
    private int version;
 
    private String createBy;
    
    private Date createDate;
   
    private String lastupdateBy;
   
    private Date lastupdateDate;
    @Override
    public K getId() {
        return this.id;
    }

    @Override
    public void setId(K id) {
        this.id=id;
    }

    @Override
    public int getVersion() {
       return this.version;
    }

    @Override
    public void setVersion(int version) {
       this.version=version;
    }

    @Override
    public String getCreateBy() {
       return this.createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
       this.createBy= createBy;
    }

    @Override
    public Date getCreateDate() {
        return this.createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate=createDate;
    }

    @Override
    public String getLastupdateBy() {
        return this.lastupdateBy;
    }

    @Override
    public void setLastupdateBy(String lastupdateBy) {
        this.lastupdateBy= lastupdateBy;
    }

    @Override
    public Date getLastupdateDate() {
        return this.lastupdateDate;
    }

    @Override
    public void setLastupdateDate(Date lastupdateDate) {
        this.lastupdateDate= lastupdateDate;
    }
    
}
