import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpMerge {
	public static void main(String[] args) {
		//persist�� ������ ������ �ڹ� ��ü entity�� Psistence Context ��� ����
		// �������� ������ ���ְ� �� ���Ŀ� �Է� ���� �˻� ���� ����� Psistence Context ��� ����
		// �ȿ��� �� �ذ��� �ȴ�.
		
		
		//1. entity manerger factory ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bContextState");
		//
		
		//2. ��ƼƼ �Ŵ��� ����
		EntityManager em = emf.createEntityManager();
		
		
		//4.��ƼƼ Ʈ����� �ʿ�
		EntityTransaction tx = em.getTransaction();
		try {
			//�����ͺ��̽������� merge
			//���� �����͸� insert �̹� �ִ� ���̸� update
			EmpVO emp= new EmpVO();
			emp.setEmpno(6666);
			emp.setEname("ȫ����2");
			
			tx.begin();
			em.merge(emp);
			tx.commit();
			/*Hibernate: select empvo0_.empno as empno1_0_0_, empvo0_.comm as comm2_0_0_, empvo0_.deptno as deptno3_0_0_, empvo0_.ename as ename4_0_0_, empvo0_.hiredate as hiredate5_0_0_, empvo0_.job as job6_0_0_, empvo0_.mgr as mgr7_0_0_, empvo0_.sal as sal8_0_0_ from EMP_A empvo0_ where empvo0_.empno=?
				Hibernate: insert into EMP_A (comm, deptno, ename, hiredate, job, mgr, sal, empno) values (?, ?, ?, ?, ?, ?, ?, ?)
			 * select ������ ���� �˻��� �ϰ�
			 * ���� ���� ���ͼ� insery sql������ ����� �ߴ�.
			 * 
			 * ���� ����� �ϰ���
			 * Hibernate: select empvo0_.empno as empno1_0_0_, empvo0_.comm as comm2_0_0_, empvo0_.deptno as deptno3_0_0_, empvo0_.ename as ename4_0_0_, empvo0_.hiredate as hiredate5_0_0_, empvo0_.job as job6_0_0_, empvo0_.mgr as mgr7_0_0_, empvo0_.sal as sal8_0_0_ from EMP_A empvo0_ where empvo0_.empno=?
			 * 
			 * 
			 * �̹� �ִ� ���� ������ ������
			 * Hibernate: select empvo0_.empno as empno1_0_0_, empvo0_.comm as comm2_0_0_, empvo0_.deptno as deptno3_0_0_, empvo0_.ename as ename4_0_0_, empvo0_.hiredate as hiredate5_0_0_, empvo0_.job as job6_0_0_, empvo0_.mgr as mgr7_0_0_, empvo0_.sal as sal8_0_0_ from EMP_A empvo0_ where empvo0_.empno=?
				Hibernate: update EMP_A set comm=?, deptno=?, ename=?, hiredate=?, job=?, mgr=?, sal=? where empno=?
			 */
		}catch(Exception e) {
			tx.rollback();
			System.out.println("����: "+e.getMessage());
		}
	}
}
