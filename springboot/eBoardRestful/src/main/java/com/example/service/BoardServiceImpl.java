package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;

//**
@Service
public class BoardServiceImpl implements BoardService {
	
	//**
	@Autowired
	private BoardDAO boardDAO;


	public List<BoardVO>getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		 boardDAO.deleteBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void saveBoard(BoardVO vo) {
		boardDAO.saveBoard(vo);
	}
}
