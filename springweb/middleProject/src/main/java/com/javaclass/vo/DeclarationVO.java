package com.javaclass.vo;

import lombok.Data;

@Data
public class DeclarationVO {

	private int declaration_num; //신고번호
	private String user_id; //유저 아이디 
	private String agent_id; //중개인 아이디 
	private String declaration_contents; // 신고내용 
	private int property_id; //매물 번호 
	
	private String declaration_fname; // 신고 증명사진파일명
	private String declaration_realfname; //저장된 파일 이름
	private int declaration_fsize; //파일크기 

}
