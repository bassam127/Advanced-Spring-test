package com.student.service.studentservice.controller;


import com.student.service.studentservice.model.Student;
import com.student.service.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable long id){
        return  studentService.getStudentById(id);
    }


}
