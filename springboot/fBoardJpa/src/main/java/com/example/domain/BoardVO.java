package com.example.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

//**

@Data //Lombok
@Entity//JPA
//@Table
public class BoardVO {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer seq;
	private String 	title;
	private String 	writer;
	private String 	content;
	private Date 	regdate;
	private int cnt;
}

