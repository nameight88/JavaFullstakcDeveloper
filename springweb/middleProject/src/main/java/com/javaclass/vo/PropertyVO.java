package com.javaclass.vo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PropertyVO {
	private int property_id; // 매물번호
	private String property_title; // 매물제목
	private String property_type; // 종류(아파트.오피스텔, 주택~~)
	private String property_cate; // 거래유형
	private String property_addr; // 주소
	private String post_code; // 우편번호
	private String addr_detail; // 상세주소
	private long price; // 가격
	private long deposit; // 보증금
	private int property_size; // 크기
	private int bedrooms; // 침실수
	private int bathrooms; // 욕실수
	private String description; // 설명
	private String property_year; // 연식
	private String reg_date; // 등록일
	private PropertyOptionVO propertyOption;
	private PropertySecurityVO propertySecurity;
	private int property_count; // 조회수
	private String agent_id; // 중개인 아이디
	
	
	
	private ServletContext servletContext;
	MultipartFile file; // ****** type='file'의 name명과 동일
	private String property_fname; // 파일 이름
	private String property_realfname; // 파일 경로 이름
	private long property_fsize; // 파일 사이즈
	private String searchText;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;


		// 업로드 파일이 있는 경우
		if( !file.isEmpty()) {
			this.property_fname = file.getOriginalFilename();
			this.property_fsize = file.getSize();

			// 실제 저장된 파일명 만들기
			UUID uuid = UUID.randomUUID();
			this.property_realfname = uuid.toString() + "_" + property_fname;

			// 실제파일 저장
			// [오늘의 과제] 추후에 웹서버 경로를 찾아서 수정
			// /Users/kangchaeeun/springweb/middleTest/src/main/webapp/resources/propertyImg
			//File f = new File("D:\\springweb\\middleTest\\src\\main\\webapp\\resources\\propertyImg\\" + property_realfname);
			//File f = new File("/Users/kangchaeeun/springweb/middleTest/src/main/webapp/resources/propertyImg/" + property_realfname);
			
			// 서버 컴퓨터
			File f = new File("D:\\springweb\\middleTest\\src\\main\\webapp\\resources\\propertyImg\\" + property_realfname);
			
			try {
				file.transferTo(f); // 실제 전송
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
