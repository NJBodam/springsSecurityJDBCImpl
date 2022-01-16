package com.example.springsecurityjdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>This is the admin resource</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>This is basic user resource</h1>");
    }
}
