package com.naveen.sms;

import com.naveen.sms.controller.RestController.StudentController;
import com.naveen.sms.dto.Student;
import com.naveen.sms.exception.StudentNotFoundException;
import com.naveen.sms.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerTest {

	@Mock
	private StudentService studentService;

	@InjectMocks
	private StudentController studentController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddStudent() {
		Student student = new Student(); // Create a sample student
		when(studentService.addStudent(any(Student.class))).thenReturn(student);

		Student result = studentController.addStudent(student);

		assertNotNull(result);
		verify(studentService, times(1)).addStudent(student);
	}

	@Test
	void testGetStudentById() throws StudentNotFoundException {
		Integer id = 1;
		Student student = new Student(); // Create a sample student
		when(studentService.getStudentById(id)).thenReturn(student);

		Student result = studentController.getStudentById(id);

		assertNotNull(result);
		verify(studentService, times(1)).getStudentById(id);
	}

	@Test
	void testGetStudentByIdNotFound() throws StudentNotFoundException {
		Integer id = 1;
		when(studentService.getStudentById(id)).thenThrow(new StudentNotFoundException("Student not found"));

		assertThrows(StudentNotFoundException.class, () -> studentController.getStudentById(id));
		verify(studentService, times(1)).getStudentById(id);
	}

	@Test
	void testGetAllStudents() {
		List<Student> students = Arrays.asList(new Student(), new Student());
		when(studentService.getAllStudents()).thenReturn(students);

		List<Student> result = studentController.getAllStudents();

		assertNotNull(result);
		assertEquals(2, result.size());
		verify(studentService, times(1)).getAllStudents();
	}

	@Test
	void testDeleteStudentById() throws StudentNotFoundException {
		Integer id = 1;
		doNothing().when(studentService).deleteStudentById(id);

		studentController.deleteStudentById(id);

		verify(studentService, times(1)).deleteStudentById(id);
	}

	@Test
	void testTest() {
		ResponseEntity<?> response = studentController.test();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Student Controller is working", response.getBody());
	}
}
