package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultType;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.vo.AgentVO;
import com.javaclass.vo.UserVO;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SqlSessionTemplate ss;
	
	public void insertUser(UserVO vo){
		ss.insert("user.insertUser", vo);
	}
	
	public void findIdUser(UserVO vo){
		ss.selectOne("user.findIdUser", vo);
	}

	public boolean IdCheck(String checkBeforeId) {
		List<Object> result = ss.selectList("user.idCheck",checkBeforeId);
		if(result == null || result.isEmpty()) {
			// 아이디가 없으면
			return true;
		}else
			// 아이디가 있으면
			return false;
	}

	@Override
	public int Login(String inputId, String inputPass) {
		List<Object> resultId = ss.selectList("user.loginId",inputId);
		List<Object> resultPass = ss.selectList("user.loginPass",inputPass);
		List<Object> resultType = ss.selectList("user.loginType",inputId);
		
		boolean idMatch = resultId.contains(inputId); // 아이디가 일치하는지 확인
	    boolean passMatch = resultPass.contains(inputPass); // 비밀번호가 일치하는지 확인
	    
	    if (idMatch && passMatch) {
	        // 아이디와 비밀번호가 모두 일치하는 경우
	        if(resultType.contains("관리자")) {
	        	return 3;
	        }else if(resultType.contains("중개인")) {
	        	return 2;
	        }else {
	        	return 1;
	        }
	        
	    } else {
	        // 아이디 또는 비밀번호가 일치하지 않는 경우
	        return 0;
	    }
	}
	
	// 계정찾기 - 아이디
	@Override
	public String findAccountId(String inputEmail) {
		String resultId = ss.selectOne("user.findId",inputEmail);
		
		if(resultId == null) {resultId = "없음";}
		
		return resultId;
	}
	
	// 이메일 중복검사
	@Override
	public boolean emailCheck(String checkEmail) {
		List<Object> resultEmail = ss.selectList("user.checkEmail",checkEmail);
		if(resultEmail == null || resultEmail.isEmpty()) {
			// 이메일이 없으면
			return true;
		}else
			// 이메일이 있으면
			return false;
	}
	
	// 계정찾기 - 비밀번호
	@Override
	public boolean findAccountPass(String inputPwId, String inputPwEmail) {
		List<Object> resultId = ss.selectList("user.checkPwId",inputPwId);
		List<Object> resultEmail = ss.selectList("user.checkPwEmail",inputPwEmail);
		
		boolean passIdMatch = resultId.contains(inputPwId); 			// 아이디가 일치하는지 확인
	    boolean passEmailMatch = resultEmail.contains(inputPwEmail); 	// 비밀번호가 일치하는지 확인
	    
		if(passIdMatch && passEmailMatch) {
			System.out.println("비밀번호 찾기 - 아이디와 이메일이 일치합니다.");
			return true;
		}else
	
		return false;
	}
	
	// 계정찾기 - 비밀번호 찾은 후 수정(고객)
	@Override
	public int changeNewUserPassword(String inputNewPw, String rememberId) {
		 Map<String, Object> params = new HashMap<String, Object>();
		 params.put("inputNewPw", inputNewPw);
		 params.put("rememberId", rememberId);
		
		int result = ss.update("user.changeNewUserPass", params);
		return result;
	}
	// 계정찾기 - 비밀번호 찾은 후 수정(중개인)
	@Override
	public int changeNewAgentPassword(String inputNewPw, String rememberId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("inputNewPw", inputNewPw);
		params.put("rememberId", rememberId);
		
		int result = ss.update("user.changeNewAgentPass", params);
		return result;
	}

	@Override
	public UserVO userSelect(String user_id) {
		
		return ss.selectOne("user.userSelect", user_id);
	}

	@Override
	public void userUpdate(UserVO userVO) {
		ss.update("user.userUpdate",userVO);
		
	}

	@Override
	public void userInfoDelete(String user_id) {
		ss.delete("user.userInfoDelete",user_id);
		
	}
}
