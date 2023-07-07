package com.restjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restjpa.entity.Student;
import com.restjpa.exception.NoStudentFoundWithIdException;
import com.restjpa.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students") //web request method
	public Student addStudent(@RequestBody Student student) {
		Student s=studentService.addStudent(student);
		return s;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> list=studentService.getAllStudents();
		if(list.isEmpty()) {
			throw new NullPointerException("No students found");
		}
		return list;
	}
	
	@GetMapping("/students/{id}")
	public Optional<Student> getStudentById(@PathVariable("id") int studentId) throws NoStudentFoundWithIdException {
		Optional<Student> student= Optional.of(studentService.getStudentById(studentId).orElseThrow(
				()->new NoStudentFoundWithIdException("No student found with id: "+studentId)));
		
		return student;
	}
	
	
	@DeleteMapping("/students/{id}") 
	public void deleteStudentById(@PathVariable("id") int studentId){
		studentService.deleteStudentById(studentId);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		Student st=studentService.updateStudent(student);
		return st;
	}
}
