package com.SpringBoot.SpringBoot.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<HashMap<String, Object>> getMemberList(@Validated MemberVO memberVo) throws Exception {
        // 페이지와 페이지 사이즈를 전달해 데이터 조회
        List<MemberVO> list = memberService.getMemberList(memberVo);

        HashMap<String, Object> result = new HashMap<>();
        result.put("list", list);

        if (list == null || list.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
	
	@GetMapping("/allMember2")
	public HashMap<String, Object> getMemberList2(@Validated MemberVO memberVo) throws Exception {
		// 페이지와 페이지 사이즈를 전달해 데이터 조회
		List<MemberVO> list = memberService.getMemberList(memberVo);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("list", list);
		
		return result;
	}
	
	@GetMapping("/getMember")
	public MemberVO getMember(@RequestParam Long id) throws Exception {
		
		MemberVO memberVo = new MemberVO();
		
		memberVo.setId(id);
		
		// 페이지와 페이지 사이즈를 전달해 데이터 조회
		MemberVO member = memberService.getMember(memberVo);
		
		return member;
	}
}
