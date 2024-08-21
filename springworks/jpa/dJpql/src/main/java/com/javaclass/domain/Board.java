package com.javaclass.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="BOARD_T")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer seq;
	private String title;
	private Integer cnt;
	private String writer;
	private String content;
	private Date regdate;
	
}
