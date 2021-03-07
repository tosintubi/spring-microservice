package org.tommot.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tommot.userservice.VO.Department;
import org.tommot.userservice.VO.ResponseTemplateVO;
import org.tommot.userservice.model.User;
import org.tommot.userservice.repository.UserRepository;

@Service
@Slf4j
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
        log.info("Implementing Service: UserService.getUserWithDepartment");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findUserById(userId);

        Department department = restTemplate.getForObject(
                "http://localhost:9001/api/v1/departments/"+user.getDepartmentId() , Department.class);

        responseTemplateVO.setDepartment(department);
        responseTemplateVO.setUser(user);

        return  responseTemplateVO;

    }
}
