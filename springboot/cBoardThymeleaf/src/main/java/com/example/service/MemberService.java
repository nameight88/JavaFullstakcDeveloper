package com.example.service;

import java.util.List;

import com.example.domain.MemberVO;

public interface MemberService {

	void insertMember(MemberVO vo);
	public MemberVO checkLogin (MemberVO vo);
}
