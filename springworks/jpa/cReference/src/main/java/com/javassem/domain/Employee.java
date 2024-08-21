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
	@ManyToOne(optional = true) //�ϳ��� ���̺� �������� ��� �� ���
	@JoinColumn(name="deptno") //deptno�� join
	//@JoinColumn ���� �� �ڵ尡 ������ �ڵ����� ���̺�_�÷��� �ش�Ǵ� ���ο� �÷��� join�� �ȴ�.
	private Department dept;
	// Ŭ���� ��ü�� VO�� �־������.
	
}
