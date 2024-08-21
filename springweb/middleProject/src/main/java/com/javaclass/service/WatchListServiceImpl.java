package com.javaclass.service;


import com.javaclass.dao.WatchListDao;
import com.javaclass.vo.WatchListVO;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WatchListService")
public class WatchListServiceImpl implements WatchListService{
	
	@Autowired
	private WatchListDao watchListDao;

	// 관심 매물등록
	@Override
	public int watchListInsert(HashMap map) {
		return watchListDao.watchListInsert(map);
	}

	// 관심 매물삭제
	@Override
	public int watchListDelete(WatchListVO vo) {
		return watchListDao.watchListDelete(vo);
	}

	// 관심매물 select	
	@Override
	public List<WatchListVO> watchListSelect(String user_id) {
		return watchListDao.watchListSelect(user_id);
	}

	@Override
	public boolean watchListproperty(String user_id, int property_id) {
		boolean count = watchListDao.watchListproperty(user_id, property_id);
		return count;
	}

}
