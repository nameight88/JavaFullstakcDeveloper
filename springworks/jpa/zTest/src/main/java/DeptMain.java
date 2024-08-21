import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.DeptVO;

public class DeptMain {

	public static void main(String[] args) {
		//1) entity manager�� factory�� ����
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("zTest");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx =em.getTransaction();
		
		try {
			DeptVO vo = new DeptVO();
			vo.setDeptno(1000);
			vo.setDname("IT");
			vo.setLoc("����");
			
			tx.begin(); //Ʈ����� ó���� ���ش�.
			em.persist(vo); //insert,delete,update
			tx.commit();
		}catch(Exception e) {
			System.out.println("����: "+e.getMessage());
		}
		
	}

}
