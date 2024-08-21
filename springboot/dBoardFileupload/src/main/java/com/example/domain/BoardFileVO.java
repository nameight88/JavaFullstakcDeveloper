package com.example.domain;

import lombok.Data;

@Data
public class BoardFileVO {
	
	private Integer fileid; //파일의 아이디 값
	
	private String originFilename; //파일 이름명
	
	private String filename; // 파일 저장 이름
	
	private String filepath; // 파일 주소값
	
}
