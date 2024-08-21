package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import com.example.domain.MemberVO;

@Mapper
public interface MemberDAO {
	public void insertMember(MemberVO vo);
	public MemberVO checkLogin (MemberVO vo);
}
