package com.javaclass.service;

import java.util.List;

import org.springframework.ui.Model;

import com.javaclass.vo.DeclarationVO;

public interface DeclarationService {

	//신고 접수 기능
	public void declarationInsert(DeclarationVO vo);

	//신고 수정 기능(회원정보페이지 기능 미정)

	//신고 목록 보기
	public List<DeclarationVO> getDeclarationList(int page,int size);

	int getTotalDeclaration();
	//저장소에 모든 값들 저장 기능 

	//신고 매물 삭제
	public void declarationPropertyDelete(Model m);

	//신고 매물 반려 허위 사실인 경우 신고 삭제
	public void declarationDelete(int declaration_num);



	//채은 추가 사용자 신고확인 list
	// 0520 기진 추가 : 사용자 페이지 - 신고내역 페이징
	public List<DeclarationVO> userDeclarationList(String user_id, int page, int size);

	// 채은 추가 사용자 신고 삭제
	public int userDeclarationDelete(DeclarationVO vo);

	// 0520 기진 추가 : 사용자 페이지 - 신고내역 페이징 수 뽑
	public int getTotalDeclarationCount(String user_id);

}
