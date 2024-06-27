package com.naveen.sms;

import com.naveen.sms.exception.ErrorInfo;
import com.naveen.sms.exception.StudentNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class
GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorInfo handleStudentNotFoundException(
            StudentNotFoundException exception,
            HttpServletRequest request) {
        return new ErrorInfo(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getRequestURI(),
                "Student not found"
        );
    }
}
