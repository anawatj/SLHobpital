/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.employee;


import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.master.Address;
import com.arg.arsoft.siantluis.domains.master.Branch;
import com.arg.arsoft.siantluis.domains.master.Department;
import com.arg.arsoft.siantluis.domains.master.Hobby;
import com.arg.arsoft.siantluis.domains.master.Position;
import com.arg.arsoft.siantluis.domains.master.Title;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;



/**
 *
 * @author wongskont
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee extends AbstractDomain<Integer> {
    public Employee()
    {
        this.educations = new HashSet<Education>();
        this.hobbies = new ArrayList<Hobby>();
        this.experiences = new HashSet<Experience>();
        this.siblings = new HashSet<Sibling>();
        this.children = new HashSet<Children>();
        this.languages = new HashSet<EmployeeLanguage>();
        this.trainings = new HashSet<Training>();
        this.references = new HashSet<Reference>();
        
    }
    
    private String code;
    private Title title;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Double salary;
    private Position position;
    private Set<Education> educations;
    private List<Hobby> hobbies;
    private Set<Experience> experiences;
    private Address address;
    private String fatherName;
    private String fatherOccupation;
    private String fatherCompany;
    private String fatherTel;
    private String fatherAddress;
    private String motherName;
    private String motherOccupation;
    private String motherCompany;
    private String motherTel;
    private String motherAddress;
    private MaritalStatus marital;
    private String supouseName;
    private String supouseOccupation;
    private String suposeCompany;
    private String suposeTel;
    private String suposeAddress;
    private String contactName;
    private String conatctAddress;
    private String contactTel;
    private String contactRelation;
    private Set<Sibling> siblings;
    private Set<Reference> references;
    private Set<EmployeeLanguage> languages;
    private Set<Children> children;
    private Set<Training> trainings;
    private Department department;
    private Branch branch;
    

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
     * @return the title
     */
    public Title getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the salary
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * @return the educations
     */
    public Set<Education> getEducations() {
        return educations;
    }

    /**
     * @param educations the educations to set
     */
    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    /**
     * @return the hobbies
     */
    public List<Hobby> getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return the experiences
     */
    public Set<Experience> getExperiences() {
        return experiences;
    }

    /**
     * @param experiences the experiences to set
     */
    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return the fatherOccupation
     */
    public String getFatherOccupation() {
        return fatherOccupation;
    }

    /**
     * @param fatherOccupation the fatherOccupation to set
     */
    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    /**
     * @return the fatherCompany
     */
    public String getFatherCompany() {
        return fatherCompany;
    }

    /**
     * @param fatherCompany the fatherCompany to set
     */
    public void setFatherCompany(String fatherCompany) {
        this.fatherCompany = fatherCompany;
    }

    /**
     * @return the fatherTel
     */
    public String getFatherTel() {
        return fatherTel;
    }

    /**
     * @param fatherTel the fatherTel to set
     */
    public void setFatherTel(String fatherTel) {
        this.fatherTel = fatherTel;
    }

    /**
     * @return the fatherAddress
     */
    public String getFatherAddress() {
        return fatherAddress;
    }

    /**
     * @param fatherAddress the fatherAddress to set
     */
    public void setFatherAddress(String fatherAddress) {
        this.fatherAddress = fatherAddress;
    }

    /**
     * @return the motherName
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName the motherName to set
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    /**
     * @return the motherOccupation
     */
    public String getMotherOccupation() {
        return motherOccupation;
    }

    /**
     * @param motherOccupation the motherOccupation to set
     */
    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    /**
     * @return the motherCompany
     */
    public String getMotherCompany() {
        return motherCompany;
    }

    /**
     * @param motherCompany the motherCompany to set
     */
    public void setMotherCompany(String motherCompany) {
        this.motherCompany = motherCompany;
    }

    /**
     * @return the motherTel
     */
    public String getMotherTel() {
        return motherTel;
    }

    /**
     * @param motherTel the motherTel to set
     */
    public void setMotherTel(String motherTel) {
        this.motherTel = motherTel;
    }

    /**
     * @return the motherAddress
     */
    public String getMotherAddress() {
        return motherAddress;
    }

    /**
     * @param motherAddress the motherAddress to set
     */
    public void setMotherAddress(String motherAddress) {
        this.motherAddress = motherAddress;
    }

    /**
     * @return the marital
     */
    public MaritalStatus getMarital() {
        return marital;
    }

    /**
     * @param marital the marital to set
     */
    public void setMarital(MaritalStatus marital) {
        this.marital = marital;
    }

    /**
     * @return the supouseName
     */
    public String getSupouseName() {
        return supouseName;
    }

    /**
     * @param supouseName the supouseName to set
     */
    public void setSupouseName(String supouseName) {
        this.supouseName = supouseName;
    }

    /**
     * @return the supouseOccupation
     */
    public String getSupouseOccupation() {
        return supouseOccupation;
    }

    /**
     * @param supouseOccupation the supouseOccupation to set
     */
    public void setSupouseOccupation(String supouseOccupation) {
        this.supouseOccupation = supouseOccupation;
    }

    /**
     * @return the suposeCompany
     */
    public String getSuposeCompany() {
        return suposeCompany;
    }

    /**
     * @param suposeCompany the suposeCompany to set
     */
    public void setSuposeCompany(String suposeCompany) {
        this.suposeCompany = suposeCompany;
    }

    /**
     * @return the suposeTel
     */
    public String getSuposeTel() {
        return suposeTel;
    }

    /**
     * @param suposeTel the suposeTel to set
     */
    public void setSuposeTel(String suposeTel) {
        this.suposeTel = suposeTel;
    }

    /**
     * @return the suposeAddress
     */
    public String getSuposeAddress() {
        return suposeAddress;
    }

    /**
     * @param suposeAddress the suposeAddress to set
     */
    public void setSuposeAddress(String suposeAddress) {
        this.suposeAddress = suposeAddress;
    }

    /**
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName the contactName to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return the conatctAddress
     */
    public String getConatctAddress() {
        return conatctAddress;
    }

    /**
     * @param conatctAddress the conatctAddress to set
     */
    public void setConatctAddress(String conatctAddress) {
        this.conatctAddress = conatctAddress;
    }

    /**
     * @return the contactTel
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * @param contactTel the contactTel to set
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    /**
     * @return the contactRelation
     */
    public String getContactRelation() {
        return contactRelation;
    }

    /**
     * @param contactRelation the contactRelation to set
     */
    public void setContactRelation(String contactRelation) {
        this.contactRelation = contactRelation;
    }

    /**
     * @return the siblings
     */
    public Set<Sibling> getSiblings() {
        return siblings;
    }

    /**
     * @param siblings the siblings to set
     */
    public void setSiblings(Set<Sibling> siblings) {
        this.siblings = siblings;
    }

    /**
     * @return the references
     */
    public Set<Reference> getReferences() {
        return references;
    }

    /**
     * @param references the references to set
     */
    public void setReferences(Set<Reference> references) {
        this.references = references;
    }

    /**
     * @return the languages
     */
    public Set<EmployeeLanguage> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(Set<EmployeeLanguage> languages) {
        this.languages = languages;
    }

    /**
     * @return the children
     */
    public Set<Children> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Set<Children> children) {
        this.children = children;
    }

    /**
     * @return the trainings
     */
    public Set<Training> getTrainings() {
        return trainings;
    }

    /**
     * @param trainings the trainings to set
     */
    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @return the branch
     */
    public Branch getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    
    
}
