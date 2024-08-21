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
			System.out.println("���ܹ߻�"+e.getMessage());
//			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
	static void selectData(EntityManagerFactory emf) {
		EntityManager em =emf.createEntityManager();
		
		//����Ƽ�� ���� : ��¥ DB�� SQL(jpql) �ƴ�
		
		String sql = "SELECT * FROM emp WHERE deptno=:dept_no";
		Query query = em.createNativeQuery(sql,Employee.class);
		query.setParameter("dept_no", 30);
		List<Employee> list = query.getResultList();
		for(Employee e :list) {
			System.out.println(e.getEname()+"��"+e.getDept().getDname());
			//toString ����
		}
		em.close();

		}
	}

