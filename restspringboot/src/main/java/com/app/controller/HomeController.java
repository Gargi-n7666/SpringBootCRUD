package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;
import com.app.service.HomeServicei;

@RestController
public class HomeController  {
	
	@Autowired
	private HomeServicei hsi;
	
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student)
	{
		System.out.println("In Controller:  "+student);
		Student  stu = hsi.addStudent(student);
		return stu;
	}
	
	
	@GetMapping("/getall")
	public List<Student>  getAllStudent()
	{
		List<Student> list = hsi.getAllStudent();
		return list;
	}
	
	@GetMapping("/single/{rollno}")
	public Student getSingleData(@PathVariable int rollno)
	{
	   Student student = hsi.getSingleData(rollno);
	   return student;
	}
	
	
	@DeleteMapping("del/{rollno}")
	public List<Student> deleteStudent(@PathVariable int rollno)
	{
		List<Student> list = hsi.deleteStudent(rollno);
		return list;
	}
	
	@DeleteMapping("/entity")
	public String deleteByEntity(@RequestBody Student s)
	{
		String msg = hsi.deleteByEntity(s);
		return msg;
	}
	
	@DeleteMapping("/alldelete")
	public String deleteAllStudentData() {
		String msg = hsi.deleteAllData();
		return msg;
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student s)
	{
		Student updateStudent = hsi.updateStudent(s);
		return updateStudent;
	}
	
	
	@PostMapping("/mul")
	public List<Student> saveMultiplestudent(@RequestBody List<Student> list)
	{
		List<Student> list2 = hsi.savemultiplestudent(list);
		return list2;
	}
	
	@GetMapping("/login/{username}/{password}")
	public List<Student> loginStudent(@PathVariable String username, @PathVariable String password){
		List<Student> al = hsi.loginStudent(username , password);
		return al;
	}
	
	@DeleteMapping("deletebyname/{name}")
	public List<Student> deleteStudentByname(@PathVariable String name)
	{
		 List<Student> al =  hsi.deleteStudentByname(name);
		 return al;
	}
	
	
	@GetMapping("/pageing/{pageno}")
	public List<Student> pageing(@PathVariable int pageno)
	{
	     List<Student> list = hsi.pageing(pageno);
	     return list;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
