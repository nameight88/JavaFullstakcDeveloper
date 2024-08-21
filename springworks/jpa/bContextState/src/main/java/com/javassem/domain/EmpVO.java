package com.javassem.domain;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data //lombok
@Entity
@Table(name="EMP_A") // ����) mysql,mariadb ��ҹ��ڸ� ���� �ϴ� ��찡 �ִ�.
public class EmpVO {
	
	@Id //�����̸Ӹ�Ű�� ����
	private Integer empno;
	private String ename;
	private Integer mgr;
	private String job;
	private Date hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
	
}
