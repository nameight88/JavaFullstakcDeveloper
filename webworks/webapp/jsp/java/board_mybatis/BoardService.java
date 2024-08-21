package board_mybatis;

import java.util.HashMap;
import java.util.List;

import board_mybatis.*;

public class BoardService {
private static BoardService service;
	
	private BoardService() {}
	public static BoardService getInstance(){
		if( service == null) service = new BoardService();
		return service;
	}
	
	// Model == Repository
	private BoardRepo repo =new BoardRepo();

	public List<BoardVO> selectBoard(){
		return repo.selectBoard();
	}
	
	
	public List <BoardVO> getArticleList()
	   {
	       List <BoardVO> mList = repo.selectBoard();         
	       return mList;
	       //JDBC와 다르게 repo에서 getinstance없이 바로 호출
	   }//end of getArticleList
	/*
	public List<HashMap> selectEmpDept(){
		return repo.selectEmpDept();
	}
	*/
}
