package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.domain.MemberVO;

//**
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);		
	}

	@Override
	public MemberVO checkLogin(MemberVO vo) {

		 MemberVO result = memberDAO.checkLogin(vo);
//		System.out.println("서비스 요청 확인"+result);
		return result;
		
	}



}
