package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.model.Student;
import com.app.repository.HomeRepoI;

@Service
public class Homeservice implements HomeServicei  {
	
	@Autowired
	private  HomeRepoI hri;

	@Override
	public Student addStudent(Student student) {
	    System.out.println("In service: "+student);
		Student stu = hri.save(student);             
		return stu;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = (List<Student>) hri.findAll();
		return list;
	}

	@Override
	public Student getSingleData(int rollno) {
		
	Optional<Student> op = 	hri.findById(rollno);
	
	if(op.isPresent())
	{
		Student student = op.get();
		return student;
	}
		
		return null;
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		
		hri.deleteById(rollno);
		List<Student> all = (List<Student>) hri.findAll();
		return all;
	}

	@Override
	public String deleteByEntity(Student s) {
		hri.delete(s);
		return "All data Deleted";
		
	}

	@Override
	public String deleteAllData() {
		hri.deleteAll();
		return "All Data Deleted";
	}

	@Override
	public Student updateStudent(Student s)
	{
		Student save = hri.save(s);
		return null;
	}

	@Override
	public List<Student> savemultiplestudent(List<Student> list)
	{
		List<Student> al = (List<Student>) hri.saveAll(list);
		return al;
	}
	
	@Override
	public List<Student> loginStudent(String username , String password){
		if(username.equals("admin")&& password.equals("admin")) {
			List<Student> list = hri.findAll();
			return list;
		}else {
			List<Student> al = new ArrayList<Student>();
			Student student = hri.findByUsernameAndPassword(username,password);
			al.add(student);
			return al;
			
		}
	}

	@Override
	public List<Student> deleteStudentByname(String name) {
		hri.deleteByName(name);
		return hri.findAll();
	}

	@Override
	public List<Student> pageing(int pageno) {
		
		int size = 1;
		PageRequest request = PageRequest.of(pageno, size, Sort.by("name").descending());
		Page<Student> page = hri.findAll(request);
		
		List<Student> list = page.getContent();
		
		return list;

	
	
	}
	

}
