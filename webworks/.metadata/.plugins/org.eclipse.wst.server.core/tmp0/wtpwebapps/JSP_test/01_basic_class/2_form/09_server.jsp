<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="temp.*"%>

<%
//[1] 입력한 값들을 가져오기
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String deptno = request.getParameter("deptno");
		String sal = request.getParameter("sal");
		String job = request.getParameter("job");
		
		//[2] EmpVo 객체안에 맴버로 지정
		EmpVO vo = new EmpVO();
		vo.setEmpno( Integer.parseInt(empno));
		vo.setEname(ename);
		vo.setDeptno( Integer.parseInt(deptno));
		vo.setSal( Integer.parseInt(sal));
		vo.setJob(job);
		
		//[3] EmpDao 에 insertEmp()로 2번 객체 전송
		
		//EmpDao dao = EmpDao.getInstance();
		//dao.insertEmp(vo);
		EmpDao dao =EmpDao.getInstance();
		dao.insertEmp(vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 사원등록 </title>
</head>
<body>
	 성공적으로 입력되었지 DB에서 확인합니다.
	 <hr/>
	 
	 <a href='09_empSelect.jsp'>사원정보보기</a>
	 
	 <hr/>
</body>
</html>