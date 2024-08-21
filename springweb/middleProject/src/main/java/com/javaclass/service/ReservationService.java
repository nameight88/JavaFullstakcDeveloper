package com.javaclass.service;

import java.util.List;

import com.javaclass.vo.ReservationVO;

public interface ReservationService {

	// 사용자 예약 list
	// 05/20 추가내용 ----------------------------------------------------------
	public List<ReservationVO> reservationSelect(String user_id, int page, int size);

	// 사용자 예약 취소
	public int reservationDelete(ReservationVO vo);

	// 0518 기진 : 중개인페이지 - 예약관리 ----------------------------------------------------------------------
	// 05/20 추가내용 ----------------------------------------------------------
	public List<ReservationVO> selectReservedList(String agent_id, int page, int size);

	// 예약중 -> 예약승인으로 바꾸기
	public int regStatusUpdate(ReservationVO vo);

	// 예약승인 -> 예약중으로 바꾸기
	public int regStatuReset(ReservationVO vo);

	// 05/20 추가내용 ----------------------------------------------------------
	// 05/20 pageing: user List 뽑아내기 
	public int getTotalReservationCount(String user_id);

	// 05/20 pageing: agent List 뽑아내기
	public int getTotalAgentReservationCount(String agent_id);

}
