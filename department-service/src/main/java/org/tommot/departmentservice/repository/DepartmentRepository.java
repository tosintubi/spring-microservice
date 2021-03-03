package org.tommot.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tommot.departmentservice.model.Department;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long> {

}
