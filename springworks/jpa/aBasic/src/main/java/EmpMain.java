import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpMain {
	public static void main(String[] args) {
		//1. entity manerger factory 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aBasic");
		//
		
		//2. 엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
		
		
		//4.엔티티 트랙잰션 필요
		EntityTransaction tx = em.getTransaction();
		try {
			//3.엔티티 생성
			EmpVO emp = new EmpVO();
			emp.setEmpno(9999);
			emp.setEname("홍길순");
			emp.setJob("개발자");
			emp.setHiredate(new Date());
			emp.setDeptno(88);
			
			tx.begin();
			em.persist(emp);
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
			System.out.println("실패: "+e.getMessage());
		}
	}
}
