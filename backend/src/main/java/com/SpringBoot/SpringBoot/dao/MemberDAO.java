package com.SpringBoot.SpringBoot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.SpringBoot.SpringBoot.model.MemberVO;

@Mapper
@Repository
public interface MemberDAO {
	
	void registerMember(MemberVO memberVo);
	MemberVO getMember(MemberVO memberVo);
	List<MemberVO> getMemberList() throws Exception;
	void updateMember(MemberVO memberVo);
	void deleteMember(MemberVO memberVO);
}
