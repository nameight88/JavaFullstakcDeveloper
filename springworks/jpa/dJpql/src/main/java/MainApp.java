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
			// ******* 실제 SQL문장이 아니기에
			// 테이블명이 아닌 클래스명 기술
			//(대소문자를 구분한다.)
//			String jpql = "SELECT b FROM Board AS b";
//			TypedQuery<Board> query=em.createQuery(jpql,Board.class);
//			List<Board> list =query.getResultList();
//			for(Board vo:list) {
//				System.out.println(vo.toString());
//			}
			
			
			//특정 컬럼만 검색
			String jpql = "SELECT seq,title,writer FROM Board";
			Query query = em.createQuery(jpql);
			List<Object[]> list =  query.getResultList();
			for(Object[]result :list){
//				System.out.println(">>>" +result);
				System.out.println(">>>" +Arrays.toString(result));
			}
		} catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}

	}

}
