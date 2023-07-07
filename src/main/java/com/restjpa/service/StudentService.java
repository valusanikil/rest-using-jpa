package com.restjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restjpa.entity.Student;
import com.restjpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(int studentId) {
		return studentRepository.findById(studentId);
	}
	
	public void deleteStudentById(int studentId) {
		studentRepository.deleteById(studentId);
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
}
