package org.tommot.projectservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tommot.projectservice.model.Project;
import org.tommot.projectservice.service.ProjectService;


import java.util.List;

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

    @GetMapping({"/all","/"})
    public ResponseEntity<List<Project>> getProjects(){
        log.info("Implementing: ProjectController.getProjects");
        List<Project> projectList = projectService.findAllProjects();
        return  new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectWithId( @PathVariable("id") Long id){
        log.info("Implementing: ProjectController.getProjectWithId");
        Project project = projectService.findProjectWithId(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
