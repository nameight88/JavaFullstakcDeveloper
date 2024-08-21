package com.javassem.domain;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data //lombok
@Entity
@Table(name="EMP_A") // 주의) mysql,mariadb 대소문자를 구분 하는 경우가 있다.
public class EmpVO {
	
	@Id //프라이머리키를 설정
	private Integer empno;
	private String ename;
	private Integer mgr;
	private String job;
	private Date hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
	
}
