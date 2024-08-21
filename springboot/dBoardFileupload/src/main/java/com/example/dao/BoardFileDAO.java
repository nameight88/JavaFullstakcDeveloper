package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.BoardFileVO;
import com.example.domain.BoardVO;

@Mapper
public interface BoardFileDAO {
	//파일 업로드
	public void insertFile(BoardFileVO vo);
	
	//파일 업로드 조회
	public int selectFile (BoardFileVO vo);
	
	public int selectId();
}
