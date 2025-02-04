package com.SpringBoot.SpringBoot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class BoardVO {
	private Long id; 
	private String title;
	private String content;
	private Long author_id;
	private String created_at;
	private String updated_at;
	private String email;
}
