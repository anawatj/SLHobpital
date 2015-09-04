/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wongskont
 */
public interface IDomain<K extends Serializable> {
    
    public K getId();
    
    public void setId(K id);
    
    public int getVersion();
    public void setVersion(int version);
    
    public String getCreateBy();
    public void setCreateBy(String createBy);
    
    public Date getCreateDate();
    public void setCreateDate(Date createDate);
    
    public String getLastupdateBy();
    public void setLastupdateBy(String lastupdateBy);
    
    public Date getLastupdateDate();
    public void setLastupdateDate(Date lastupdateDate);
    
    
    
    
}
