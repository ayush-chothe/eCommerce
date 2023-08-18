package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.CartDto;
import com.app.dto.ProductDTO;
import com.app.pojo.Cart;
import com.app.pojo.Product;
import com.app.pojo.ProductImage;
import com.app.pojo.ProductStatus;
import com.app.pojo.SubSubCategory;
import com.app.pojo.User;
import com.app.repository.CartRepository;
import com.app.repository.ProductImageRepository;
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
	private ProductImageRepository productImageRepository;
	
	@Autowired 
	private CartRepository cartRepository;

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
		product.setStatus(ProductStatus.ADDED);

		productRepository.save(product);

		return new ApiResponse("Product addition successful");
	}

	@Override
	public ProductDTO getProduct(Long id) {
		Product product = productRepository.findById(id).orElseThrow();
		List<ProductImage> productImages = productImageRepository.findByProduct(product);
		ProductDTO productDto = mapper.map(product, ProductDTO.class);
		List<Long> list = new ArrayList<>();
		
		for (ProductImage pi : productImages) {
			list.add(pi.getId());
		}
		productDto.setProductImageIds(list);
		// TODO add sellerid and categoryid in productDto
		return productDto;
	}

	@Override
	public ApiResponse deleteProduct(Long id) {
		Product product = productRepository.findById(id).orElseThrow();
		product.setStatus(ProductStatus.REMOVED);
		return new ApiResponse("Product Removed");
	}

	@Override
	public ApiResponse addImage(Long productId, MultipartFile image) throws IOException {
		ProductImage productImage = new ProductImage();
		Product product = productRepository.findById(productId).orElseThrow();
		productImage.setProduct(product);
		productImage.setImage(image.getBytes());

		productImageRepository.save(productImage);

		return new ApiResponse("Image added successfully");
	}

	@Override
	public byte[] getImages(Long productImageId) throws IOException {

		ProductImage productImage = productImageRepository.findById(productImageId).orElseThrow();
		return productImage.getImage();
	}

	@Override
	public ApiResponse addProductToCart(CartDto cartDto) {
		
		User user = userRepository.findById(cartDto.getUserId()).orElseThrow();
		Product product = productRepository.findById(cartDto.getProductId()).orElseThrow();
		
		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setUser(user);
		cart.setQuantity(cartDto.getQuantity());
		
		cartRepository.save(cart);
		
		
		return new ApiResponse("Product added to cart");
	}
	
	

}
