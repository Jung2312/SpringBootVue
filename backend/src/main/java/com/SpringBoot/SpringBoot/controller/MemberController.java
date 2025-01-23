package com.SpringBoot.SpringBoot.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot.SpringBoot.model.MemberVO;
import com.SpringBoot.SpringBoot.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/allMember")
	public ResponseEntity<HashMap<String, Object>> getMemberList() throws Exception {
	    // 회원 목록 조회
	    List<MemberVO> list = memberService.getMemberList();

	    // 결과 데이터 구성
	    HashMap<String, Object> result = new HashMap<>();
	    result.put("list", list);

	    // 데이터가 없을 경우에도 빈 리스트와 상태 코드 200 반환
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/allMember2")
	public HashMap<String, Object> getMemberList2() throws Exception {
		// 페이지와 페이지 사이즈를 전달해 데이터 조회
		List<MemberVO> list = memberService.getMemberList();
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("list", list);
		
		return result;
	}
	
	@GetMapping("/getMember")
	public MemberVO getMember(@RequestParam String email) throws Exception {
		
		MemberVO memberVo = new MemberVO();
		
		memberVo.setEmail(email);
		
		// 페이지와 페이지 사이즈를 전달해 데이터 조회
		MemberVO member = memberService.getMember(memberVo);
		
		return member;
	}
	
//	@PostMapping("/register")
//    public ResponseEntity<String> registerMember(@Validated @RequestBody MemberVO memberVo) {
//        memberService.registerMember(memberVo);
//        return ResponseEntity.ok("회원 가입 완료");
//    }
}
