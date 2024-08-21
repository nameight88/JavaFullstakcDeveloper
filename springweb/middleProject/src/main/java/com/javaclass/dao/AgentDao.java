package com.javaclass.dao;

import com.javaclass.vo.AgentVO; 

public interface AgentDao {
	public void insertAgent(AgentVO vo);

	// 채은 중개인 정보 추가
	public AgentVO agentSelect(String agentId);

	// 채은 중개인 정보 수정 추가
	public void agentUpdate(AgentVO agentVO);
	
	// 채은 중개인 정보 삭제 추가
	public void agentInfoDelete(String agentId);


}
