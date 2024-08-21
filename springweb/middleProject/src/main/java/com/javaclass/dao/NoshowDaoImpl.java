package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.vo.NoshowVO;

@Repository
public class NoshowDaoImpl implements NoshowDao{
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public int noshowInsert(NoshowVO vo) {
		return mybatis.insert("noshow.noshowInsert",vo);
	}

	@Override
	public int noshowDelete(NoshowVO vo) {
		return mybatis.delete("noshow.noshowDelete",vo);
	}

	@Override
	public boolean noshowSelect(int reservation_id) {
		return mybatis.selectOne("noshow.noshowSelect",reservation_id);
	}
	
	
	
	@Override
	public List<NoshowVO> noshowGetList(int offset,int size) {
		Map<String,Integer> params = new HashMap<String,Integer>();
		params.put("offset", offset);
		params.put("size",size);
		return mybatis.selectList("noshow.noshowGetList",params);
	}

	public int getTotalNoshow() {
		return mybatis.selectOne("noshow.getTotalNoshow");
	}

}
