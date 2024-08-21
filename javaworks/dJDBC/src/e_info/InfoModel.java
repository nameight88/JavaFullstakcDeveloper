package e_info;
import java.util.*;
// 다른 프로그램의 확장성을 대비해서 인터페이스를 만들어두는 습관이 중요하다
public interface InfoModel {

	/*
	 *   함수명 : insertData
	 *   인자값 :
	 *   리턴값 :
	 *   역  할 : 회원가입하는 입력값을 받아서 데이타베이스에 저장
	 */
	void insertData(InfoVo vo) throws Exception;	
	/*
	 * 함수명
	 * 인자
	 * 리턴값
	 * 역할 : 전화번호를 입력 받아 해당 고객의 정보를 찾아서 반환
	 */
	InfoVo searchByTel(String tel) throws Exception;
	
	/*
	 * 
	 * 
	 * 
	 */
	ArrayList<InfoVo> searchALL() throws Exception;
	
	
	void deleteData(String tel) throws Exception;
	
	void modifyData(InfoVo vo) throws Exception;	
	
}
