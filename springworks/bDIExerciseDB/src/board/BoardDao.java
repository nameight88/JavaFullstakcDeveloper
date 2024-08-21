package board;

import java.util.List;

import board.vo.BoardVO;

public interface BoardDao {
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
}
