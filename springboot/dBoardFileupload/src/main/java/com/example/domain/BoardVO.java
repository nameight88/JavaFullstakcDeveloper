package com.example.domain;

import lombok.Data;

//**

@Data
public class BoardVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int cnt;
	private Integer fileid;
}

