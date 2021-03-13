package org.tommot.userservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tommot.userservice.VO.Department;
import org.tommot.userservice.VO.Project;
import org.tommot.userservice.VO.ResponseTemplateVO;
import org.tommot.userservice.model.User;
import org.tommot.userservice.repository.UserRepository;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Implementing Service: UserService.saveUser");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Service: UserService.getUserWithDepartment");

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findUserById(userId);

        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/api/v1/departments/"+user.getDepartmentId() , Department.class);

        Project project = restTemplate.getForObject("http://PROJECT-SERVICE/api/v1/projects/"+user.getProjectId(), Project.class);

        responseTemplateVO.setDepartment(department);
        responseTemplateVO.setUser(user);

        responseTemplateVO.setProject(project);
        return  responseTemplateVO;

    }
}
