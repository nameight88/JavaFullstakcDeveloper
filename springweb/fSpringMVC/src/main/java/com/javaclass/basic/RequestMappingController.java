package com.javaclass.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.basic.model.MemberVO;

@Controller//[1]컨트롤러 부여
@RequestMapping("re")//[3]요청를 받을때 re부분을 먼저 받아 낸다. 게시판이 board일때 board등으로 1차적으로 걸러낼수있다.
public class RequestMappingController {
	//@RequestMapping(value={"re/a.do","re/b.do"}) value 속성을 부여하는게 생략되어있다.
	@RequestMapping({"a.do","b.do"})//[2]요청을 받을 매퍼 생성
	public String test() {
		System.out.println("re/a.do 요청");//요청을 받았는지 확인 
		return "hello"; //문자열 리턴이 아니라 view에서 페이지를 지정해줌
		//hello라는 뷰로 리턴을 해서 미리 만들어 둔 hello.jsp로 넘어가진다.
	}
	/* ************
	 * 스프링 컨트롤러에서 뷰 페이지 지정방법
	 * 1.ModelAdnView 에 setViewName() 메소드로 지정
	 * 2.리턴값이 String 인경우 return(리턴이 아니라 뷰페이지로 지정) : string이 view name이된다.
	 * 3.리턴값이 void 인경우 :요청명(request) 값이 view name이 된다.
	 */
	@RequestMapping(value="c.do",params={"id=kim"})//요청을 보낼때 인자(파라메터)가 kim인경우에만 수행한다.
	public void test2() {
		System.out.println("re/c.do 요청 확인");
	}
//	//이전 화면에서 넘어오는 파라메터 받기
//	@RequestMapping(value="c.do",params={"id=kim"})
//	public void test3(String id) {
//		System.out.println("re/c.do 요청 확인");
//		System.out.println("파라매터 값: "+id);
//	}
	@RequestMapping(value="request.do")
	public void request(MemberVO vo) {
		System.out.println("request.do 요청 확인");
		System.out.println(vo.toString());
	}
}
