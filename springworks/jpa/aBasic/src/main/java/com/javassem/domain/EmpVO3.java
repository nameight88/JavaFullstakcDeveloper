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
@Table(name="EMP_C") // ����) mysql,mariadb ��ҹ��ڸ� ���� �ϴ� ��찡 �ִ�.
public class EmpVO3 {
	
	@Id //�����̸Ӹ�Ű�� ����
	//�ڵ������Լ� MYSQL,MARIADB����
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//����Ŭ ����
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer empno;
	
	@Column(length=30)
	private String ename;
	private Integer mgr;
	
	@Column(length=50, nullable=true)
	private String job;
	
	@Column(name="hire_date")//�����ͺ��̽��� �ִ� �÷� ��� ��ġ�ϰ� �ְ� ������ 
	private Date hiredate;
	private Integer comm;
	
	@Column(columnDefinition = "int check(deptno in(87,88,89))")//deptno�� ���ؼ� ���ϴ� ��ȣ�� ���� �� �ְ�
	private Integer deptno;
	
	@Column(precision = 5)//�ڸ�����
	private Integer sal;
	
}
