package com.app.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReviewDTO {
	
	private Long customerId;
	
	private Long productId;
	
	private String review;
	
	private int rating;
}
