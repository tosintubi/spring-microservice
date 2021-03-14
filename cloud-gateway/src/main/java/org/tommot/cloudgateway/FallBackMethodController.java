package org.tommot.cloudgateway;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBack(){
        return "User service is taking longer than expected. Please try again later";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBack(){
        return "Department service is taking longer than expected. Please try again later";
    }

    @GetMapping("/projectServiceFallBack")
    public String projectServiceFallBack(){
        return "Project service is taking longer than expected. Please try again later";
    }
}
