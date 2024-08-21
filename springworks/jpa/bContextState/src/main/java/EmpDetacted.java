import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpDetacted {
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
			// 엔티티 컨테이너에 있는 상태 (Managed 상태)
			EmpVO emp1 = em.find(EmpVO.class,8888);
			System.out.println("검색결과: "+emp1.toString());
			
			tx.begin();
			emp1.setEname("홍홍이로변경2");
			tx.commit();
			//emp 객체에 em.find로 프라이 머리 키를 찾아서
			//JPA가 자동으로 select문을 이용을해서 값을 찾고
			// 그것을 자동으로 update 문장을 생성을 해서
			// 값을 바꾸고 커밋을 했다.
			
			tx.begin();
			em.detach(emp1);//잠시 관리 대상에서 벗어나는 기능을 해준다.
			// detach는 수업에서는 잘 안쓰이지만 파이널때 쓰고 싶으면 찾아서 더 공부를 해야한다.
			emp1.setEname("홍돌이");
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			System.out.println("실패: "+e.getMessage());
		}
	}
}
