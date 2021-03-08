package org.tommot.projectservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommot.projectservice.exception.ProjectNotFoundException;
import org.tommot.projectservice.model.Project;
import org.tommot.projectservice.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        log.info("Implementing Service: ProjectService.saveProject");
        return projectRepository.save(project);
    }

    public List<Project> findAllProjects() {
        log.info("Implementing Service: ProjectService.saveProject");
        return projectRepository.findAll();
    }

    public Project findProjectWithId(Long id) {
        log.info("Implementing Service: ProjectService.saveProject");
        return  projectRepository.findById(id).orElseThrow(()->
                new ProjectNotFoundException("Project with id: "+ " could not be found"));
    }
}
