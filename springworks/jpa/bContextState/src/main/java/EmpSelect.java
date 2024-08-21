import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpSelect {
	public static void main(String[] args) {
		//persist의 역할은 생성한 자바 객체 entity를 Psistence Context 라는 영역
		// 안쪽으로 전송을 해주고 그 이후에 입력 저장 검색 등의 기능은 Psistence Context 라는 영역
		// 안에서 다 해결이 된다.
		
		
		//1. entity manerger factory 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bContextState");
		//
		
		//2. 엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
		
		
		//4.엔티티 트랙잰션 필요
		EntityTransaction tx = em.getTransaction();
		try {
		//[1] find()를 이용한 검색
//			EmpVO emp0 = em.find(EmpVO.class, 9999);
//			System.out.println("검색 결과: "+emp0.toString());
			
//			EmpVO emp1 = em.find(EmpVO.class, 3333);
//			System.out.println("검색 결과: "+emp1.toString());
			
			//[2] getReference를 이용한 검색
//			EmpVO emp2=em.getReference(EmpVO.class, 9999);
//			System.out.println("검색결과: "+emp2.toString());
			//find()를 이용 했을때 처럼 똑같은 결과가 나온다.
			// 근데 위에서 emp0을 주석 처리를 안했을때 select 함수가 만들어진것을 이용을 찾는다.
			
//			EmpVO emp1 = em.getReference(EmpVO.class, 3333);
//			System.out.println("검색 결과: "+emp1.toString());
			
			
			//**********************************************************************
			// JPQL (Java Persistence Query Language)
			// ******* 주의 *************************
			// 실제로 SQL문장이 아님
			//      테이블 명이 아니라 클래스명을 기준으로 한다. (대소문자 구별)
			//		문법을 사용을 할때 SQL구문으로 날리는 것이 아닌 자바 클래스로 나가는 것이기 때문에
			// 		대소문자를 구분을 해서 사용을 해야한다.
			// [SQL] SELECT * FROM emp_a ORDER BY empno DESC;
			String jpql = "SELECT e FROM EmpVO e ORDER BY e.empno DESC";//여기서 SQL문장처럼이 쓰면 안된다. 
			List<EmpVO> list =em.createQuery(jpql,EmpVO.class).getResultList();
			for(EmpVO vo : list) {
				System.out.println(">>>"+vo.toString());
			}
		}catch(Exception e) {
			tx.rollback();
			System.out.println("실패: "+e.getMessage());
		}
	}
}
