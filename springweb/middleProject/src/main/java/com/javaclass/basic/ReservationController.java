package com.javaclass.basic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.service.ReservationService;
import com.javaclass.service.ServiceTx;
import com.javaclass.vo.ReservationVO;

@Controller
public class ReservationController {
	
	@Autowired
	private ServiceTx service;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("reservationInsert")
	@ResponseBody
	public void showAgentInfo(ReservationVO formData)throws Exception {
		service.insertReservation(formData);
	}
	
	
	@RequestMapping("getReservedTime")
	@ResponseBody
	public ArrayList<String> getReservedTime(String reservation_date,String agent_id, Model model)throws Exception {		
		List<ReservationVO> result = service.selectReservedTime(reservation_date,agent_id);
		
		ArrayList<String> list = new ArrayList<String>();
		for(ReservationVO items : result) {
			list.add(items.getReservation_time());
		}
		

		return list;
		
	}
	
	
	@RequestMapping("agent/regsuccess")
	@ResponseBody
	public String regsuccess(ReservationVO vo) {
		
		String result = String.valueOf(reservationService.regStatusUpdate(vo));
		
		return result;
	}
	
	@RequestMapping("agent/regCancel")
	@ResponseBody
	public String regCancel(ReservationVO vo) {
		String result = String.valueOf(reservationService.regStatuReset(vo));
		
		return result;
	}
	
	
	
}
