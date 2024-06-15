package dev.davletshin.gateway.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello admin";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Hello user";
    }

    @GetMapping("/test")
    public String getTest() {
        return "Test";
    }
}
