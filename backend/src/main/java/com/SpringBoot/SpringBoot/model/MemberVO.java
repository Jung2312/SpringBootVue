package com.SpringBoot.SpringBoot.model;

import lombok.Data;

@Data
public class MemberVO {
	private Long id;
	private String username;
	private String password;
	private String email;
	private String created_at;
	private String updated_at;
}
