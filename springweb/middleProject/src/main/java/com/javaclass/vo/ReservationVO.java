package com.javaclass.vo;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ReservationVO {

	private int property_id;			// 매물번호
	private String agent_id;			// 중개인 id
	private String user_id;				// 고객 id
	private String reservation_date;	// 예약 날짜
	private String reservation_time;	// 예약 시간

	// 채은 추가
	private String status;
	private int reservation_id;
	private boolean noshow;
	private String addr;
	private String type;
	private String agency;


}
