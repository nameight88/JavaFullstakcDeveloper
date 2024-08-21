package com.javassem.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name="EMP")
public class Employee {
	@Id
	private Integer empno;
	private String  ename;
	private Integer mgr;
	private Date hiredate;
	private Integer sal;
	private Integer comm;
	private String job;
//	private Integer deptno;
	@ManyToOne(optional = true) //하나의 테이블에 여러명이 들어 갈 경우
	@JoinColumn(name="deptno") //deptno와 join
	//@JoinColumn 만일 이 코드가 없으면 자동으로 테이블_컬러명에 해당되는 새로운 컬럼와 join이 된다.
	private Department dept;
	// 클래스 자체를 VO에 넣어버린다.
	
}
