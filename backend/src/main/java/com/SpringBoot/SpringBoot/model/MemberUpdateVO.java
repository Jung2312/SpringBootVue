package com.SpringBoot.SpringBoot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class MemberUpdateVO {
	private Long id;
	private String username;
	private String email;
	private String profile_img;
	private String phone;
	private String birthday;
	private String job_title;
}
