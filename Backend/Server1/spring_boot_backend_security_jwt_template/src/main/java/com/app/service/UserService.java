package com.app.service;

import com.app.dto.ApiResponse;
import com.app.pojo.User;

public interface UserService {
	ApiResponse addNewUser(User user);
}
