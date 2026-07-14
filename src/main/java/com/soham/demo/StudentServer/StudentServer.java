package com.soham.demo.StudentServer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {

    //1. Store the Student
    @PostMapping("/create")
    public String storeStudent(){
        return """
                id: 1
                name: Soham
                Department: CSE
                age: 22
                """;
    }
    //2
}
