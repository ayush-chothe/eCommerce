package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.dto.UserDTO;
import com.app.pojo.Cart;
import com.app.pojo.Role;
import com.app.pojo.User;
import com.app.pojo.UserStatus;
import com.app.repository.CartRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public ApiResponse addNewUser(User user) {
		userRepository.save(user);
		ApiResponse res = new ApiResponse("User added successfully!");
		if(user.getRole() == Role.SELLER) {
			res.setMessage("Registration Successfull, pending for Admin approval");
			user.setStatus(UserStatus.PENDING);
		}
		else if(user.getRole() == Role.CUSTOMER)  res.setMessage("Registration Successfull");
		return res;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream()
				.map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserDTO> getAllSellers(Role role, UserStatus status) {
		List<User> sellers = userRepository.findByRoleAndStatus(role, status);
		return sellers.stream()
				.map(seller -> mapper.map(seller, UserDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public User findUserById(Long id) {
		// TODO add custom exception
		return userRepository.findById(id).orElseThrow();
	}

	@Override
	public ApiResponse updateUser(User user) {
		userRepository.save(user);
		return new ApiResponse("User updated successfully!");
	}

	@Override
	public ApiResponse loginUser(LoginDTO credentials) {
		userRepository.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword()).orElseThrow();
		return new ApiResponse("Logged in Successully!");
	}

	@Override
	public List<Cart> getCart(Long userId) {
		User user = userRepository.findById(userId).orElseThrow();
		return cartRepository.findByUser(user);
		
	}
	
	
}
