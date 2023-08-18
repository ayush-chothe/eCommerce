package com.app.controllers;

import javax.validation.Valid;

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
import com.app.dto.ProductDTO;
import com.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService prodService;

	@PostMapping("/addProduct")
	public ApiResponse addNewProduct(@RequestBody @Valid ProductDTO product) {
		return prodService.addNewProduct(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@RequestParam Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(prodService.getProduct(id));
	}
	
	@PutMapping("/editProduct")
	public ResponseEntity<?> editProduct(@RequestBody @Valid ProductDTO productDto) {
		return ResponseEntity.status(HttpStatus.OK).body(prodService.addNewProduct(productDto));
	}
}
