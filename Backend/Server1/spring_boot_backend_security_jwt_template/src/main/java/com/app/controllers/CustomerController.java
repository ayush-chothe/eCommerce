package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.dto.UserDTO;
import com.app.pojo.Role;
import com.app.pojo.User;
import com.app.pojo.UserStatus;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class CustomerController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/register")
	public ResponseEntity<?> addNewCustomer(@RequestBody User user) {
		ApiResponse res = userService.addNewUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}
	
	@GetMapping
	public List<UserDTO> getAllCustomers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserDTO findUserById(@RequestParam Long id) {
		User user = userService.findUserById(id);
		return mapper.map(user, UserDTO.class);
	}
	
	@GetMapping("/userToUpdate/{id}")
	public User findUserToUpdate(@RequestParam Long id) {
		return userService.findUserById(id);
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody @Valid LoginDTO credentials) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(credentials));
	}
}
