/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.project.Project;
import com.arg.arsoft.siantluis.domains.project.ProjectItem;
import com.arg.arsoft.siantluis.domains.project.ProjectItemFrm;
import com.arg.arsoft.siantluis.domains.project.ProjectQuery;
import com.arg.arsoft.siantluis.repository.IProjectRepository;
import flexjson.JSONSerializer;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author anawatj
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    IProjectRepository pRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<Project> getAll() {
        List<Project> result = pRepository.findAll();
        return result;
    }

    @RequestMapping(value = "/getByKey", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody Project getByKey(@RequestParam Integer key) {
        Project result = pRepository.findByKey(key);
        if (result == null) {
            result = new Project();
        }
        return result;
       /* JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude("class",
                "items.class",
                "items.frms.class",
                "items.frms.productGroup.class",
                "items.frms.productGroup.createBy",
                "items.frms.productGroup.createDate",
                "items.frms.productGroup.lastupdateBy",
                "items.frms.productGroup.lastupdateDate",
                "items.frms.productGroup.version"
        ).include(
                "items",
                "items.frms",
                "items.frms.productGroup")
                .include("supplier")
                .serialize(result);
        response.getOutputStream().print(json);*/
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Project save(@RequestBody Project entity) {
        for (ProjectItem item : entity.getItems()) {
            for (ProjectItemFrm frm : item.getFrms()) {
                if ((frm.getProductGroup() != null) && (frm.getProductGroup().getId() == null || frm.getProductGroup().getId() == 0)) {
                    frm.setProductGroup(null);
                }
            }
        }
        Project result = pRepository.save(entity);
        return result;

       /* JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude("class",
                "items.class",
                "items.frms.class",
                "items.frms.productGroup.class",
                "items.frms.productGroup.createBy",
                "items.frms.productGroup.createDate",
                "items.frms.productGroup.lastupdateBy",
                "items.frms.productGroup.lastupdateDate",
                "items.frms.productGroup.version"
        ).include(
                "items",
                "items.frms",
                "items.frms.productGroup")
                .include("supplier")
                .serialize(result);
        response.getOutputStream().print(json);*/
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody Map search(@RequestBody ProjectQuery query)  {
        Map result = pRepository.findByQuery(query);
        return result;
       /* JSONSerializer serialize = new JSONSerializer();
        String json = serialize.exclude("list.class",
                "list.items",
                "list.items.frms",
                "list.items.frms.productGroup"
        ).include("pages")
                .serialize(result);
        response.getOutputStream().print(json);*/
    }
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Project data ,HttpServletResponse response) throws Exception
    {
        pRepository.remove(data.getId());
        response.getOutputStream().print("Success");
    }
}
