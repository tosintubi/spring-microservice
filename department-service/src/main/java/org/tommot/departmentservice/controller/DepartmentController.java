package org.tommot.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tommot.departmentservice.model.Department;
import org.tommot.departmentservice.service.DepartmentService;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public ResponseEntity<Department> saveDepartment(Department department){
        Department newDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }
}
