package com.app.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reviews") 
@NoArgsConstructor
@Getter
@Setter
public class Review implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8988058360669993353L;

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(length = 150)
	private String review;
	
	@Column
	private int rating;
}
