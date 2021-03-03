package org.tommot.departmentservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tommot.departmentservice.model.Department;
import org.tommot.departmentservice.service.DepartmentService;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }


    @PostMapping("/add")
    public ResponseEntity<Department> saveDepartment(Department department){
        Department newDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }
}
