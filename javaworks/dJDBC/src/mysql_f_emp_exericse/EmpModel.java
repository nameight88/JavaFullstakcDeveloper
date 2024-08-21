package mysql_f_emp_exericse;
//1. Model class에서 모델 넣을 것들을 전부다 만들어 준다.
//인터페이스 이므로 추상적 모델들이다. 
// 이 모든것들을 오류 처리를 할때 try catch가 아니라 throws로 다 예외처리를 한다.
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpModel {
	// insert() :  입력한 값 받아서 데이타베이스에 추가
	public void insert( EmpVO r ) throws SQLException;
	
	// modify() : 화면 입력값 받아서 수정
	public void modify( EmpVO r ) throws SQLException;
	
	// selectByEmpno() :  입력받은 사번을 받아서 해당 레코드 검색
	public EmpVO selectByEmpno( int empno ) throws SQLException;
	
	// delete() : 사원번호 값을 받아 해당 레코드 삭제
	public int delete( int empno ) throws SQLException;
	
	// selectAll() :  전체 레코드 검색
	public ArrayList selectAll() throws SQLException;
	
	//버튼들의 역할을 인터페이스로 추상적인 모델을 설정을 해준다.
}
