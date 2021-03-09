package org.tommot.departmentservice.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommot.departmentservice.exception.DepartmentNotFoundException;
import org.tommot.departmentservice.model.Department;
import org.tommot.departmentservice.repository.DepartmentRepository;

import java.util.List;

@Service
@NoArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()->
                new DepartmentNotFoundException("Department with id: "+ id+" could not be found"));
    }
}
