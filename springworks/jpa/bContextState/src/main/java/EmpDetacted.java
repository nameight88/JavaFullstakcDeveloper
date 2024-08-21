import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpDetacted {
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
			// ��ƼƼ �����̳ʿ� �ִ� ���� (Managed ����)
			EmpVO emp1 = em.find(EmpVO.class,8888);
			System.out.println("�˻����: "+emp1.toString());
			
			tx.begin();
			emp1.setEname("ȫȫ�̷κ���2");
			tx.commit();
			//emp ��ü�� em.find�� ������ �Ӹ� Ű�� ã�Ƽ�
			//JPA�� �ڵ����� select���� �̿����ؼ� ���� ã��
			// �װ��� �ڵ����� update ������ ������ �ؼ�
			// ���� �ٲٰ� Ŀ���� �ߴ�.
			
			tx.begin();
			em.detach(emp1);//��� ���� ��󿡼� ����� ����� ���ش�.
			// detach�� ���������� �� �Ⱦ������� ���̳ζ� ���� ������ ã�Ƽ� �� ���θ� �ؾ��Ѵ�.
			emp1.setEname("ȫ����");
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			System.out.println("����: "+e.getMessage());
		}
	}
}
