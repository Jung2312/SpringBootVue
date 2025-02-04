package com.SpringBoot.SpringBoot.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class MemberVO {
	private Long id;
	private String username;
	private String password;
	private String email;
	private String created_at;
	private String profile_img;
	private String phone;
	private String birthday;
	private String job_title;

    // 중첩 데이터 리스트 추가
    private List<ExperienceVO> experiences;
    private List<EducationVO> educations;
	
}
