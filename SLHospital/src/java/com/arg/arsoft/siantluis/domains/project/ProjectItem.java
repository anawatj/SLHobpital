/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.project;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectItem extends AbstractDomain<Integer> {
    
    public ProjectItem()
    {
        this.frms  =new HashSet<ProjectItemFrm>();
    }
    private Integer projectId;
    private String projectGroup;
    private Set<ProjectItemFrm> frms;
    private boolean selected;

    /**
     * @return the projectId
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the projectGroup
     */
    public String getProjectGroup() {
        return projectGroup;
    }

    /**
     * @param projectGroup the projectGroup to set
     */
    public void setProjectGroup(String projectGroup) {
        this.projectGroup = projectGroup;
    }

    /**
     * @return the frms
     */
    public Set<ProjectItemFrm> getFrms() {
        return frms;
    }

    /**
     * @param frms the frms to set
     */
    public void setFrms(Set<ProjectItemFrm> frms) {
        this.frms = frms;
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
