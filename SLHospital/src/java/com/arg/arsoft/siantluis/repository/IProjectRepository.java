/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;

import com.arg.arsoft.siantluis.domains.project.Project;
import com.arg.arsoft.siantluis.domains.project.ProjectQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anawatj
 */
public interface IProjectRepository extends Repository<Project,Integer>{
    
    
    @Override
    public List<Project> findAll();
    
    @Override
    public Project findByKey(Integer key);
    
    @Override
    public Project save(Project entity);
    
    @Override
    public void remove(Integer key);
    
    public Map findByQuery(ProjectQuery query);
}
