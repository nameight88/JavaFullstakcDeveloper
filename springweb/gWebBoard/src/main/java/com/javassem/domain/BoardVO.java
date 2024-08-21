package com.javassem.domain;

import java.util.Date;

// VO(Value Object) == DTO ( Data Transfer Object )
// 롬복적용 확인

public class BoardVO {

	private Integer 	seq;		// 글번호
	private String 		title;		// 글제목
	private String 		writer;		// 작성자
	private String 		content;	// 글내용
	private Date 		regDate;	// 작성일
	private Integer 	cnt;		// 조회수


	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}

	
	
	
}