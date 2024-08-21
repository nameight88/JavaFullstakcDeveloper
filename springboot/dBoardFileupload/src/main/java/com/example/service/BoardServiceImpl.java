package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BoardDAO;
import com.example.dao.BoardFileDAO;
import com.example.domain.BoardFileVO;
import com.example.domain.BoardVO;

//**
@Service
public class BoardServiceImpl implements BoardService {
	
	//**
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private BoardFileDAO boardFileDAO;


	public List<BoardVO>getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	
	public HashMap getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	
	@Transactional
	public void saveBoard(BoardVO vo,BoardFileVO fvo) {
		//파일첨부가 있는 경우라면
		if(fvo  != null) {
			boardFileDAO.insertFile(fvo);
			vo.setFileid(boardFileDAO.selectId());
		}
		boardDAO.saveBoard(vo);
	}
}
