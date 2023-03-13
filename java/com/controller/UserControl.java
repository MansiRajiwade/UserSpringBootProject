package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.UserRepository;

@RestController
public class UserControl{
	
	@Autowired
	UserRepository ur;
	
	@PostMapping("/Hii")
	   public String m1()
	   {
		return "Hello World";
	   }
	  
		@PostMapping("/savetheuser")
		public String saveUser(@RequestBody User u) {
		 // System.out.println(u.getAge());
			ur.save(u);
			return "saved successfully";
		} 
			
				
		@GetMapping("/getuserdata")
		public User getUser(@RequestParam int id) {
		Optional<User> ou = ur.findById(id);
		 return ou.get();
		
	}
			
	     @GetMapping("/getalldata")
		 public List<User> getAllusers(){
		 return ur.findAll();
			}
			
		@DeleteMapping("/deleteuserdata")
		public String deleteUser(@RequestParam int id) {
		ur.deleteById(id);
		return "delete successfully";
	}
			
		@PutMapping("/updateuserdata")
		public void updateUserData(@RequestBody User u) {
		ur.save(u);
	}

}