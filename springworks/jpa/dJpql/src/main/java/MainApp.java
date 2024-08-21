import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.javaclass.domain.Board;

public class MainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dJpql");
		
		EntityManager em = emf.createEntityManager();
		
		try {
			//[1]jpql
			// ******* ���� SQL������ �ƴϱ⿡
			// ���̺���� �ƴ� Ŭ������ ���
			//(��ҹ��ڸ� �����Ѵ�.)
//			String jpql = "SELECT b FROM Board AS b";
//			TypedQuery<Board> query=em.createQuery(jpql,Board.class);
//			List<Board> list =query.getResultList();
//			for(Board vo:list) {
//				System.out.println(vo.toString());
//			}
			
			
			//Ư�� �÷��� �˻�
			String jpql = "SELECT seq,title,writer FROM Board";
			Query query = em.createQuery(jpql);
			List<Object[]> list =  query.getResultList();
			for(Object[]result :list){
//				System.out.println(">>>" +result);
				System.out.println(">>>" +Arrays.toString(result));
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}

	}

}
