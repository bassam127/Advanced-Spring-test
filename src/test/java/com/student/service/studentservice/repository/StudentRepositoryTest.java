package com.student.service.studentservice.repository;
import com.student.service.studentservice.model.Student;
import com.student.service.studentservice.repository.StudentRepository;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void getStudentByName(){
        Student savedStudent = testEntityManager.persistFlushFind(new Student(null , "Mark"));

        Student student = studentRepository.getStudentByName("Mark");

        BDDAssertions.then(student.getId()).isNotNull();
        BDDAssertions.then(student.getName()).isEqualTo(savedStudent.getName());


    }

    @Test
    public void getAvgGradeForActiveStudent(){
        //given
        Student mark = Student.builder().name("Mark").active(true).grade(100).build();
        Student emma =Student.builder().name("Emma").active(false).grade(50).build();
        Student nuha =Student.builder().name("Nuha").active(true).grade(80).build();

        Arrays.asList(mark,emma,nuha).forEach(testEntityManager::persistFlushFind);

        //when
        Double avgGrade = studentRepository.getAvgGradeForActiveStudents();

        //then
        BDDAssertions.then(avgGrade).isEqualTo(90);
    }


}
