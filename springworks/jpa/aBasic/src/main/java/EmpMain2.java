import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO2;

public class EmpMain2 {
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
			EmpVO2 emp = new EmpVO2();
			emp.setEmpno(6666);
			emp.setEname("홍길동");
//			emp.setJob("개발자");
			emp.setHiredate(new Date());
			emp.setDeptno(99);
			emp.setSal(1000);
			tx.begin();
			em.persist(emp);
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
			System.out.println("실패: "+e.getMessage());
		}
	}
}
