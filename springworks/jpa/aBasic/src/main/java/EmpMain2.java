import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.EmpVO2;

public class EmpMain2 {
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
			EmpVO2 emp = new EmpVO2();
			emp.setEmpno(6666);
			emp.setEname("ȫ�浿");
//			emp.setJob("������");
			emp.setHiredate(new Date());
			emp.setDeptno(99);
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
