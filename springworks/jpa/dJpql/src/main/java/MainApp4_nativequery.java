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

public class MainApp4_nativequery {

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
		
		//네이티브 쿼리 : 진짜 DB의 SQL(jpql) 아님
		
		String sql = "SELECT * FROM emp WHERE deptno=:dept_no";
		Query query = em.createNativeQuery(sql,Employee.class);
		query.setParameter("dept_no", 30);
		List<Employee> list = query.getResultList();
		for(Employee e :list) {
			System.out.println(e.getEname()+"님"+e.getDept().getDname());
			//toString 금지
		}
		em.close();

		}
	}

