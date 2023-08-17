package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.pojo.Product;
import com.app.pojo.SubSubCategory;
import com.app.pojo.User;
import com.app.repository.ProductRepository;
import com.app.repository.SubSubCategoryRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SubSubCategoryRepository subSubCategoryRepository;
	
	@Autowired
	private ModelMapper mapper;

	// add product
	@Override
	public ApiResponse addNewProduct(ProductDTO productDto) {

		Product product = mapper.map(productDto, Product.class);
		
		User seller = userRepository.findById(productDto.getSellerId()).orElseThrow();
		SubSubCategory cat = subSubCategoryRepository.findById(productDto.getCategoryId()).orElseThrow();
		
		product.setSeller(seller);
		product.setCategory(cat);
		
		productRepository.save(product);
		
		return new ApiResponse("Product addition successful");
	}
}
