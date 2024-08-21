package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import com.example.domain.BoardVO;

/*
DAO 와 Mapper 연결
	[1] Mapper에서 <mapper namespace="com.example.dao.BoardDAO">
	
	[2] DAO 클래스에서 함수명과 Mapper에서의 ID 값 동일 
*/

@Mapper
public interface BoardDAO {
	public List<BoardVO> getBoardList(BoardVO vo) ;
	public HashMap getBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public int saveBoard(BoardVO vo);
}
