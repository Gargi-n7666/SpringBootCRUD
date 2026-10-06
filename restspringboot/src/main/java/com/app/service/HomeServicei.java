package com.app.service;

import java.util.List;

import com.app.model.Student;

public interface HomeServicei {
	
	public Student addStudent(Student student);
	public List<Student> getAllStudent();
	public Student getSingleData(int rollno);
	public List<Student> deleteStudent(int rollno);
	public String deleteByEntity(Student s);
	public String deleteAllData();
	public Student updateStudent(Student s);
	public List<Student> savemultiplestudent(List<Student> list);
	public List<Student> loginStudent(String username, String password);
	public List<Student> deleteStudentByname(String name);
	public List<Student> pageing(int pageno);

	
}
