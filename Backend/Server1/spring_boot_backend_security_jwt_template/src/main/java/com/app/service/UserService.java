package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.UserDTO;
import com.app.pojo.Role;
import com.app.pojo.User;
import com.app.pojo.UserStatus;

public interface UserService {
	ApiResponse addNewUser(User user);
	List<UserDTO> getAllUsers();
	List<UserDTO> getAllSellers(Role role, UserStatus status);
	User findUserById(Long id);
	ApiResponse updateUser(User user);
}
