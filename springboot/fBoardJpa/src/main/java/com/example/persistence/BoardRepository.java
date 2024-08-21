package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

public interface BoardRepository extends CrudRepository<BoardVO, Integer> {
	//T는 타입 보통 VO를 넣어주면 된다. Type은 PK의 타입을 적어주면된다.
	// 인터페이스만 생성을 해주고 이후에는 JPA에게 관리를 맡긴다.
}
