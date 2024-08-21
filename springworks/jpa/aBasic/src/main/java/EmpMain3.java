import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO2;
import com.javassem.domain.EmpVO3;

public class EmpMain3 {
	public static void main(String[] args) {
		//1. entity manerger factory ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aBasic");
		//
		
		//2. ��ƼƼ �Ŵ��� ����
		EntityManager em = emf.createEntityManager();
		
		
		//4.��ƼƼ Ʈ����� �ʿ�
		EntityTransaction tx = em.getTransaction();
		try {
			//3.��ƼƼ ����
			EmpVO3 emp = new EmpVO3();
			
//			emp.setEmpno(6666); �ڵ������Լ��� ���������� �ּ�ó���� ���־���Ѵ�.
			emp.setEname("ȫ�浿");
//			emp.setJob("������");
			emp.setHiredate(new Date());
			emp.setDeptno(88);
			emp.setSal(1000);
			tx.begin();
			em.persist(emp);
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
			System.out.println("����: "+e.getMessage());
		}
	}
}
