package com.SpringBoot.SpringBoot.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.SpringBoot.model.BoardVO;
import com.SpringBoot.SpringBoot.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/allBoard")
	public ResponseEntity<HashMap<String, Object>> getBoardList() throws Exception {
	    // 회원 목록 조회
	    List<BoardVO> list = boardService.getBoardList();

	    // 결과 데이터 구성
	    HashMap<String, Object> result = new HashMap<>();
	    result.put("list", list);

	    // 데이터가 없을 경우에도 빈 리스트와 상태 코드 200 반환
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard(@RequestParam Long id) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setId(id);
		
		BoardVO board = boardService.getBoard(boardVO);
		
		// 데이터가 없을 경우에도 빈 리스트와 상태 코드 200 반환
		return board;
	}
	
}
