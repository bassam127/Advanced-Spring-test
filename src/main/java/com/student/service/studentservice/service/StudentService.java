package com.student.service.studentservice.service;

import com.student.service.studentservice.model.Student;
import com.student.service.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long id) {
       return studentRepository.findById(id).orElse(null);


    }
}
