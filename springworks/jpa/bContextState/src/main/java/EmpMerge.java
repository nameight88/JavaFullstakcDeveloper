import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpMerge {
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
			//데이터베이스에서의 merge
			//없는 데이터면 insert 이미 있는 값이면 update
			EmpVO emp= new EmpVO();
			emp.setEmpno(6666);
			emp.setEname("홍실이2");
			
			tx.begin();
			em.merge(emp);
			tx.commit();
			/*Hibernate: select empvo0_.empno as empno1_0_0_, empvo0_.comm as comm2_0_0_, empvo0_.deptno as deptno3_0_0_, empvo0_.ename as ename4_0_0_, empvo0_.hiredate as hiredate5_0_0_, empvo0_.job as job6_0_0_, empvo0_.mgr as mgr7_0_0_, empvo0_.sal as sal8_0_0_ from EMP_A empvo0_ where empvo0_.empno=?
				Hibernate: insert into EMP_A (comm, deptno, ename, hiredate, job, mgr, sal, empno) values (?, ?, ?, ?, ?, ?, ?, ?)
			 * select 값으로 먼저 검색을 하고
			 * 없는 값이 들어와서 insery sql문장을 사용을 했다.
			 * 
			 * 값을 등록을 하고나서
			 * Hibernate: select empvo0_.empno as empno1_0_0_, empvo0_.comm as comm2_0_0_, empvo0_.deptno as deptno3_0_0_, empvo0_.ename as ename4_0_0_, empvo0_.hiredate as hiredate5_0_0_, empvo0_.job as job6_0_0_, empvo0_.mgr as mgr7_0_0_, empvo0_.sal as sal8_0_0_ from EMP_A empvo0_ where empvo0_.empno=?
			 * 
			 * 
			 * 이미 있는 값을 수정을 했을때
			 * Hibernate: select empvo0_.empno as empno1_0_0_, empvo0_.comm as comm2_0_0_, empvo0_.deptno as deptno3_0_0_, empvo0_.ename as ename4_0_0_, empvo0_.hiredate as hiredate5_0_0_, empvo0_.job as job6_0_0_, empvo0_.mgr as mgr7_0_0_, empvo0_.sal as sal8_0_0_ from EMP_A empvo0_ where empvo0_.empno=?
				Hibernate: update EMP_A set comm=?, deptno=?, ename=?, hiredate=?, job=?, mgr=?, sal=? where empno=?
			 */
		}catch(Exception e) {
			tx.rollback();
			System.out.println("실패: "+e.getMessage());
		}
	}
}
