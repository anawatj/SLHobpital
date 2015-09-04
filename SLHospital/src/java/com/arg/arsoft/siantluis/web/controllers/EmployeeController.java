/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.controllers;

import com.arg.arsoft.siantluis.domains.employee.Children;
import com.arg.arsoft.siantluis.domains.employee.Education;
import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.arg.arsoft.siantluis.domains.employee.EmployeeLanguage;
import com.arg.arsoft.siantluis.domains.employee.EmployeeQuery;
import com.arg.arsoft.siantluis.domains.employee.Reference;
import com.arg.arsoft.siantluis.domains.employee.Sibling;
import com.arg.arsoft.siantluis.domains.master.Hobby;
import com.arg.arsoft.siantluis.repository.IEmployeeRepository;
import com.arg.arsoft.siantluis.repository.imp.MasterDataObjectRepository;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wongskont
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private SessionFactory factory;

    @Autowired
    private IEmployeeRepository eRepository;

    @Autowired
    private MasterDataObjectRepository mRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<Employee> getAll() {
        List<Employee> result = eRepository.findAll();
        return result;
    }

    @RequestMapping(value = "/getByKey", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    Employee getByKey(@RequestParam Integer key) {
        Employee result = eRepository.findByKey(key);
        if (result == null) {
            result = new Employee();

        }
        return result;
        /*JSONSerializer serialize = new JSONSerializer();
         String json = serialize
         .exclude("*.class")
         .include("educations",
         "hobbies",
         "experiences",
         "siblings",
         "children",
         "languages",
         "trainings",
         "references",
         "educations.educationLevel",
         "siblings.title",
         "children.title",
         "references.title",
         "languages.language",
         "title",
         "position",
         "branch",
         "department",
         "address.province",
         "address.amphur")
         .transform(new DateTransformer("yyyy-MM-dd'T'HH:mm:ssZ"), Date.class)
         .serialize(result);
         response.getOutputStream().print(json);*/
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody
    Employee save(@RequestBody Employee entity) {

        //entity.setBirthDate(null);
        if (entity.getTitle() != null && (entity.getTitle().getId() == null || entity.getTitle().getId() == 0)) {
            entity.setTitle(null);
        }
        if (entity.getPosition() != null && (entity.getPosition().getId() == null || entity.getPosition().getId() == 0)) {
            entity.setPosition(null);
        }
        if (entity.getDepartment() != null && (entity.getDepartment().getId() == null || entity.getDepartment().getId() == 0)) {
            entity.setDepartment(null);
        }
        if (entity.getBranch() != null && (entity.getBranch().getId() == null || entity.getBranch().getId() == 0)) {
            entity.setBranch(null);

        }
        if (entity.getAddress() != null) {
            if (entity.getAddress().getProvince() != null && (entity.getAddress().getProvince().getId() == null || entity.getAddress().getProvince().getId() == 0)) {
                entity.getAddress().setProvince(null);
            }
            if (entity.getAddress().getAmphur() != null && (entity.getAddress().getAmphur().getId() == null || entity.getAddress().getAmphur().getId() == 0)) {
                entity.getAddress().setAmphur(null);
            }
        }
        System.out.println(entity.getEducations().size());
        for (Education education : entity.getEducations()) {
            if (education.getEducationLevel() != null && (education.getEducationLevel().getId() == null || education.getEducationLevel().getId() == 0)) {
                education.setEducationLevel(null);
            }
        }
        for (Sibling sibling : entity.getSiblings()) {
            if (sibling.getTitle() != null && (sibling.getTitle().getId() == null || sibling.getTitle().getId() == 0)) {
                sibling.setTitle(null);
            }
        }
        for (Children child : entity.getChildren()) {
            if (child.getTitle() != null && (child.getTitle().getId() == null || child.getTitle().getId() == 0)) {
                child.setTitle(null);
            }
        }
        for (Reference reference : entity.getReferences()) {
            if (reference.getTitle() != null && (reference.getTitle().getId() == null || reference.getTitle().getId() == 0)) {
                reference.setTitle(null);
            }
        }
        for (EmployeeLanguage language : entity.getLanguages()) {
            if (language.getLanguage() != null && (language.getLanguage().getId() == null || language.getLanguage().getId() == 0)) {
                language.setLanguage(null);
            }
        }

       /* List<Hobby> hobbies = new ArrayList<Hobby>();
       
        for (Hobby hobby : entity.getHobbies()) {
            if (hobby.getSelected()) {

                hobbies.add(hobby);
            }
        }
         System.out.println(hobbies.size());
        entity.setHobbies(hobbies);*/

        Employee result = eRepository.save(entity);
        return result;
        /*  JSONSerializer serialize = new JSONSerializer();
         String json = serialize
         .exclude("*.class")
         .include("educations",
         "hobbies",
         "experiences",
         "siblings",
         "children",
         "languages",
         "trainings",
         "references",
         "educations.educationLevel",
         "siblings.title",
         "children.title",
         "references.title",
         "languages.language",
         "title",
         "position",
         "branch",
         "department",
         "address.province",
         "address.amphur")
         .transform(new DateTransformer("yyyy-MM-dd'T'HH:mm:ssZ"), Date.class)
         .serialize(result);
         response.getOutputStream().print(json);*/
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody
    Map search(@RequestBody EmployeeQuery query) {
        Map result = eRepository.findByQuery(query);
        return result;
        /*JSONSerializer serialize = new JSONSerializer();
         String json = serialize
         .exclude(
         "*.class",
         "*.version",
         "*.createBy",
         "*.createDate",
         "*.lastupdateBy",
         "*.lastupdateDate",
         "list.educations",
         "list.experiences",
         "list.siblings",
         "list.hobbies",
         "list.children",
         "list.trainings",
         "list.languages",
         "list.references")
         .include("pages")
         .transform(new DateTransformer("dd/MM/yyyy"), Date.class)
         .serialize(result);
         response.getOutputStream().print(json);*/

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Transactional
    public void delete(@RequestBody Employee entity, HttpServletResponse response) throws IOException {
        eRepository.remove(entity.getId());
        response.getOutputStream().print("success");
    }

}
