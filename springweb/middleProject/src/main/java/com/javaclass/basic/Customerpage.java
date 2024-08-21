package com.javaclass.basic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.service.DeclarationService;
import com.javaclass.service.PropertyService;
import com.javaclass.service.ReservationService;
import com.javaclass.service.ServiceTx;
import com.javaclass.service.WatchListService;
import com.javaclass.vo.DeclarationVO;
import com.javaclass.vo.PropertyVO;
import com.javaclass.vo.ReservationVO;
import com.javaclass.vo.UserVO;
import com.javaclass.vo.WatchListVO;

@Controller
@RequestMapping("customerpage")
public class Customerpage {

	@Autowired
	private WatchListService watchListService;

	@Autowired
	private PropertyService propertyService;


	@Autowired
	private ReservationService reservationService;

	@Autowired
	private DeclarationService declarationService;

	@Autowired
	private ServiceTx service;

	@RequestMapping("/myInfo")
	public String Category(HttpSession session,Model model) {
		String user_id=(String) session.getAttribute("user");

		UserVO vo = service.userSelect(user_id);
		model.addAttribute("userInfo",vo);

		return "customerpage/myInfo";
	}

	//채은 수정
	@RequestMapping("/interestItem")
	public String interestitem(HttpSession session, Model model) {
		String user_id = (String) session.getAttribute("user");

		List<WatchListVO> vo = watchListService.watchListSelect(user_id);

		// property_id의 대한 값을 받아올 list	
		ArrayList watchList = new ArrayList();

		for (WatchListVO item : vo) {
			int property_id = item.getProperty_id();


			PropertyVO propertyVO = propertyService.getProperty(property_id);

			watchList.add(propertyVO);


		}


		model.addAttribute("watchList", watchList);


		return "customerpage/interestItem";
	}

	// 채은 수정 사용자 신고 조회
	// 05/20 기진 페이징 -------------------------------------------------------------------------
	@RequestMapping("/qnaAdmin")
	public String qnaAdmin(ReservationVO rvo, HttpSession session, Model model,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "7") int size) {
		String user_id = (String) session.getAttribute("user");

		int totalReservation = declarationService.getTotalDeclarationCount(user_id);
		List<DeclarationVO> result = declarationService.userDeclarationList(user_id,page,size);

		//int totalPages = (int)Math.ceil(totalReservation/size); 

		model.addAttribute("userDeclarationList", result);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalReservation);
		model.addAttribute("pageSize", size);
		

		return "customerpage/qnaAdmin";
	}

	@RequestMapping("declarationDelete")
	@ResponseBody
	public String declarationDelete(int declaration_num, HttpSession session) {
		String user_id = (String) session.getAttribute("user");

		DeclarationVO vo = new DeclarationVO();
		vo.setUser_id(user_id);
		vo.setDeclaration_num(declaration_num);

		String result = String.valueOf(declarationService.userDeclarationDelete(vo));		

		return result;
	}


	//채은 수정
	// 05/20 기진 페이징 -------------------------------------------------------------------------
	@RequestMapping("/reservAdmin")
	public String reservAdmin(HttpSession session, Model model,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "7") int size) {
		String user_id = (String) session.getAttribute("user");
		List<ReservationVO> result = reservationService.reservationSelect(user_id,page,size);
		
		for(ReservationVO reservationVO : result) {
			int propertyId = reservationVO.getProperty_id();
			

			PropertyVO pvo = propertyService.getProperty(propertyId);


			String property_type = pvo.getProperty_type();
			String addr = pvo.getProperty_addr();
			String addr_detail = pvo.getAddr_detail();
			String property_title = pvo.getProperty_title();
			model.addAttribute("property", pvo);

			reservationVO.setType(property_type);
			reservationVO.setAddr(addr+" "+addr_detail);


		}
		
		int totalReservation = reservationService.getTotalReservationCount(user_id);
		

		model.addAttribute("reservationSelect", result);
		model.addAttribute("currentPage", page);
		model.addAttribute("pageSize", size);
		
		model.addAttribute("totalPages", totalReservation);
		return "customerpage/reservAdmin";
	}

	@RequestMapping("reservationDelete")
	@ResponseBody
	public String reservationDelte(int reservation_id, HttpSession session) {
		String user_id = (String) session.getAttribute("user");
		
		ReservationVO vo = new ReservationVO();
		vo.setUser_id(user_id);
		vo.setReservation_id(reservation_id);
		String result = String.valueOf(reservationService.reservationDelete(vo));

		return result;
	}

	@RequestMapping("/myInfoUpdate")
	public String myInfoUpdate(@RequestParam String user_id, Model model) {
		UserVO vo = service.userSelect(user_id);
		model.addAttribute("userInfo",vo);
		return "customerpage/myInfoUpdate";
	}

	@RequestMapping("/updateSubmit")
	public String updateSubmit(UserVO userVO) {
		service.userUpdate(userVO);
		return "redirect:/customerpage/myInfo";
	}

	@RequestMapping("userInfoDelete")
	public String agentDelete(String user_id, HttpServletRequest request) {
		
		service.userInfoDelete(user_id);
		request.getSession().invalidate();

		return "redirect:/mainPage";
	}


}
