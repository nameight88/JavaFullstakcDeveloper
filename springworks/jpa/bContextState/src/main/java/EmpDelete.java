import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO;

public class EmpDelete {
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
			
			EmpVO emp = em.find(EmpVO.class, 9999);
			//������ ������ �ҷ��� ���� ����Ʈ ��ü�� ���� �����ͼ� ������ ������ �������Ѵ�.
			
			tx.begin();
			em.remove(emp);
			tx.commit();
			
			//select������ ���� ���� �˻��� �ϰ� �� ���Ŀ� delete���� �̿��� �ؼ� ����
		}catch(Exception e) {
			tx.rollback();
			System.out.println("����: "+e.getMessage());
		}
	}
}
