package com.javaclass.basic;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaclass.service.NoshowService;
import com.javaclass.service.PropertyService;
import com.javaclass.service.ReservationService;
import com.javaclass.service.ServiceTx;
import com.javaclass.vo.AgentVO;
import com.javaclass.vo.PropertyOptionVO;
import com.javaclass.vo.PropertySecurityVO;
import com.javaclass.vo.PropertyVO;
import com.javaclass.vo.ReservationVO;

@Controller
@RequestMapping("agent")
public class AgentController {

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private ServiceTx service;

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private NoshowService noshowService;

	public String getSessionValue(HttpServletRequest request) {
		HttpSession session = request.getSession(false); // 세션이 없으면 null 반환
		if (session != null) {
			String userId = (String) session.getAttribute("userId"); // "userId"라는 이름의 세션 값 가져오기
			if (userId != null) {
				return userId; // 세션 값 반환
			}
		}
		return null; // 세션에 값이 없는 경우 null 반환
	}

	@RequestMapping("/agentPage")
	public String agentPage() {
		return "agent/agentPage";
	}

	// 중개인 정보 출력
	@RequestMapping("/agentInfo")
	public String agentInfo(HttpSession session, Model model) {
		String agentId = (String) session.getAttribute("agent");
		AgentVO agentInfo = service.agentSelect(agentId);
		
		model.addAttribute("agentInfo", agentInfo);

		return "agent/agentInfo";
	}
	// 중개인 회원 정보 수정하기 위한 페이지 이동
	@RequestMapping("agentInfoUpdate")
	public String agentInfoUpdate(@RequestParam String agent_id, Model model) {
		AgentVO agentInfo = service.agentSelect(agent_id);
		model.addAttribute("agentInfo", agentInfo);

		return "agent/agentInfoUpdate";

	}
	// 중개인 회원 정보 수정
	@RequestMapping("agentInfoDBUpdate")
	public String agentInfoDBUpdate(AgentVO agentVO) {
		
		service.agentUpdate(agentVO);

		return"redirect:agentInfo";
	}
	// 중개자 회원 탈퇴
	@RequestMapping("agentInfoDelete")
	public String agentDelete(String agent_id, HttpServletRequest request) {
		
		service.agentInfoDelete(agent_id);
		request.getSession().invalidate();

		return "redirect:/mainPage";
	}


	// 매물 list
	@RequestMapping("/agentManagement")
	public String agentManagement(PropertyVO vo, Model model, HttpSession session,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "7") int size) {

		String agent_id = (String) session.getAttribute("agent");
		vo.setAgent_id(agent_id);

		List<PropertyVO> result = propertyService.getPropertyList(vo,page,size);
		
		int totalAgentProperty = propertyService.getTotalAgentProperty(agent_id);
		
		model.addAttribute("propertyList", result);
		model.addAttribute("totalAgentProperty", totalAgentProperty);
		model.addAttribute("currentPage", page);
	    model.addAttribute("pageSize", size);

		return "agent/agentManagement";
	}

	// 0520 기진 : 중개인페이지 - 예약관리 페이징 추가 및 수정 ----------------------------------------------------------------------
	@RequestMapping("/agentReservation")
	public String agentReservation(Model m,HttpSession session,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "7") int size) {
		// reservation의 정보 가져오기
		String agent_id = (String) session.getAttribute("agent");
		List<ReservationVO> reservationList = reservationService.selectReservedList(agent_id,page,size);

		// 만약에 빈값이면 넘겨
		if (!reservationList.isEmpty()) {
			// 채은추가
			for (ReservationVO reservation : reservationList) {
				// 노쇼 판별
				int reservationId = reservation.getReservation_id();
				boolean result = noshowService.noshowSelect(reservationId);
				reservation.setNoshow(result);  // assuming ReservationVO has a setNoshow method

				int propertyId = reservation.getProperty_id();
				PropertyVO vo =propertyService.getProperty(propertyId);
				String property_type = vo.getProperty_type();
				String addr = vo.getProperty_addr();
				String addr_detail = vo.getAddr_detail();

				// 매물 vo의 값을 reservation에 값 넣어주기	
				reservation.setAddr(addr+" "+addr_detail);
				reservation.setType(property_type);


			}
			

			// 05/20 paging add section
			int totalAgentReservation = reservationService.getTotalAgentReservationCount(agent_id);
			//int totalPages = (int)Math.ceil(totalAgentReservation/size); 

			// reservationVO 에서 값을 가져와서 추가해주기
			m.addAttribute("reservationList", reservationList);
			m.addAttribute("currentPage", page);
			m.addAttribute("totalPages", totalAgentReservation);
			m.addAttribute("pageSize", size);
			
		} else {
			
		}


		return "agent/agentReservation";
	}



	// 매물 상세 조회
	@RequestMapping("/agentDetail")
	public String agentDetail(@RequestParam("id") int propertyId, Model model) {
		
		PropertyVO vo = propertyService.getProperty(propertyId);
		PropertyOptionVO optionVO = propertyService.getPropertyOption(propertyId);
		PropertySecurityVO securityVO = propertyService.getPropertySecurity(propertyId);


		model.addAttribute("property", vo);
		model.addAttribute("option", optionVO);
		model.addAttribute("security", securityVO);

		return "agent/agentUpdate";
	}

	// 매물 삭제
	@RequestMapping("/agentDelete")
	public String agentDelete(@RequestParam("id") int propertyId, Model model) {
		
		propertyService.deleteProperty(propertyId);
		return "redirect:agentManagement";

	}

	// 매물수정
	@RequestMapping("/propertyUpdate")
	public String propertyUpdate(@ModelAttribute PropertyOptionVO optionVO, @ModelAttribute PropertySecurityVO securityVO , @ModelAttribute PropertyVO vo) {
		// 데이터 처리 로직 추가

		propertyService.updateProperty(vo, optionVO, securityVO);
		

		return "redirect:agentManagement";
	}

	// 매물등록
	@RequestMapping("propertyInsert")
	public String propertyInsert(PropertyVO vo, PropertyOptionVO optionVO, PropertySecurityVO securityVO) {

		propertyService.propertyInsert(vo, optionVO, securityVO);

		return "redirect:agentManagement";
	}

}
