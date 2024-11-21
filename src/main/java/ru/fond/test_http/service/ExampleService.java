package ru.fond.test_http.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.fond.test_http.model.User;
import ru.fond.test_http.repository.ExampleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    public void saveUser(User user) {
        exampleRepository.save(user);
    }

    public String getHelloWorld(String name) {
        return "Hello World " + name;
    }

    public User getUser(String name) {
        Optional<User> userOptional = exampleRepository.findById(name);
        if(userOptional.isEmpty()) {
            return null;
        }
        return userOptional.get();
    }

    public List<User> getUsers() {
        return (List<User>) exampleRepository.findAll();
    }
}
