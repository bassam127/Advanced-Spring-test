package com.student.service.studentservice.service;

import com.student.service.studentservice.model.Student;
import com.student.service.studentservice.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    public void getStudentById(){
        Student savedStudent = studentRepository.save(new Student(null, "Bassam"));
        Student student = studentService.getStudentById(savedStudent.getId());

        BDDAssertions.then(student.getId()).isNotNull();
        BDDAssertions.then(student.getName()).isEqualTo("Bassam");

    }
}
