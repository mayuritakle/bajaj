package com.bajajFinserv.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bajajFinserv.model.Student;
import com.bajajFinserv.repository.StudentRepo;
import com.bajajFinserv.response.ResponseHandler;




@RestController
@RequestMapping(value = "/")
public class StudentController {
	@Autowired
	private StudentRepo repository;

	public StudentController getRepository() {
		return (StudentController) repository;
	}

	public void setRepository(StudentRepo repository) {
		this.repository = repository;
	}


	@GetMapping(value = "/student")
	public List<Student> getAllStudent() {
		return repository.findAll();
	}


	@PostMapping("/student")
	ResponseEntity<Object> createOrSaveStudent(@RequestBody Student newStudent) {
		
		String[] data = newStudent.getData();
		 List<Integer> intArrayList = new ArrayList<>();
		 List<String> alphaArrayList = new ArrayList<>();

	        for (String string : data) {
	            if (!string.equals("")) {
	                System.out.println(string);
	                intArrayList.add(Integer.parseInt(string));
	            }else {
	            	alphaArrayList.add(string);
	            }
	        }

	            try {
	            	repository.save(newStudent);
	        	
	                return ResponseHandler.generateResponse(true,intArrayList,alphaArrayList, HttpStatus.OK);
	            } catch (Exception e) {
	                return ResponseHandler.generateResponse("Request failed");
	            }

	        
	       
	}

//	@GetMapping("/student/{id}")
//	Student getStudentById(@PathVariable int id) {
//		return repository.findById(id).get();
//	}
//
////	@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
////	@PutMapping("/student/{id}")
////	Student updateScheme(@RequestBody Student newStudent, @PathVariable int id) {
////
////		return repository.findById(id).map(Student -> {
////			Student.setIs_success(newStudent.isIs_success());
////			Student.setUser_id(newStudent.getUser_id());		
////			Student.setEmail(newStudent.getEmail());
////			Student.setRoll_number(newStudent.getRoll_number());
////			Student.setAlphabets(newStudent.getAlphabets());
////			Student.setNumbers(newStudent.getNumbers());
////
////			return repository.save(Student);
////		}).orElseGet(() -> {
////			newStudent.setId(id);
////			return repository.save(newStudent);
////		});
////	}
//
//	@DeleteMapping("/student/{id}")
//	void deleteStudent(@PathVariable int id) {
//		repository.deleteById(id);
//	}
}
