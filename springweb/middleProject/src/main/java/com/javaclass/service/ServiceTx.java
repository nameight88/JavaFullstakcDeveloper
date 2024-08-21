package com.javaclass.service;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;

import com.javaclass.vo.AgentVO;
import com.javaclass.vo.ReservationVO;
import com.javaclass.vo.UserVO;


public interface ServiceTx {
	public void addAll(UserVO uvo) throws Exception;
	
	public void addAll2(AgentVO avo) throws Exception;

	public void findIdUser(UserVO uvo) throws Exception;

	public boolean IdCheck(String checkBeforeId) throws Exception;

	public int Login(String inputId, String inputPass)throws Exception;

	public String findAccountId(String inputEmail)throws Exception;

	public boolean emailCheck(String checkEmail)throws Exception;

	public boolean findAccountPass(String inputPwId, String inputPwEmail)throws Exception;

	public int changeNewUserPassword(String inputNewPw, String rememberId)throws Exception;

	public int changeNewAgentPassword(String inputNewPw, String rememberId)throws Exception;
	
	
	// 채은 중개인 정보 추가
	public AgentVO agentSelect(String agentId);
	
	// 채은 중개인 정보 수정 추가
	public void agentUpdate(AgentVO agentVO);
	
	// 채은 중개인 정보 삭제 추가
	public void agentInfoDelete(String agentId);
	
	
	// ----- 기진 추가
	public void insertReservation(ReservationVO formData)throws Exception;

	public List<ReservationVO> selectReservedTime(String reservation_date, String agent_id)throws Exception;
	
	
	
	// 채은 사용자 정보 출력 추가
	public UserVO userSelect(String user_id);
	// 채은 사용자 정보 수정 추가
	public void userUpdate(UserVO userVO);
	// 채은 사용자 정보 삭제 추가
	public void userInfoDelete(String user_id);
	
	
	

}
