package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	
}
