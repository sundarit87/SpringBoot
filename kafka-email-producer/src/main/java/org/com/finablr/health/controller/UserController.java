package org.com.finablr.health.controller;


import org.com.finablr.health.entity.User;
import org.com.finablr.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/members")
    public ResponseEntity<Iterable<User>> getAll() {

        Iterable<User> all = userService.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/notify")
    @HystrixCommand(fallbackMethod = "fallback_notify", commandProperties = {
    	      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    	   })
    public ResponseEntity<User> notify(@RequestBody User input) {

        User result = userService.registerUser(input);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    private ResponseEntity<User> fallback_notify(User input) {

        User result = new User();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
