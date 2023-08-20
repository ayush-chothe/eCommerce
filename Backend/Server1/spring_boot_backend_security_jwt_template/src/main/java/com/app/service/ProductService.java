package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.dto.ProductDTO;
import com.app.dto.ReviewDTO;
import com.app.pojo.Review;

public interface ProductService {

	ApiResponse addNewProduct(ProductDTO productDto);
	ProductDTO getProduct(Long id);
	ApiResponse deleteProduct(Long id);
	ApiResponse addImage(Long productId, MultipartFile image) throws IOException;
	byte[] getImages(Long productId) throws IOException;
	ApiResponse addProductToCart(CartDto cartDto);
	ApiResponse reviewProduct(ReviewDTO reviewDto);
	List<ReviewDTO> getReviews(Long productId);
}
