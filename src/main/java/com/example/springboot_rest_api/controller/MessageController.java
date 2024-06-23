package com.example.springboot_rest_api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class MessageController {

    //http get request
    //http://localhost:8080/the-end

    @GetMapping("/the-end")
    public String message() {
        return "This is the end...";
    }
}
