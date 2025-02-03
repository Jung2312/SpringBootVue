package com.SpringBoot.SpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.SpringBoot.dao.BoardDAO;
import com.SpringBoot.SpringBoot.model.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardDAO boardDAO;
	
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}
	
	public BoardVO getBoard(BoardVO boardVO) {
		return boardDAO.getBoard(boardVO);
	}
}
