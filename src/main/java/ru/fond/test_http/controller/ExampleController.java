package ru.fond.test_http.controller;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.fond.test_http.model.User;
import ru.fond.test_http.service.ExampleService;

@Controller
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    @GetMapping("/")
    public ResponseEntity<Object> getUser(@RequestParam String name) {
        User user = exampleService.getUser(name);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/")
    public ResponseEntity<Object> postUser(@RequestBody User user) {
        exampleService.saveUser(user);
        user.setPassword("*");
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getHelloWorld2(@PathVariable String name) {
        return ResponseEntity.ok(exampleService.getHelloWorld(name));
    }

    @GetMapping("/users")
    public  ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok(exampleService.getUsers());
    }
}
