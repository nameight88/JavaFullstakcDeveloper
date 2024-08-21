package com.javaclass.service;


import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaclass.dao.AgentDao;
import com.javaclass.dao.ReservationDao;
import com.javaclass.dao.UserDao;
import com.javaclass.vo.AgentVO;
import com.javaclass.vo.ReservationVO;
import com.javaclass.vo.UserVO;


@Service
public class ServiceTxImpl implements ServiceTx{

	@Autowired
	private UserDao udao;

	@Autowired
	private AgentDao adao;
	
	@Autowired
	private ReservationDao rdao;

	//고객 관련 함수 -----------------------------------------------------
	// 회원가입 - 고객정보 입력
	@Override
	public void addAll(UserVO uvo) throws Exception {
		udao.insertUser(uvo);
	}

	// 아이디 찾기 - 고객정보 출력
	@Override
	public void findIdUser(UserVO uvo) throws Exception {
		udao.findIdUser(uvo);
	}

	// 아이디 중복 확인
	@Override
	public boolean IdCheck(String checkBeforeId) throws Exception {

		boolean result = udao.IdCheck(checkBeforeId);
		return result;	
	}

	// 이메일 중복 확인
	@Override
	public boolean emailCheck(String checkEmail) throws Exception {
		boolean result = udao.emailCheck(checkEmail);
		return result;
	}


	// 중개인 관련 함수 -----------------------------------------------------
	// 회원가입 - 중개인정보 입력
	@Override
	public void addAll2(AgentVO avo) throws Exception {
		adao.insertAgent(avo);
		
	}

	// 공통 이벤트 ----------------------------------------------------------
	// 로그인
	@Override
	public int Login(String inputId, String inputPass) throws Exception {
		int result = udao.Login(inputId,inputPass);
		return result;
	}

	// 계정 찾기 - 아이디
	@Override
	public String findAccountId(String inputEmail) throws Exception {
		String result = udao.findAccountId(inputEmail);
		
		return result;
	}

	// 계정 찾기 - 비밀번호
	@Override
	public boolean findAccountPass(String inputPwId, String inputPwEmail) {
		boolean result = udao.findAccountPass(inputPwId,inputPwEmail);
		return result;
	}

	// 계정 찾기 - 비밀번호 찾기 후 수정(고객)
	@Override
	public int changeNewUserPassword(String inputNewPw,String rememberId) throws Exception {
		int result = udao.changeNewUserPassword(inputNewPw, rememberId);
		return result;
	}

	// 계정 찾기 - 비밀번호 찾기 후 수정(중개인)
	@Override
	public int changeNewAgentPassword(String inputNewPw, String rememberId) throws Exception {
		int result = udao.changeNewAgentPassword(inputNewPw, rememberId);
		return result;
	}

	// 채은 중개인 정보 출력 추가
	@Override
	public AgentVO agentSelect(String agentId) {
		AgentVO agentInfo = adao.agentSelect(agentId);
		return agentInfo;
	}
	// 채은 중개인 정보 수정 추가
	@Override
	public void agentUpdate(AgentVO agentVO) {
		adao.agentUpdate(agentVO);

	}
	// 채은 중개인 정보 삭제 추가
	@Override
	public void agentInfoDelete(String agentId) {
		adao.agentInfoDelete(agentId);
	}

	// 기진추가
	// 예약 관련 함수 -------------------------------------------------------------------- 
	// 중개인 매물 예약 - 비밀번호 찾기 후 수정(중개인)
	@Override
	public void insertReservation(ReservationVO formData) throws Exception {
		rdao.insertReservation(formData);

	}

	// 중개인의 예약시간 출력 - (해당 중개인)
	@Override
	public List<ReservationVO> selectReservedTime(String reservation_date, String agent_id) throws Exception {
		List<ReservationVO> result = rdao.selectReservedTime(reservation_date ,agent_id);
		return result;
	}

	@Override
	public UserVO userSelect(String user_id) {
		
		return udao.userSelect(user_id);
	}

	@Override
	public void userUpdate(UserVO userVO) {
		udao.userUpdate(userVO);
		
	}

	@Override
	public void userInfoDelete(String user_id) {
		udao.userInfoDelete(user_id);
		
	}



}
