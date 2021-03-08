package org.tommot.projectservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tommot.projectservice.model.Project;
import org.tommot.projectservice.service.ProjectService;
import   org.tommot.projectservice.model.Project;

@RestController
@Slf4j
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add/")
    public ResponseEntity<Project> saveProject(@RequestBody  Project project){
        log.info("Implementing: ProjectController.saveProject");
        Project newProject =  projectService.saveProject(project);
        return  new ResponseEntity<>(newProject, HttpStatus.CREATED);

    }

}
