/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.master;


import com.arg.arsoft.siantluis.domains.MasterDataObject;
import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author wongskont
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hobby extends MasterDataObject {
    public Hobby()
    {
    
    }
    
  
    

    @Transient
    private boolean selected;
    
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
        {
            return false;
        }
        if(!(obj instanceof Hobby))
        {
            return false;
        }
        Hobby hobby = (Hobby) obj;
        return this.getId()==hobby.getId();
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
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
