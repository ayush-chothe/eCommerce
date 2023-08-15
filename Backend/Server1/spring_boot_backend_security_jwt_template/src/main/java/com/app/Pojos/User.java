package com.app.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users") 
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true,of = "email")
public class User extends BaseEntity{

	@Column(length = 30)
	private String name;
	
	@Column(length = 30, unique = true) // =>unique
	private String email;
	
	@Column(nullable = false, length=30) // =>NOT NULL
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Role role;
	
	@Column(length = 10)
	private String mobile;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private UserStatus status;
}
