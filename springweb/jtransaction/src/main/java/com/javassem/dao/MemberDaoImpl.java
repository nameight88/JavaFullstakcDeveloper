package com.javassem.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.vo.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSessionTemplate ss;
	
	public void insertMember(MemberVO vo){
		ss.insert("member.insertMember", vo);
	}
}
