package com.javaclass.vo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//@Alias("cvo")
@Data
public class AgentVO {
	
	 private String agent_id;
	 private String agent_password;
	 private String agent_email;
	 private String agent_name;
	 private String agent_phone;
	 private String agency;
	 private String license_num;

	 private String agent_fname;		// 중개인 증명사진파일명
	 private String agent_realfname; 	// 저장된 파일이름
	 private long agent_fsize;			// 파일크기
		
	 //*************************************************
	 MultipartFile file; // ****** type='file'의 name명과 동일	
	 
	 public MultipartFile getFile() {
	      return file;
	   }

	   public void setFile(MultipartFile file) {
	      this.file = file;


	      // 업로드 파일이 있는 경우
	      if( !file.isEmpty()) {
	         this.agent_fname = file.getOriginalFilename();
	         this.agent_fsize = file.getSize();

	         // 실제 저장된 파일명 만들기
	         UUID uuid = UUID.randomUUID();
	         this.agent_realfname = uuid.toString() + "_" + agent_fname;

	         // 실제파일 저장
	         // [오늘의 과제] 추후에 웹서버 경로를 찾아서 수정
	         //File f = new File("C:\\Users\\ict03_030\\git\\MiddleProject\\middleTest\\src\\main\\webapp\\resources\\upload\\" + agent_realfname);

			 //File f = new File("/Users/kangchaeeun/springweb/middleTest/src/main/webapp/resources/agentImg/" + agent_realfname);

	         // 서버 컴퓨터
	         File f = new File("D:\\springweb\\middleTest\\src\\main\\webapp\\resources\\agentImg\\" + agent_realfname);
				
	         
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
