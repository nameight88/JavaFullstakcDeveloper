package com.example.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

public interface PagingRepository extends CrudRepository<BoardVO,Integer>{
	
	List<BoardVO> findAll(Pageable paging);
}
