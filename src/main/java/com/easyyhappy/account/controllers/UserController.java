package com.easyyhappy.account.controllers;

import com.easyyhappy.account.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/hello/avan
    @GetMapping("/user/{name}")
    public User getUserByVariable(@PathVariable("name") String name) {
        return new User(counter.incrementAndGet(), name);
    }

    // http://localhost:8080/hello?name=layouwen
    @GetMapping("/user")
    public User getUserByParam(@RequestParam("name") String name) {
        return new User(counter.incrementAndGet(), String.format("Hello, %s!", name));
    }
}
