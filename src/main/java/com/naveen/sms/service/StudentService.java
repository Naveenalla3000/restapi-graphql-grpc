package com.naveen.sms.service;

import com.naveen.sms.dto.Student;
import com.naveen.sms.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student updateStudentById(Integer id, Student student) throws StudentNotFoundException;
    void deleteStudentById(Integer id) throws StudentNotFoundException;
    Student getStudentById(Integer id) throws StudentNotFoundException;
    List<Student> getAllStudents();
    List<Student> getStudentsByDepartment(String department);
    List<Student> getStudentsByBranch(String branch);
    List<Student> getStudentsByStatus(String status);
    List<Student> getStudentsByYear(Integer year);
    List<Student> getStudentsBySemester(Integer semester);
    List<Student> getStudentsByDepartmentAndBranch(String department, String branch);
    List<Student> getStudentsByDepartmentAndYear(String department, Integer year);
    List<Student> getStudentsByDepartmentAndSemester(String department, Integer semester);
    List<Student> getStudentsByBranchAndYear(String branch, Integer year);
    List<Student> getStudentsByBranchAndSemester(String branch, Integer semester);
    List<Student> getStudentsByYearAndSemester(Integer year, Integer semester);
    List<Student> getStudentsByDepartmentAndBranchAndYear(String department, String branch, Integer year);
    List<Student> getStudentsByDepartmentAndBranchAndSemester(String department, String branch, Integer semester);
    List<Student> getStudentsByDepartmentAndYearAndSemester(String department, Integer year, Integer semester);
    List<Student> getStudentsByBranchAndYearAndSemester(String branch, Integer year, Integer semester);
    List<Student> getStudentsByDepartmentAndBranchAndYearAndSemester(String department, String branch, Integer year, Integer semester);
    List<Student> getStudentsByOrderByCreatedAt();
    List<Student> getStudentsByOrderByUpdatedAtDesc();
}
