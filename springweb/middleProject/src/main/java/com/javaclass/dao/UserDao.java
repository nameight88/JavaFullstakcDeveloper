package com.javaclass.dao;

import com.javaclass.vo.UserVO; 

public interface UserDao {
	public void insertUser(UserVO vo);

	public void findIdUser(UserVO vo);

	public boolean IdCheck(String checkBeforeId);

	public int Login(String inputId, String inputPass);

	public String findAccountId(String inputEmail);

	public boolean emailCheck(String checkEmail);

	public boolean findAccountPass(String inputPwId, String inputPwEmail);

	public int changeNewUserPassword(String inputNewPw, String rememberId);

	public int changeNewAgentPassword(String inputNewPw, String rememberId);


	// 채은 사용자 정보 출력 추가
	public UserVO userSelect(String user_id);
	// 채은 사용자 정보 수정 추가
	public void userUpdate(UserVO userVO);
	// 채은 사용자 정보 삭제 추가
	public void userInfoDelete(String user_id);
}
