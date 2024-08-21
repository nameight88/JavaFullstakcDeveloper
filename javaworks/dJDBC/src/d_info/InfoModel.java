package d_info;

import java.util.ArrayList;

public interface InfoModel {

	/*
	 *   함수명 : insertData
	 *   인자값 :
	 *   리턴값 :
	 *   역  할 : 회원가입하는 입력값을 받아서 데이타베이스에 저장
	 */
	void insertData(InfoVO vo) throws Exception;
	
	/*
	 * 함수명 : 
	 * 인자   :  
	 * 리턴값 : 
	 * 역할	  : 전화번호를 입력받아 해당 고객의 정보를 찾아서 반환
	 */
	InfoVO searchByTel(String tel) throws Exception;
	
	/*
	 *  
	 */
	ArrayList<InfoVO> searchAll() throws Exception;
	
	
	void deleteData(String tel) throws Exception;
	
	
	void modifyData(InfoVO vo) throws Exception;
	
	
}
