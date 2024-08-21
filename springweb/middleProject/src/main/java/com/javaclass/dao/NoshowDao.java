package com.javaclass.dao;

import java.util.List;

import com.javaclass.vo.NoshowVO;

public interface NoshowDao {
	// 노쇼 insert
	public int noshowInsert(NoshowVO vo);
	
	public int noshowDelete(NoshowVO vo);
	
	public boolean noshowSelect(int reservation_id);
	
	
	// 다윗추가
	public List<NoshowVO> noshowGetList(int offset,int size);
	
	public int getTotalNoshow();

}
