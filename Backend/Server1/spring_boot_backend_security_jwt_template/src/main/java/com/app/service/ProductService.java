package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;

public interface ProductService {

	ApiResponse addNewProduct(ProductDTO productDto);
	ProductDTO getProduct(Long id);
}
