package com.student.service.studentservice.controller;

import com.student.service.studentservice.model.Student;
import com.student.service.studentservice.service.StudentService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;

    @Test
    public void getStudent_forSaveStudent() throws  Exception{

        BDDMockito.given(studentService.getStudentById(ArgumentMatchers.anyLong())).willReturn(
                Student.builder().id(1L).name("Mark").grade(10).build()
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/student/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(1l))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Mark"))
                .andExpect(MockMvcResultMatchers.jsonPath("grade").value(10));


    }
}
