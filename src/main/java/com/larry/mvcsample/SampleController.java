package com.larry.mvcsample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SampleController {

    @GetMapping("/test")
    @RoleMapping("ROLE_USER")
    public String handleForUser() {
        return "hello user";
    }

    @GetMapping("/test")
    @RoleMapping("ROLE_ADMIN")
    public String handleForAdmin() {
        return "hello admin";
    }

    @GetMapping("/allpass")
    @RoleMapping(value = {"ROLE_ADMIN", "ROLE_USER"})
    public String handleForAdmin(HttpServletRequest request) {
        return "i am " + request.getHeader("role");
    }

}
