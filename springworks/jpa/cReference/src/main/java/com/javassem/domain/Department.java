package com.javassem.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DEPT")
public class Department {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY) //MYSQL,mariadb
	private Integer deptno;
	private  String danme;
	private String loc;
	
	@OneToMany(mappedBy="dept",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Employee> empList =new ArrayList<Employee>();
	
	//양방향 연결인데 권장하는 방법은 아님
}
