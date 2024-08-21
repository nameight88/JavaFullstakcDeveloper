package member.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import member.MemberService;
import member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	private MemberDaoMybatis memberDAO;

	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	public MemberVO getMember(MemberVO vo) {
		return memberDAO.getMember(vo);
	}

	public List<MemberVO> getMemberList(MemberVO vo) {
		return memberDAO.getMemberList(vo);
	}
}