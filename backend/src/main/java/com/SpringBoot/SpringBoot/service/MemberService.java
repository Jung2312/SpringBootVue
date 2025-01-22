package com.SpringBoot.SpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.SpringBoot.dao.MemberDAO;
import com.SpringBoot.SpringBoot.model.MemberVO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDAO memberDAO;

    public List<MemberVO> getMemberList(MemberVO memberVo) throws Exception {
        return memberDAO.getMemberList(memberVo); 
    }
    
    public MemberVO getMember(MemberVO memberVo) throws Exception {
    	return memberDAO.getMember(memberVo);
    }
}
