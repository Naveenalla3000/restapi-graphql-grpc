package com.naveen.sms.controller.GraphQlController;

import com.naveen.sms.dto.Student;
import com.naveen.sms.exception.StudentNotFoundException;
import com.naveen.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller()
public class StudentControllerGql {

    @Autowired
    StudentService studentService;

    @QueryMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @QueryMapping
    public Student getStudentById(@Valid @Argument Integer id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }

    @MutationMapping
    public Student addStudent(@Valid Student student) {
        return studentService.addStudent(student);
    }


}
