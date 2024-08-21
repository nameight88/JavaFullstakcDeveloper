package com.javassem.dao;

import java.util.List;

import com.javassem.domain.ReplyVO;

public interface ReplyDAO {

	public Integer insertReply(ReplyVO vo); 
	public List<ReplyVO> selectAllReply(Integer bno);
	public int deleteReply(Integer rno);
}
