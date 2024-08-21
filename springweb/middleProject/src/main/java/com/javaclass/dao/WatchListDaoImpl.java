package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.vo.WatchListVO;

@Repository("WatchListDao")
public class WatchListDaoImpl implements WatchListDao{
	
	@Autowired
	private SqlSessionTemplate session;

	// 관심 매물등록
	@Override
	public int watchListInsert(HashMap map) {
		return session.insert("watchList.watchListInsert", map);
	}
	// 관심 매물삭제
	@Override
	public int watchListDelete(WatchListVO vo) {
		return session.delete("watchList.watchListDelete", vo);
	}
	
	// 관심매물 select	(user받아와서)	
	@Override
	public List<WatchListVO> watchListSelect(String user_id) {
		return session.selectList("watchList.watchListSelect",user_id);
	}
	@Override
	public boolean watchListproperty(String user_id, int property_id) {
		HashMap map = new HashMap();
		map.put("user_id", user_id);
		map.put("property_id", property_id);
		
		return session.selectOne("watchList.watchListproperty", map);

	}

}
