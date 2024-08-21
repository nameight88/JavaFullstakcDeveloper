package com.javaclass.service;

import java.util.List;

import com.javaclass.vo.NoshowVO;

public interface NoshowService {
	
	// 노쇼 insert
	public int noshowInsert(NoshowVO vo);
	
	// 노쇼 delete
	public int noshowDelete(NoshowVO vo);
	
	// 노쇼인지 아닌지 판별하기 위함
	public boolean noshowSelect(int reservation_id);
	
	// 다윗추가
	public List<NoshowVO> noshowGetList(int page,int size);
	
	public int getTotalNoshow();
	

}
