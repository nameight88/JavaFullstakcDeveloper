package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javaclass.dao.DeclarationDao;
import com.javaclass.vo.DeclarationVO;

@Service("declarationService")
public class DeclarationServiceImpl implements DeclarationService{

	@Autowired
	private DeclarationDao declarationDao;

	@Override
	public void declarationInsert(DeclarationVO vo) {
		declarationDao.declarationInsert(vo);
	}

	@Override
	public List<DeclarationVO> getDeclarationList(int page,int size) {
		int offset = (page - 1)*size;
		return declarationDao.getDeclarationList(offset,size);
	}

	public int getTotalDeclaration() {
		return declarationDao.getTotalDeclaration();
	};

	@Override
	public void declarationPropertyDelete(Model m) {
		declarationDao.declarationPropertyDelete(m);

	}


	@Override
	public void declarationDelete(int declaration_num) {
		declarationDao.declarationDelete(declaration_num);
	}




	//채은 추가 사용자 신고확인 list
	// 05/20 기진 추가: 사용자 페이지 - 신고내역 페이징 --------------------------------------
	@Override
	public List<DeclarationVO> userDeclarationList(String user_id, int page, int size) {
		int offset = (page-1)*size;
		return declarationDao.userDeclarationList(user_id, offset, size);
	}

	@Override
	public int userDeclarationDelete(DeclarationVO vo) {
		return declarationDao.userDeclarationDelete(vo);
	}

	// 05/20 기진 추가: 사용자 페이지 - 신고내역 페이징 수 뽑기 --------------------------------------
	@Override
	public int getTotalDeclarationCount(String user_id) {
		return declarationDao.getTotalDeclarationCount(user_id);
	}


}
