package com.example.service;

import java.util.HashMap;
import java.util.List;

import com.example.domain.BoardFileVO;
import com.example.domain.BoardVO;

public interface BoardService {
	
	List<BoardVO> getBoardList(BoardVO vo);
	
	HashMap getBoard(BoardVO vo);
	
	void updateBoard(BoardVO vo);
	
	void deleteBoard(BoardVO vo);
	
	void saveBoard(BoardVO vo ,BoardFileVO fvo);
}
