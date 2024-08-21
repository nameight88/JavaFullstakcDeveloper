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
//			insertDate(emf); �Է�
//			selectData(emf); ��ȸ
//			modifyData(emf); ����
//			deleteData(emf); ����
			
			// OneToMany �˻�
			selectOneToMany(emf);
		}catch(Exception e) {
			System.out.println("����:" +e.getMessage());
		}
		
	}
	static void selectOneToMany(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		Department dept = em.find(Department.class,30);
//		System.out.println("�μ���"+dept.getDanme());
//		--> toString()��� ����
//		System.out.println("�μ�����:"+dept.toString());
		
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
		
		//40�� �μ��� �����Ѵٸ�?
//		Department dept2 = em.find(Department.class, 40);
//		em.remove(dept2);
		//fk�� ���ؼ� ������ �Ұ����ϴ�.
		
		//�μ��� ���� fk���踦 ������ ������ �ؾ��Ѵ�.
//		Department dept2 = em.find(Department.class, 80);
//		Employee e1 = em.find(Employee.class,7657);
//		System.out.println(e1.toString());
//		e1.setDept(null);
//		em.remove(dept2);
		
		//CASCADE :���Ӽ�����
		Department dept2 = em.find(Department.class, 60);
		em.remove(dept2);
		tx.commit();
		em.close();
	}// end of deleteData
	
	
	static void modifyData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//3902����� ��������� ���
		Employee e1 = em.find(Employee.class, 7521);
//		System.out.println("��� ����: "+e1.toString());
		
		//40�� �μ��� �����ҷ���
	
		Department d1 = em.find(Department.class, 40);

		e1.setDept(d1);
//		em.persist(e1); �̹� ���� ���� ���¿� ���� �����̹Ƿ� ��� ����� ����.
		tx.commit();
		em.close();
	}//end of modifyData
	
	
	
	static void selectData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		Employee emp1 = em.find(Employee.class,5555);
//		System.out.println("����"+emp1.getEname());
		System.out.println("����"+emp1.getEname()+"�μ�:"+emp1.getDept().getDanme());
	}
	static void insertDate(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//-------------
		// [1]������� �Է� -- �μ� ��ȣ�� ���� ���
//		Employee emp1 = new Employee();
//		emp1.setEmpno(9554);
//		emp1.setEname("������");
//		emp1.setJob("�������� �����Ǳ�");
//		emp1.setDeptno(60);
//		em.persist(emp1);
		
		//[2] �μ���ȣ�Է� - �ڵ������Լ����(����)
		//[3] �μ������� ����� ���� �Է��� ���� ���
//		Department dept1 = new Department();
//		dept1.setDeptno(80);
//		dept1.setDanme("���");
//		dept1.setLoc("����");
//		em.persist(dept1);
//		
//		Employee emp2 = new Employee();
//		emp2.setEmpno(7657);
//		emp2.setEname("�ͱ�");
//		emp2.setDept(dept1);
//		em.persist(emp2);
		//insert sql������ 2�� ����
		
		
		//[4]
		// ������ �ִ� 40�� �μ��� �������� ����� �ϰ� ������
//		Employee emp3 = new Employee();
//		Department dept2 = em.find(Department.class, 40);
//		emp3.setDept(dept2)
		
//		emp3.setEmpno(58746);
//		emp3.setDept(em.find(Department.class, 40));
//		emp3.setEname("�͸���");
//		em.persist(emp3);
//		tx.commit();
		em.close();
	}//end of insertDate
}
