package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.javaclass.vo.DeclarationVO;

@Repository("DeclarationDao")
public class DeclarationDaoImpl implements DeclarationDao{

	@Autowired
	private SqlSessionTemplate mybatis;


	@Override
	public void declarationInsert(DeclarationVO vo) {
		mybatis.insert("declaration.declarationInsert",vo);
	}

	@Override
	public List<DeclarationVO> getDeclarationList(int offset,int size) {
		Map<String,Integer> Params = new HashMap<String,Integer>();
		Params.put("offset",offset);
		Params.put("size",size);
		return mybatis.selectList("declaration.getDeclarationList",Params);
	}

	public int getTotalDeclaration() {
		return mybatis.selectOne("declaration.getTotalDeclaration");
	}

	@Override
	public void declarationPropertyDelete(Model m) {
		
		mybatis.delete("declaration.declarationPropertyDelete",m);
	}

	@Override
	public void declarationDelete(int declaration_num) {
		
		mybatis.delete("declaration.declarationDelete",declaration_num);
	}


	// 채은 추가 사용자 신고확인 list
	// 0520 추가 : 사용자 신고관리 수 페이징 ----------------------------- 
	@Override
	public List<DeclarationVO> userDeclarationList(String user_id, int offset, int size) {
		HashMap params = new HashMap();
		params.put("user_id", user_id);
		params.put("offset", offset);
		params.put("size", size);
		

		
		return mybatis.selectList("declaration.userDeclarationList",params);
	}

	@Override
	public int userDeclarationDelete(DeclarationVO vo) {
		return mybatis.delete("declaration.userDeclarationDelete", vo);
	}

	// 0520 추가 : 사용자 신고관리 수 뽑기 -----------------------------
	@Override
	public int getTotalDeclarationCount(String user_id) {
		
		int a = mybatis.selectOne("declaration.userDeclarationListCount", user_id);
		
		return a;
	}

}
