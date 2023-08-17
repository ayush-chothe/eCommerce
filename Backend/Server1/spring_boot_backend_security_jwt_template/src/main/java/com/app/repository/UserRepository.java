package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojo.Role;
import com.app.pojo.User;
import com.app.pojo.UserStatus;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByRoleAndStatus(Role role, UserStatus status);
}
