package com.spring.boot.mong.angular.app.controller;

import com.spring.boot.mong.angular.app.entity.Employee;
import com.spring.boot.mong.angular.app.repository.IEmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class EmployeeRestController {


    @Autowired
    private IEmployeeRepository employeeRepository;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void save(@Valid @RequestBody Employee employee) {
    	employeeRepository.save(employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Employee retrieveEmployee(@PathVariable("id") String id) {
    	Employee employee = (Employee)employeeRepository.findOne(id);
        employee.setName("Employee Details are  : "); //TODO : change the hard coded value 
        return employee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Map<String, Object> deleteEmployee(String id) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
        employeeRepository.delete(id);
        dataMap.put("message", "employee deleted successfully");
		dataMap.put("status", "1");
	    return dataMap;
    }
    
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Map<String, Object> editEmployee(Employee employee) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
        employeeRepository.delete(employee);
        dataMap.put("message", "employee updated successfully");
		dataMap.put("status", "1");
	    return dataMap;
    }
    
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Map<String, Object> loadListOfEmployees(String fileName) {
    	List<Employee> employeeList = new ArrayList<Employee>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
        employeeRepository.save(employeeList);
        dataMap.put("message", "employees list uploaded successfully");
		dataMap.put("status", "1");
	    return dataMap;
    }
    
    
    
    
    
}
