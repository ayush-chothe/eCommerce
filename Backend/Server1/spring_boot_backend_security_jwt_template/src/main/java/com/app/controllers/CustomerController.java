package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.pojo.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class CustomerController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addCustomer")
	@PreAuthorize("hasAuthority('user:write')")
	public ResponseEntity<?> addNewCustomer(@RequestBody User user) {
		ApiResponse res = userService.addNewUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}
}
