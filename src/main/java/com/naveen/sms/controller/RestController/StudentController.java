package com.naveen.sms.controller.RestController;

import com.naveen.sms.dto.Student;
import com.naveen.sms.exception.StudentNotFoundException;
import com.naveen.sms.service.StudentService;
import com.naveen.sms.validation.Branch.ValidBranch;
import com.naveen.sms.validation.Department.ValidDepartment;
import com.naveen.sms.validation.status.ValidStatus;
import com.naveen.sms.validation.year.ValidYear;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student")
@CrossOrigin("*")
@Slf4j
@Validated
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test() {
        log.info("test method in Student Controller is working");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Student Controller is working");
    }

    @PostMapping(value = "/add")
    public Student addStudent(@Valid @RequestBody Student student) {
        log.info("Added student to database");
        return studentService.addStudent(student);
    }

    @PutMapping(value = "/update/{id}")
    public Student updateStudent(
            @Valid @PathVariable Integer id,
            @Valid @RequestBody Student student) throws StudentNotFoundException {
        log.info(student.toString());
        log.info("Updated student with id {}", id);
        return studentService.updateStudentById(id, student);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudentById(@Valid @PathVariable Integer id)
            throws StudentNotFoundException {
        log.info("Deleted student with id {}", id);
        studentService.deleteStudentById(id);
    }

    @GetMapping(value = "/get/{id}")
    public Student getStudentById(@Valid @PathVariable Integer id)
            throws StudentNotFoundException {
        log.info("Retrieve student by id {}", id);
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "/get/all")
    public List<Student> getAllStudents() {
        log.info("Retrieving all students");
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/getByDepartment")
    public List<Student> getStudentsByDepartment(
            @Valid @ValidDepartment @RequestParam("department") String department) {
        log.info("Retrieving all students with {} department", department);
        return studentService.getStudentsByDepartment(department);
    }

    @GetMapping(value = "/getByBranch")
    public List<Student> getStudentsByBranch(
            @Valid @ValidBranch @RequestParam("branch") String branch) {
        log.info("Retrieving all students with {} branch", branch);
        return studentService.getStudentsByBranch(branch);
    }

    @GetMapping(value = "/getByStatus")
    public List<Student> getStudentsByStatus(
            @Valid @ValidStatus @RequestParam("status") String status) {
        log.info("Retrieving all students with {} status", status);
        return studentService.getStudentsByStatus(status);
    }

    @GetMapping(value = "/getByYear")
    public List<Student> getStudentsByYear(
            @Valid @ValidYear @RequestParam("year") Integer year) {
        log.info("Retrieving all students with {} year", year);
        return studentService.getStudentsByYear(year);
    }

    @GetMapping(value = "/getBySemester")
    public List<Student> getStudentsBySemester(
            @RequestParam("semester") Integer semester) {
        log.info("Retrieving all students with {} semester", semester);
        return studentService.getStudentsBySemester(semester);
    }

    @GetMapping(value = "/getByDepartmentAndBranch")
    public List<Student> getStudentsByDepartmentAndBranch(
            @Valid @ValidDepartment @RequestParam("department") String department,
            @Valid @ValidBranch @RequestParam("branch") String branch) {
        log.info("Retrieving all students with {} department and {} branch", department, branch);
        return studentService.getStudentsByDepartmentAndBranch(department, branch);
    }

    @GetMapping(value = "/getByDepartmentAndYear")
    public List<Student> getStudentsByDepartmentAndYear(
            @Valid @ValidDepartment @RequestParam("department") String department,
            @Valid @ValidYear @RequestParam("year") Integer year) {
        log.info("Retrieving all students with {} department and {} year", department, year);
        return studentService.getStudentsByDepartmentAndYear(department, year);
    }

    @GetMapping(value = "/getByDepartmentAndSemester")
    public List<Student> getStudentsByDepartmentAndSemester(
            @Valid @ValidDepartment @RequestParam("department") String department,
            @Valid @RequestParam("semester") Integer semester) {
        log.info("Retrieving all students with {} department and {} semester", department, semester);
        return studentService.getStudentsByDepartmentAndSemester(department, semester);
    }

    @GetMapping(value = "/getByBranchAndYear")
    public List<Student> getStudentsByBranchAndYear(
            @Valid @ValidBranch @RequestParam("branch") String branch,
            @Valid @ValidYear @RequestParam("year") Integer year) {
        log.info("Retrieving all students with {} branch and {} year", branch, year);
        return studentService.getStudentsByBranchAndYear(branch, year);
    }

    @GetMapping(value = "/getByBranchAndSemester")
    public List<Student> getStudentsByBranchAndSemester(
            @Valid @ValidBranch @RequestParam("branch") String branch,
            @Valid @RequestParam("semester") Integer semester) {
        log.info("Retrieving all students with {} branch and {} semester", branch, semester);
        return studentService.getStudentsByBranchAndSemester(branch, semester);
    }

    @GetMapping(value = "/getByYearAndSemester")
    public List<Student> getStudentsByYearAndSemester(
            @Valid @ValidYear @RequestParam("year") Integer year,
            @Valid @RequestParam("semester") Integer semester) {
        log.info("Retrieving all students with {} year and {} semester", year, semester);
        return studentService.getStudentsByYearAndSemester(year, semester);
    }

    @GetMapping(value = "/getByDepartmentAndBranchAndYear")
    public List<Student> getStudentsByDepartmentAndBranchAndYear(
            @Valid @ValidDepartment @RequestParam("department") String department,
            @Valid @ValidBranch @RequestParam("branch") String branch,
            @Valid @ValidYear @RequestParam("year") Integer year) {
        System.out.println("Department: " + department + " Branch: " + branch + " Year: " + year);
        log.info("Retrieving all students with {} department, {} branch, and {} year", department, branch, year);
        return studentService.getStudentsByDepartmentAndBranchAndYear(department, branch, year);
    }

    @GetMapping(value = "/getByDepartmentAndBranchAndSemester")
    public List<Student> getStudentsByDepartmentAndBranchAndSemester(
            @Valid @ValidDepartment @RequestParam("department") String department,
            @Valid @ValidBranch @RequestParam("branch") String branch,
            @RequestParam("semester") Integer semester) {
        log.info("Retrieving all students with {} department, {} branch, and {} semester", department, branch, semester);
        return studentService.getStudentsByDepartmentAndBranchAndSemester(department, branch, semester);
    }

    @GetMapping(value = "/getByDepartmentAndYearAndSemester")
    public List<Student> getStudentsByDepartmentAndYearAndSemester(
            @Valid @ValidDepartment @RequestParam("department") String department,
            @Valid @ValidYear @RequestParam("year") Integer year,
            @Valid @RequestParam("semester") Integer semester) {
        log.info("Retrieving all students with {} department, {} year, and {} semester", department, year, semester);
        return studentService.getStudentsByDepartmentAndYearAndSemester(department, year, semester);
    }

    @GetMapping(value = "/getByBranchAndYearAndSemester")
    public List<Student> getStudentsByBranchAndYearAndSemester(
            @Valid @ValidBranch @RequestParam("branch") String branch,
            @Valid @ValidYear @RequestParam("year") Integer year,
            @Valid @RequestParam("semester") Integer semester) {
        log.info("Retrieving all students with {} branch, {} year, and {} semester", branch, year, semester);
        return studentService.getStudentsByBranchAndYearAndSemester(branch, year, semester);
    }

    @GetMapping(value = "/getByDepartmentAndBranchAndYearAndSemester")
    public List<Student> getStudentsByDepartmentAndBranchAndYearAndSemester(
            @RequestParam("department") String department,
            @RequestParam("branch") String branch,
            @RequestParam("year") Integer year,
            @RequestParam("semester") Integer semester) {
        log.info("Retrieving all students with {} department, {} branch, {} year, and {} semester", department, branch, year, semester);
        return studentService.getStudentsByDepartmentAndBranchAndYearAndSemester(department, branch, year, semester);
    }

    @GetMapping(value = "/getOrderByCreatedAt")
    public List<Student> getStudentsByOrderByCreatedAt() {
        return studentService.getStudentsByOrderByCreatedAt();
    }

    @GetMapping(value = "/getOrderByUpdatedAtDesc")
    public List<Student> getStudentsByOrderByUpdatedAtDesc() {
        return studentService.getStudentsByOrderByUpdatedAtDesc();
    }
}
