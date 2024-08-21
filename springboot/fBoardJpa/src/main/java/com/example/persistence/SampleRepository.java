package com.example.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

public interface SampleRepository extends CrudRepository<BoardVO, Integer>{
	
	
	// 기본 메소드
	/* findAll()
	 * findById()
	 * save()
	 * deleteById()
	 */
	
	// 쿼리 메소드 추가
	// WHERE latsname =?1
	List<BoardVO>findByTitle(String title);
	
	// WHERE title != ?1
	List<BoardVO> findByTitleNot(String title);
	
	// WHERE title = ?1 and writer = ?1
	List<BoardVO> findByTitleOrWriter(String title,String writer);
	
	// WHERE title = "test"
	List<BoardVO> findByTitleContaining(String title);
	
	// DESC
	List<BoardVO> findByTitleContainingOrderByTitleDesc(String title);
}
