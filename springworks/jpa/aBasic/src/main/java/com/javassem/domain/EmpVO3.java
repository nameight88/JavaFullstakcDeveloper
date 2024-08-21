package com.javassem.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data //lombok
@Entity
@Table(name="EMP_C") // 주의) mysql,mariadb 대소문자를 구분 하는 경우가 있다.
public class EmpVO3 {
	
	@Id //프라이머리키를 설정
	//자동증가함수 MYSQL,MARIADB버전
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//오라클 버전
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer empno;
	
	@Column(length=30)
	private String ename;
	private Integer mgr;
	
	@Column(length=50, nullable=true)
	private String job;
	
	@Column(name="hire_date")//데이터베이스에 있는 컬럼 명과 일치하게 주고 싶을때 
	private Date hiredate;
	private Integer comm;
	
	@Column(columnDefinition = "int check(deptno in(87,88,89))")//deptno에 대해서 원하는 번호만 들어올 수 있게
	private Integer deptno;
	
	@Column(precision = 5)//자릿수값
	private Integer sal;
	
}
