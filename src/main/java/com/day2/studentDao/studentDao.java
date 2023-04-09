package com.day2.studentDao;

import java.util.List;

import com.day2.model.Student;

public interface studentDao {

	public int insert(Student student);
	
	public int change(Student student);
	
	public int delete(int studentId);
	
	public Student getStudent(int studentId);
	
	public List<Student> getAllStudents();
}
