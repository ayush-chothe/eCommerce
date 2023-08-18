package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.pojo.Cart;

public interface OrderService {
	ApiResponse confirmPayment(Long id);
}
