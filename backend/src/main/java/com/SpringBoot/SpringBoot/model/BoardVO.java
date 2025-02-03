package com.SpringBoot.SpringBoot.model;

import lombok.Data;

@Data
public class BoardVO {
	private Long id; 
	private String title;
	private String content;
	private Long author_id;
	private String created_at;
	private String updated_at;
	private String email;
}
