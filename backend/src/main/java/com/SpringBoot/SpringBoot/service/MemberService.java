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
    //private final PasswordEncoder passwordEncoder;
    
    public List<MemberVO> getMemberList() throws Exception {
        return memberDAO.getMemberList(); 
    }
    
    public MemberVO getMember(MemberVO memberVo) throws Exception {
    	return memberDAO.getMember(memberVo);
    }
    
//	public void registerMember(MemberVO memberVo) {
//        // 비밀번호 암호화
//		memberVo.setPassword(passwordEncoder.encode(memberVo.getPassword()));
//        // DB에 저장
//		memberDAO.registerMember(memberVo);
//	}
    
	public void updateMember(MemberVO memberVo) {
		memberDAO.updateMember(memberVo);
	}
	
	public void deleteMember(MemberVO memberVo) {
		memberDAO.updateMember(memberVo);
	}
}
