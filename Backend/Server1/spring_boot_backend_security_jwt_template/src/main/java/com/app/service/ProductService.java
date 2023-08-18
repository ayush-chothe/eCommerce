package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.dto.ProductDTO;

public interface ProductService {

	ApiResponse addNewProduct(ProductDTO productDto);
	ProductDTO getProduct(Long id);
	ApiResponse deleteProduct(Long id);
	ApiResponse addImage(Long productId, MultipartFile image) throws IOException;
	public byte[] getImages(Long productId) throws IOException;
	ApiResponse addProductToCart(CartDto cartDto);
}
