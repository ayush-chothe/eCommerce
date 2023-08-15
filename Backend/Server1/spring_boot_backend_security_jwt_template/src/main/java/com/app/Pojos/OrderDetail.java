package com.app.Pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_details") 
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Id
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column
	private int quantity;
}
