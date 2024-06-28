package com.naveen.sms.controller.GraphQlController;

import com.naveen.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller()
public class StudentControllerGql {
    @Autowired
    StudentService studentService;
}
