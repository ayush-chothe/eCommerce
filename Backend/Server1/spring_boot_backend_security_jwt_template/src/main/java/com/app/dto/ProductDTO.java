package com.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
	
	@NotNull
	private Long id;
	
	@NotBlank(message = "Product name cannot be empty")
	private String name;
	
	@Range(min = 0)
	private double price;
	
	@Range(min = 1)
	private int quantity;
	
	@NotNull(message="SellerId cannot be blank")
	private Long sellerId; 
	
	@NotNull(message="CategoryId cannot be blank")
	private Long categoryId;
}