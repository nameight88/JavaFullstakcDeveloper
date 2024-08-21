import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.DeptVO;

public class DeptMain {

	public static void main(String[] args) {
		//1) entity manager와 factory를 생성
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("zTest");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx =em.getTransaction();
		
		try {
			DeptVO vo = new DeptVO();
			vo.setDeptno(1000);
			vo.setDname("IT");
			vo.setLoc("신촌");
			
			tx.begin(); //트랜잭션 처리를 해준다.
			em.persist(vo); //insert,delete,update
			tx.commit();
		}catch(Exception e) {
			System.out.println("실패: "+e.getMessage());
		}
		
	}

}
