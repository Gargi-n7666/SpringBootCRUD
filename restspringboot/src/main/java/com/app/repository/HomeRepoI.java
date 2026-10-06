package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Student;

import jakarta.transaction.Transactional;

@Repository
public interface HomeRepoI  extends JpaRepository<Student, Integer>{

	Student findByUsernameAndPassword(String username, String password);
	
	@Query("from Student where username=?1 and password=?2")  // jPQL
	public Student validateStudentByUsernameAndPassword(String username, String password);
	
	
	@Query("from Student where username=:username and password=:password")  // named parameter
	public Student getStudentByUsernameAndPassword(@Param("username") String un , @Param("password") String ps);
	
	@Query("from Student")
	public List<Student> getAllData();
	
	public List<Student>  findByName(String name);
	
	@Transactional
	@Modifying
	public void deleteByName(String name);

	


	

}
