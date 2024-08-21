import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.javaclass.domain.Board;
import com.javaclass.domain.Department;
import com.javaclass.domain.Employee;

public class MainApp3_join {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dJpql");

		EntityManager em = emf.createEntityManager();

		try {
			selectData(emf);
		}
		catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
//			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}

	}

	static void selectData(EntityManagerFactory emf) {
		EntityManager em =emf.createEntityManager();
		
		//묵시적 조인
//		String jpql = " SELECT e, e.dept FROM EMP e ";
		
		//명시적 조인
//		String jpql =" SELECT e,d FROM EMP e INNER JOIN e.dept d ";
//		Query query = em.createQuery(jpql);
//		List<Object[]> list = query.getResultList();
////		System.out.println(list);
//		for(Object[] result : list) {
//			System.out.println(">"+((Employee)result[0]).getEname());
//			System.out.println(">>>"+((Department)result[1]).getDname());
//		}
		
		
		// 부서명으로 정렬
		String jpql = " SELECT e, d FROM EMP e INNER JOIN e.dept d ORDER BY e.dept.dname DESC ";
		Query query = em.createQuery(jpql);
		List<Object[]> list = query.getResultList();
		for(Object[] result : list) {
			System.out.println(">"+((Employee)result[0]).getEname());
			System.out.println(">>>"+((Department)result[1]).getDname());
		}
		em.close();

		}
	}

