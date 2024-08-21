package com.javaclass.dao;

import java.util.List;

import com.javaclass.vo.ReservationVO; 

public interface ReservationDao {


	public void insertReservation(ReservationVO formData);

	public List<ReservationVO> selectReservedTime(String reservation_date, String agent_id);


	// 채은 추가 사용자 예약 list
	// 05/20 - 페이징 리스트 뽑기(고객)
	public List<ReservationVO> reservationSelect(String user_id, int offset, int size);

	// 채은 추가 사용자 예약 취소
	public int reservationDelete(ReservationVO vo);

	// 기진추가
	// 05/20 - 페이징 리스트 뽑기(중개인)
	public List<ReservationVO> selectReservedList(String agent_id, int offset, int size);


	// 예약중 -> 예약승인으로 바꾸기
	public int regStatusUpdate(ReservationVO vo);

	// 예약승인 -> 예약중으로 바꾸기
	public int regStatuReset(ReservationVO vo);


	// 05/20 - 페이징 리스트 뽑기(사용자 예약 수)
	public int getTotalReservationCount(String user_id);
	// 05/20 - 페이징 리스트 뽑기(중개인 예약 수)
	public int getTotalAgentReservationCount(String agent_id);

}
