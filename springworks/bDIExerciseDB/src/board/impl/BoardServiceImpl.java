package board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import board.BoardDao;
import board.BoardService;
import board.vo.BoardVO;

//@Component의 자식 클래스 Service
@Service("boardService")                             
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDAO;
	
	// 메소드오버라이딩
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		boardDAO.getBoard(vo);
		return null;
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		//List<BoardVO> list =boardDAO.getBoardList(vo);
		//return list;
		
		return boardDAO.getBoardList(vo);
	}

}
