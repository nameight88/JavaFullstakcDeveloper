package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data //lombok
@Entity
@Table(name="DEPT_TEST")
public class DeptVO {
	
	@Id
	private int deptno;
	private String dname;
	private String loc;
}
/*
 * 자바에서 DB연동하는 방법
 *  
 *  1) JDBC
 *  2) Mybatis
 *  3) JPA 스프링쪽에서 요즘 밀어주는 쪽
 *   
 *   
 *   JPA
 *   자바 클래스 -  [Entity]   - DB 테이블
 *   DeptVo		DeptVO 		DepetVO(다른 이름으로 설정이 가능하다)
 *   Entitiy도 이름이 변경이 가능하지만 헷갈릴수도 있기 떄문에 보통 테이블을 바꿔준다.
 *   
 *   
 */