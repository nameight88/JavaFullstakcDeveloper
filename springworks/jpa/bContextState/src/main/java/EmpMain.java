import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpMain {
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
		//[1] �˻�
			EmpVO emp0 = em.find(EmpVO.class, 9999);
			System.out.println("�˻� ���: "+emp0.toString());
			
//			���� ���� ������ ���� null ������ ��ȯ�� �ؼ� catch���� ����� ���ش�.
//			EmpVO emp1 = em.find(EmpVO.class, 8888);
//			System.out.println("�˻� ���: "+emp1.toString());
			
		//[2] �˻�
			EmpVO emp2 = em.find(EmpVO.class ,9999);
			System.out.println("�˻� ���: "+emp2.toString());
		if(emp0 == emp2 )System.out.println("���ϰ�ü");
		else System.out.println("�ٸ���ü");
		//[0] �� �ϱ� ���� ����� ����
		EmpVO emp = new EmpVO();
		emp.setEmpno(8888);
		emp.setEname("�ͱ浿");
		
		tx.begin();
		em.persist(emp);
		tx.commit();
		
		EmpVO emp1 = em.find(EmpVO.class, 8888);
		System.out.println("�˻� ���: "+emp1.toString());
		//������ ���۵��� �ѹ��� �θ����� �ٸ� ��ü���� select �� �ѹ����Ἥ �����ش�.
		//SQL ������ �ڹ� ��ü�� �������� persist �� ���۸� ���ָ� jpa���� �ִ� context
		//�������� �ڵ����� ������ ���ش�.
		}catch(Exception e) {
			tx.rollback();
			System.out.println("����: "+e.getMessage());
		}
	}
}
