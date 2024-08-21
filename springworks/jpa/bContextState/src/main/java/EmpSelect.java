import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpSelect {
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
		//[1] find()�� �̿��� �˻�
//			EmpVO emp0 = em.find(EmpVO.class, 9999);
//			System.out.println("�˻� ���: "+emp0.toString());
			
//			EmpVO emp1 = em.find(EmpVO.class, 3333);
//			System.out.println("�˻� ���: "+emp1.toString());
			
			//[2] getReference�� �̿��� �˻�
//			EmpVO emp2=em.getReference(EmpVO.class, 9999);
//			System.out.println("�˻����: "+emp2.toString());
			//find()�� �̿� ������ ó�� �Ȱ��� ����� ���´�.
			// �ٵ� ������ emp0�� �ּ� ó���� �������� select �Լ��� ����������� �̿��� ã�´�.
			
//			EmpVO emp1 = em.getReference(EmpVO.class, 3333);
//			System.out.println("�˻� ���: "+emp1.toString());
			
			
			//**********************************************************************
			// JPQL (Java Persistence Query Language)
			// ******* ���� *************************
			// ������ SQL������ �ƴ�
			//      ���̺� ���� �ƴ϶� Ŭ�������� �������� �Ѵ�. (��ҹ��� ����)
			//		������ ����� �Ҷ� SQL�������� ������ ���� �ƴ� �ڹ� Ŭ������ ������ ���̱� ������
			// 		��ҹ��ڸ� ������ �ؼ� ����� �ؾ��Ѵ�.
			// [SQL] SELECT * FROM emp_a ORDER BY empno DESC;
			String jpql = "SELECT e FROM EmpVO e ORDER BY e.empno DESC";//���⼭ SQL����ó���� ���� �ȵȴ�. 
			List<EmpVO> list =em.createQuery(jpql,EmpVO.class).getResultList();
			for(EmpVO vo : list) {
				System.out.println(">>>"+vo.toString());
			}
		}catch(Exception e) {
			tx.rollback();
			System.out.println("����: "+e.getMessage());
		}
	}
}
