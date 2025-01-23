package com.SpringBoot.SpringBoot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.SpringBoot.SpringBoot.model.MemberVO;

@Mapper
@Repository
public interface MemberDAO {
	List<MemberVO> getMemberList() throws Exception;
	
	MemberVO getMember(MemberVO memberVo);
	
	void registerMember(MemberVO memberVo);
}
