import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.javaclass.domain.Board;

public class MainApp2_parameter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dJpql");

		EntityManager em = emf.createEntityManager();

		try {
			selectData(emf);
		}
		catch (Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}

	}

	static void selectData(EntityManagerFactory emf) {
		EntityManager em =emf.createEntityManager();

		//positional binding
//		String jpql = "SELECT seq,title,writer "
//				+ "  FROM Board "
//				+ "  WHERE seq=?1 ";
//		Query query = em.createQuery(jpql);
//		// �Ķ���� ����
//		query.setParameter(1, 4);//1���� ���� 4�� ���ڵ带 �����´�.
//		query.setParameter(2, "����4");
//		List<Object[]> list =  query.getResultList();
		
		//keyword binding
		String jpql = "SELECT seq,title,writer "
				+ "  FROM Board "
				+ "  WHERE seq=:kwseq AND title=:kwtitle ";
		Query query = em.createQuery(jpql);
		// �Ķ���� ����
		query.setParameter("kwseq", 4);//1���� ���� 4�� ���ڵ带 �����´�.
		query.setParameter("kwtitle", "����4");
		List<Object[]> list =  query.getResultList();
		for(Object[]result :list){

			System.out.println(">>>" +Arrays.toString(result));

		}
	}
}
