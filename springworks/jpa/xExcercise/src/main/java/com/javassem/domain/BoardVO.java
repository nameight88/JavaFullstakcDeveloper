package com.javassem.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Board_test")
public class BoardVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer sqe;
	@Column(length=100)
	private String title;
	@Column(length=50)
	private String writer;
	private String content;
	private Date regdate;
	private Integer cnt;
	
}
