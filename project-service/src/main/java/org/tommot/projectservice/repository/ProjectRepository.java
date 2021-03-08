package org.tommot.projectservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tommot.projectservice.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
