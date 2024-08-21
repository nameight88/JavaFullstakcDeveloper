package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.ReservationDao;
import com.javaclass.vo.ReservationVO;

@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationDao rdao;

	// 0520 사용자 예약관리 페이징 관련 수정 -----------------------------
	// 사용자 예약 list 
	@Override
	public List<ReservationVO> reservationSelect(String user_id, int page, int size) {
		int offset = (page-1)*size;
		return rdao.reservationSelect(user_id,offset,size);
	}

	// 사용자 예약 취소
	@Override
	public int reservationDelete(ReservationVO vo) {
		return rdao.reservationDelete(vo);
	}

	// 0518 기진 : 중개인페이지 - 예약관리 ----------------------------------------------------------------------
	// 0520 중개인 예약관리 페이징 관련 수정 -----------------------------
	// 중개인 페이지 - 예약관리: 예약 리스트
	public List<ReservationVO> selectReservedList(String agent_id, int page, int size){
		int offset = (page-1)*size;
		return rdao.selectReservedList(agent_id,offset,size);
	}

	@Override
	public int regStatusUpdate(ReservationVO vo) {
		return rdao.regStatusUpdate(vo);
	}

	@Override
	public int regStatuReset(ReservationVO vo) {
		return rdao.regStatuReset(vo);
	}

	// 0520 추가 : 사용자 예약관리 수 뽑기 -----------------------------
	@Override
	public int getTotalReservationCount(String user_id) {
		return rdao.getTotalReservationCount(user_id);
	}

	// 0520 추가 : 중개자 예약관리 수 뽑기 -----------------------------
	@Override
	public int getTotalAgentReservationCount(String agent_id) {
		return rdao.getTotalAgentReservationCount(agent_id);
	}




}
