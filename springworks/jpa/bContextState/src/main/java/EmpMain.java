import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpMain {
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
		//[1] 검색
			EmpVO emp0 = em.find(EmpVO.class, 9999);
			System.out.println("검색 결과: "+emp0.toString());
			
//			없는 값을 가지고 오면 null 값으로 반환을 해서 catch에서 출력을 해준다.
//			EmpVO emp1 = em.find(EmpVO.class, 8888);
//			System.out.println("검색 결과: "+emp1.toString());
			
		//[2] 검색
			EmpVO emp2 = em.find(EmpVO.class ,9999);
			System.out.println("검색 결과: "+emp2.toString());
		if(emp0 == emp2 )System.out.println("동일객체");
		else System.out.println("다른객체");
		//[0] 비교 하기 위한 대상을 생성
		EmpVO emp = new EmpVO();
		emp.setEmpno(8888);
		emp.setEname("맹길동");
		
		tx.begin();
		em.persist(emp);
		tx.commit();
		
		EmpVO emp1 = em.find(EmpVO.class, 8888);
		System.out.println("검색 결과: "+emp1.toString());
		//동일한 동작들은 한번만 부르고나서 다른 객체여도 select 를 한번만써서 보여준다.
		//SQL 문장을 자바 객체를 생성에서 persist 로 전송만 해주면 jpa내에 있는 context
		//공간에서 자동으로 관리를 해준다.
		}catch(Exception e) {
			tx.rollback();
			System.out.println("실패: "+e.getMessage());
		}
	}
}
