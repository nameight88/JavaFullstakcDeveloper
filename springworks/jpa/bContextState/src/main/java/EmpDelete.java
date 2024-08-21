import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpDelete {
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
			
			EmpVO emp = em.find(EmpVO.class, 9999);
			//삭제와 수정을 할려면 먼저 리스트 전체의 값을 가져와서 수정과 삭제를 만들어야한다.
			
			tx.begin();
			em.remove(emp);
			tx.commit();
			
			//select문으로 먼저 값을 검색을 하고 그 이후에 delete문을 이용을 해서 삭제
		}catch(Exception e) {
			tx.rollback();
			System.out.println("실패: "+e.getMessage());
		}
	}
}
