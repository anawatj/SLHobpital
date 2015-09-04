/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.project;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project extends AbstractDomain<Integer> {
    
    public Project()
    {
        this.items  =new HashSet<ProjectItem>();
    }
    private String code;
    private String name;
    private ProjectType type;
    private Set<ProjectItem> items;

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
     * @return the type
     */
    public ProjectType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ProjectType type) {
        this.type = type;
    }

    /**
     * @return the items
     */
    public Set<ProjectItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Set<ProjectItem> items) {
        this.items = items;
    }
    
}
