package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.vo.ReservationVO;

@Repository
public class ReservationDaoImpl implements ReservationDao{
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void insertReservation(ReservationVO formData) {
		ss.insert("reservation.insertReservation", formData);
		
	}

	@Override
	public List<ReservationVO> selectReservedTime(String reservation_date,String agent_id) {
		Map params = new HashMap();
		params.put("reservation_date", reservation_date);
		params.put("agent_id", agent_id);

		List<ReservationVO> result = ss.selectList("reservation.selectReseredTime", params);
		return result;
	}

	// 채은 추가 사용자 예약 list
	// 05/20 기진 페이징 추가 수정 ---------------------------------------
	@Override
	public List<ReservationVO> reservationSelect(String user_id, int offset, int size) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_id", user_id);
		params.put("offset", offset);
		params.put("size", size);
		
		return ss.selectList("reservation.reservationSelect",params);
	}

	// 채은추가 사용자 예약 취소
	@Override
	public int reservationDelete(ReservationVO vo) {
		return ss.delete("reservation.reservationDelete", vo);
	}

	// 0518 기진 : 중개인페이지 - 예약관리 ----------------------------------------------------------------------
	// 05/20 기진 페이징 추가 수정 ---------------------------------------
	public List<ReservationVO> selectReservedList(String agent_id, int offset, int size){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agent_id", agent_id);
		params.put("offset", offset);
		params.put("size", size);
		List<ReservationVO>result =  ss.selectList("reservation.selectReservedList",params);
		
		return result;


	}

	@Override
	public int regStatusUpdate(ReservationVO vo) {
		
		return ss.update("reservation.regStatusUpdate",vo);
	}

	@Override
	public int regStatuReset(ReservationVO vo) {
		
		return ss.update("reservation.regStatuReset",vo);
	}

	// 05/20 수정 ---------------------------------------
	// 05/20 사용자 예약 페이징 추가 ---------------------------------------
	@Override
	public int getTotalReservationCount(String user_id) {
		return ss.selectOne("reservation.getTotalReservationCount", user_id);	
	}
	// 05/20 중개인 예약 페이징 추가 ---------------------------------------
	@Override
	public int getTotalAgentReservationCount(String agent_id) {
		return ss.selectOne("reservation.getTotalAgentReservationCount", agent_id);
	}


}
