package com.javaclass.service;

import java.util.HashMap;
import java.util.List;

import com.javaclass.vo.WatchListVO;

public interface WatchListService {
	
	// 관심 매물등록
	public int watchListInsert(HashMap map);
	
	// 관심 매물삭제
	public int watchListDelete(WatchListVO vo);
	
	// 관심 매물select
	public List<WatchListVO> watchListSelect(String user_id);
	
	public boolean watchListproperty(String user_id, int property_id);
	

}
