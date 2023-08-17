package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.UserDTO;
import com.app.pojo.Role;
import com.app.pojo.User;
import com.app.pojo.UserStatus;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addNewUser(User user) {
		userRepository.save(user);
		return new ApiResponse("User added successfully!");
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
		return userRepository.findById(id).orElseThrow();
	}

	@Override
	public ApiResponse updateUser(User user) {
		userRepository.save(user);
		return new ApiResponse("User updated successfully!");
	}
	
	
}