package com.naveen.sms.dao;

import com.naveen.sms.dto.Student;
import com.naveen.sms.exception.StudentNotFoundException;
import com.naveen.sms.repository.StudentRepository;
import com.naveen.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentById(Integer id, Student student) throws StudentNotFoundException {
        studentRepository.findById(id)
                .orElseThrow(()->
                        new StudentNotFoundException("Student with ID " + id + " not found to update"));
        student.setId(id);
        return studentRepository.save(student);
    }


    @Override
    public void deleteStudentById(Integer id) throws StudentNotFoundException {
        studentRepository.findById(id)
                .orElseThrow(()->
                        new StudentNotFoundException("Student with ID " + id + " not found to delete"));
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Integer id) throws StudentNotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(()->
                        new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    @Override
    public List<Student> getStudentsByBranch(String branch) {
        return studentRepository.findByBranch(branch);
    }

    @Override
    public List<Student> getStudentsByStatus(String status) {
        return studentRepository.findByStatus(status);
    }

    @Override
    public List<Student> getStudentsByYear(Integer year) {
        return studentRepository.findByYear(year);
    }

    @Override
    public List<Student> getStudentsBySemester(Integer semester) {
        return studentRepository.findBySemester(semester);
    }

    @Override
    public List<Student> getStudentsByDepartmentAndBranch(String department, String branch) {
        return studentRepository.findByDepartmentAndBranch(department, branch);
    }

    @Override
    public List<Student> getStudentsByDepartmentAndYear(String department, Integer year) {
        return studentRepository.findByDepartmentAndYear(department, year);
    }

    @Override
    public List<Student> getStudentsByDepartmentAndSemester(String department, Integer semester) {
        return studentRepository.findByDepartmentAndSemester(department, semester);
    }

    @Override
    public List<Student> getStudentsByBranchAndYear(String branch, Integer year) {
        return studentRepository.findByBranchAndYear(branch, year);
    }

    @Override
    public List<Student> getStudentsByBranchAndSemester(String branch, Integer semester) {
        return studentRepository.findByBranchAndSemester(branch, semester);
    }

    @Override
    public List<Student> getStudentsByYearAndSemester(Integer year, Integer semester) {
        return studentRepository.findByYearAndSemester(year, semester);
    }

    @Override
    public List<Student> getStudentsByDepartmentAndBranchAndYear(
            String department,
            String branch,
            Integer year) {
        return studentRepository.findByDepartmentAndBranchAndYear(department, branch, year);
    }

    @Override
    public List<Student> getStudentsByDepartmentAndBranchAndSemester(
            String department,
            String branch,
            Integer semester) {
        return studentRepository.findByDepartmentAndBranchAndSemester(department, branch, semester);
    }

    @Override
    public List<Student> getStudentsByDepartmentAndYearAndSemester(
            String department,
            Integer year,
            Integer semester) {
        return studentRepository.findByDepartmentAndYearAndSemester(department, year, semester);
    }

    @Override
    public List<Student> getStudentsByBranchAndYearAndSemester(
            String branch,
            Integer year,
            Integer semester) {
        return studentRepository.findByBranchAndYearAndSemester(branch, year, semester);
    }

    @Override
    public List<Student> getStudentsByDepartmentAndBranchAndYearAndSemester(
            String department,
            String branch,
            Integer year,
            Integer semester) {
        return studentRepository.findByDepartmentAndBranchAndYearAndSemester(department, branch, year, semester);
    }

    @Override
    public List<Student> getStudentsByOrderByCreatedAt() {
        return studentRepository.findByOrderByCreatedAt();
    }

    @Override
    public List<Student> getStudentsByOrderByUpdatedAt() {
        return studentRepository.findByOrderByUpdatedAt();
    }
}
