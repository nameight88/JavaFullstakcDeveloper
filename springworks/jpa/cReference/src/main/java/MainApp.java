import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.javassem.domain.Department;
import com.javassem.domain.Employee;

public class MainApp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cReference");
		
		try {
//			insertDate(emf); 입력
//			selectData(emf); 조회
//			modifyData(emf); 수정
//			deleteData(emf); 삭제
			
			// OneToMany 검색
			selectOneToMany(emf);
		}catch(Exception e) {
			System.out.println("실패:" +e.getMessage());
		}
		
	}
	static void selectOneToMany(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		Department dept = em.find(Department.class,30);
//		System.out.println("부서명"+dept.getDanme());
//		--> toString()사용 금지
//		System.out.println("부서정보:"+dept.toString());
		
		List<Employee> emp_list = dept.getEmpList();
		for(Employee e : emp_list) {
			System.out.println(e.getEname());
		}
		em.close();
	}
	
	static void deleteData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//40번 부서를 삭제한다면?
//		Department dept2 = em.find(Department.class, 40);
//		em.remove(dept2);
		//fk로 인해서 삭제가 불가능하다.
		
		//부서에 대한 fk관계를 제거후 삭제를 해야한다.
//		Department dept2 = em.find(Department.class, 80);
//		Employee e1 = em.find(Employee.class,7657);
//		System.out.println(e1.toString());
//		e1.setDept(null);
//		em.remove(dept2);
		
		//CASCADE :영속성전이
		Department dept2 = em.find(Department.class, 60);
		em.remove(dept2);
		tx.commit();
		em.close();
	}// end of deleteData
	
	
	static void modifyData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3902사번의 사원정보를 출력
		Employee e1 = em.find(Employee.class, 7521);
//		System.out.println("사원 정보: "+e1.toString());
		
		//40번 부서로 변경할려면
	
		Department d1 = em.find(Department.class, 40);

		e1.setDept(d1);
//		em.persist(e1); 이미 관리 영역 상태에 들어온 상태이므로 없어도 상관이 없다.
		tx.commit();
		em.close();
	}//end of modifyData
	
	
	
	static void selectData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		Employee emp1 = em.find(Employee.class,5555);
//		System.out.println("정보"+emp1.getEname());
		System.out.println("정보"+emp1.getEname()+"부서:"+emp1.getDept().getDanme());
	}
	static void insertDate(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//-------------
		// [1]사원정보 입력 -- 부서 번호가 없는 경우
//		Employee emp1 = new Employee();
//		emp1.setEmpno(9554);
//		emp1.setEname("강다윗");
//		emp1.setJob("성욱이형 동생되기");
//		emp1.setDeptno(60);
//		em.persist(emp1);
		
		//[2] 부서번호입력 - 자동증가함수라면(가정)
		//[3] 부서정보와 사원을 같이 입력을 했을 경우
//		Department dept1 = new Department();
//		dept1.setDeptno(80);
//		dept1.setDanme("운영팀");
//		dept1.setLoc("신촌");
//		em.persist(dept1);
//		
//		Employee emp2 = new Employee();
//		emp2.setEmpno(7657);
//		emp2.setEname("맹구");
//		emp2.setDept(dept1);
//		em.persist(emp2);
		//insert sql문장이 2번 실행
		
		
		//[4]
		// 기존에 있는 40분 부서의 직원으로 등록을 하고 싶으면
//		Employee emp3 = new Employee();
//		Department dept2 = em.find(Department.class, 40);
//		emp3.setDept(dept2)
		
//		emp3.setEmpno(58746);
//		emp3.setDept(em.find(Department.class, 40));
//		emp3.setEname("맹맹이");
//		em.persist(emp3);
//		tx.commit();
		em.close();
	}//end of insertDate
}
