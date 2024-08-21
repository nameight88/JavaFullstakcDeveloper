package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BoardVO;
import com.example.persistence.BoardRepository;

//**
@Service
public class BoardServiceImpl implements BoardService {
	
	//**
	@Autowired
//	private BoardDAO boardDAO;
	private BoardRepository boardRepo;


	public List<BoardVO>getBoardList(BoardVO vo) {
//		return boardDAO.getBoardList(vo);
		return (List<BoardVO>)boardRepo.findAll();
	}
	
	public BoardVO getBoard(BoardVO vo) {
//		return boardDAO.getBoard(vo);
		return boardRepo.findById(vo.getSeq()).get();
	}
	public void deleteBoard(BoardVO vo) {
//		boardDAO.deleteBoard(vo);
		boardRepo.deleteById(vo.getSeq());
	}

	public void updateBoard(BoardVO vo) {
//		boardDAO.updateBoard(vo);
		BoardVO findBoard = boardRepo.findById(vo.getSeq()).get();
		findBoard.setTitle(vo.getTitle());
		findBoard.setContent(vo.getContent());
		// 해당하는 값을 다시 받아서 저장을 해준다.
		boardRepo.save(findBoard);
	}

	public void saveBoard(BoardVO vo) {
//		return boardDAO.saveBoard(vo);
		boardRepo.save(vo);
	}
}
