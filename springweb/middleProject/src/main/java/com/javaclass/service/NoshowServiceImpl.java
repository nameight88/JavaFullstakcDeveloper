package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.NoshowDao;
import com.javaclass.vo.NoshowVO;

@Service("NoshowService")
public class NoshowServiceImpl implements NoshowService{
	@Autowired
	private NoshowDao noshowdao;

	@Override
	public int noshowInsert(NoshowVO vo) {
		return noshowdao.noshowInsert(vo);
	}

	@Override
	public int noshowDelete(NoshowVO vo) {
		return noshowdao.noshowDelete(vo);
	}

	@Override
	public boolean noshowSelect(int reservation_id) {
		return noshowdao.noshowSelect(reservation_id);
	}

	@Override
	public List<NoshowVO> noshowGetList(int page,int size) {
		int offset = (page - 1 )*size;
		return noshowdao.noshowGetList(offset,size);
	}

	public int getTotalNoshow() {
		return noshowdao.getTotalNoshow();
	}

}
