package com.SpringBoot.SpringBoot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.SpringBoot.SpringBoot.model.BoardVO;

@Mapper
@Repository
public interface BoardDAO {
	List<BoardVO> getBoardList() throws Exception;
	
	BoardVO getBoard(BoardVO boardVO);
}
