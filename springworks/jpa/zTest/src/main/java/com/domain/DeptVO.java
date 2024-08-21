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
 * �ڹٿ��� DB�����ϴ� ���
 *  
 *  1) JDBC
 *  2) Mybatis
 *  3) JPA �������ʿ��� ���� �о��ִ� ��
 *   
 *   
 *   JPA
 *   �ڹ� Ŭ���� -  [Entity]   - DB ���̺�
 *   DeptVo		DeptVO 		DepetVO(�ٸ� �̸����� ������ �����ϴ�)
 *   Entitiy�� �̸��� ������ ���������� �򰥸����� �ֱ� ������ ���� ���̺��� �ٲ��ش�.
 *   
 *   
 */