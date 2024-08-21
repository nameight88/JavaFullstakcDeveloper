package com.javassem.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.javassem.domain.BoardVO;
public class BoardMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("xExcercise");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			BoardVO board = new BoardVO();
//			board.setWriter("≥≤¥Ÿ¿≠");
//			board.setTitle("±€¡¶∏Ò");
//			board.setContent("¡°Ω…ππ∏‘?");
			
//			find ¿ÃøÎ
			
			String jpql = "SELECT b FROM BoardVO b ORDER BY b.writer DESC";
			List<BoardVO> list = em.createQuery(jpql,BoardVO.class).getResultList();
			for (BoardVO vo : list) {
				System.out.println(">>>" +vo.toString());
			}
			tx.begin();
			em.merge(board);
			tx.commit();
		}catch(Exception e){
			System.out.println("Ω«∆– >>> "+e.getMessage());
		}

	}

}
