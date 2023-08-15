package com.app.Pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products") 
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity implements Serializable{
	
	@Column(name = "product_name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "product_price", nullable = false)
	private double price;
	
	@Column(name = "product_quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private User seller; 
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private SubSubCategory category;	
}
