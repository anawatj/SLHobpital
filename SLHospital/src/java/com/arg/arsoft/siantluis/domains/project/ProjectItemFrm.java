/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.project;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.master.ProductGroup;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectItemFrm extends AbstractDomain<Integer> {
    
    public ProjectItemFrm()
    {
        
    }
    private Integer projectItemId;
    private ProductGroup productGroup;
    private boolean selected;

    /**
     * @return the projectItemId
     */
    public Integer getProjectItemId() {
        return projectItemId;
    }

    /**
     * @param projectItemId the projectItemId to set
     */
    public void setProjectItemId(Integer projectItemId) {
        this.projectItemId = projectItemId;
    }

    /**
     * @return the productGroup
     */
    public ProductGroup getProductGroup() {
        return productGroup;
    }

    /**
     * @param productGroup the productGroup to set
     */
    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
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
