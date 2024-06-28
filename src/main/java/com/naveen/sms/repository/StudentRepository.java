package com.naveen.sms.repository;

import com.naveen.sms.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    List<Student> findByDepartment(String department);
    List<Student> findByBranch(String branch);
    List<Student> findByStatus(String status);
    List<Student> findByYear(Integer year);
    List<Student> findBySemester(Integer semester);
    List<Student> findByDepartmentAndBranch(String department, String branch);
    List<Student> findByDepartmentAndYear(String department, Integer year);
    List<Student> findByDepartmentAndSemester(String department, Integer semester);
    List<Student> findByBranchAndYear(String branch, Integer year);
    List<Student> findByBranchAndSemester(String branch, Integer semester);
    List<Student> findByYearAndSemester(Integer year, Integer semester);
    List<Student> findByDepartmentAndBranchAndYear(String department, String branch, Integer year);
    List<Student> findByDepartmentAndBranchAndSemester(String department, String branch, Integer semester);
    List<Student> findByDepartmentAndYearAndSemester(String department, Integer year, Integer semester);
    List<Student> findByBranchAndYearAndSemester(String branch, Integer year, Integer semester);
    List<Student> findByDepartmentAndBranchAndYearAndSemester(String department, String branch, Integer year, Integer semester);
    List<Student> findByOrderByCreatedAt();
    List<Student> findByOrderByUpdatedAtDesc();
}
