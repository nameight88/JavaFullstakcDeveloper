package com.javaclass.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.vo.AgentVO;

@Repository
public class AgentDaoImpl implements AgentDao{
	@Autowired
	private SqlSessionTemplate ss;
	
	public void insertAgent(AgentVO vo){
		ss.insert("agent.insertAgent", vo);
		
	}
	
	// 채은 중개인 정보 출력 추가
	@Override
	public AgentVO agentSelect(String agentId) {
		// TODO Auto-generated method stub
		return ss.selectOne("agent.agentSelect", agentId);
	}
	// 채은 중개인 정보 수정추가
	@Override
	public void agentUpdate(AgentVO agentVO) {
		ss.update("agent.agentUpdate",agentVO);
		
	}

	// 채은 중개인 정보삭제 추가
	@Override
	public void agentInfoDelete(String agentId) {
		ss.delete("agent.agentInfoDelete", agentId);
	}
}
