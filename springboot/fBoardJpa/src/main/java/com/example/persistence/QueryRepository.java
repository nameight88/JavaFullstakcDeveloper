package com.example.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

public interface QueryRepository extends CrudRepository<BoardVO, Integer>{
	//[1] JPQL
	//-> SQL이 아닌 Entity class 를 이용한 Query 생성
	// 클래스명, 컬럼명 등등 대소문자 구별
	@Query("SELECT b.seq  seq 	 "
			+ ", b.title  title  "
			+ ", b.writer writer "
			+ " FROM BoardVO b "
			+ " WHERE  b.title LIKE %?1% "
			+ " ORDER BY b.seq DESC ")
	List<Map> queryJpql(String word);
	//List<Object[]> 이렇게 배열로 받는 것도 가능하다.
	
	
	
	//[2] native query(SQL)
	@Query(value= "SELECT b.seq  seq 	 "
			+ ", b.title  title  "
			+ ", b.writer writer "
			+ " FROM boardvo b "
			+ " WHERE  b.title LIKE %?1% "
			+ " ORDER BY b.seq DESC "
			,nativeQuery=true)
	List<Map> queryNative(String word);
	
}
