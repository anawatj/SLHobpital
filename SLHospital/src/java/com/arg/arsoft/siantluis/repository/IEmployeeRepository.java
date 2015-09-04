/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.repository;


import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.arg.arsoft.siantluis.domains.employee.EmployeeQuery;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wongskont
 */
public interface IEmployeeRepository extends Repository<Employee,Integer> {

    @Override
    public List<Employee> findAll();

    @Override
    public Employee findByKey(Integer key);

    @Override
    public void remove(Integer key);

    @Override
    public Employee save(Employee entity);
    
    public Map findByQuery(EmployeeQuery query);
    
    
    
   
}
