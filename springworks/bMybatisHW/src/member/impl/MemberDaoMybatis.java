package member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.vo.MemberVO;

@Repository("memeberDAO")
public class MemberDaoMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	/*
	 * * SqlSession 주요 메소드
			   - selectList ( )
			   - selectOne ( )
			   - insert ( )
			   - update ( )
			   - delete ( )

	 */
	public void insertMember(MemberVO vo) {
		System.out.println("===> Mybatis insertMember() 호출");
		mybatis.insert("member.mapper.insertMember", vo);
	}

	public void updateMember(MemberVO vo) {
		System.out.println("===> Mybatis updateMember() 호출");
		mybatis.update("member.mapper.updateMember", vo);
	}

	public void deleteMember(MemberVO vo) {
		System.out.println("===> Mybatis deleteMember() 호출");
		mybatis.delete("member.mapper.deleteMember", vo);
	}

	public MemberVO getMember(MemberVO vo) {
		System.out.println("===> Mybatis getMember() 호출");
		return (MemberVO) mybatis.selectOne("member.mapper.getMember", vo);
	}

	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("===> Mybatis getMemberList() 호출");
		return mybatis.selectList("member.mapper.getMemberList", vo);
	}
}