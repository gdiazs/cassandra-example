
package com.github.gdiazs.example.controllers;

import com.github.gdiazs.example.dao.EmployeeDao;
import com.github.gdiazs.example.entities.Employee;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable{
    
    
    private final Logger LOG = Logger.getLogger(IndexController.class.getName());
    
    private List<Employee> employees;
    
    @Inject
    private EmployeeDao employeeDao;
    
    @PostConstruct
    public void init(){
        this.employees = this.employeeDao.all();
    }

    public List<Employee> getEmployees() {
        LOG.info(String.format("employees size:%s", this.employees.size()));
        return this.employees;
    }
    
    
    
}
