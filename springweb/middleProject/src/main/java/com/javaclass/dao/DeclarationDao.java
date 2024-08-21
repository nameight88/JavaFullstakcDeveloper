package com.javaclass.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.javaclass.vo.DeclarationVO;

public interface DeclarationDao {

	public void declarationInsert(DeclarationVO vo);
	//신고 접수 기능

	public List<DeclarationVO> getDeclarationList(int offset,int size);
	//신고 목록 조회 기능

	int getTotalDeclaration();
	//저장소에 있는 모든 값 저장 기

	public void declarationPropertyDelete(Model m);
	//신고 매물 삭제 기능  

	public void declarationDelete(int declaration_num);
	//허위 신고일 경우 신고 삭제 기능 

	//채은 추가 사용자 신고확인 list
	// 0520 기진 추가 신고내역 페이징 ------------------------------
	public List<DeclarationVO> userDeclarationList(String user_id, int offset, int size);

	// 채은 추가 사용자 신고 삭제
	public int userDeclarationDelete(DeclarationVO vo);


	// 0520 기진 추가 신고내역 페이징 수 뽑기 --------------------------------
	public int getTotalDeclarationCount(String user_id);

}
