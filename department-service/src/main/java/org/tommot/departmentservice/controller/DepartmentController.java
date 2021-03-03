package org.tommot.departmentservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tommot.departmentservice.model.Department;
import org.tommot.departmentservice.service.DepartmentService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/hello")
    public String hello() {
        log.info("Implementing: hello()");
        return "hello world";
    }


    @PostMapping("/add")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        log.info("Implementing: saveDepartment");
        Department newDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Department>> getAllDepartments(){
        log.info("Implementing: getAllDepartments");
        List<Department> departments = departmentService.findAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById( @PathVariable Long id) {
        log.info("Implementing: getAllDepartments");
        Department department = departmentService.findDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
