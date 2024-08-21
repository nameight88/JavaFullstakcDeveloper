<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import='java.sql.*'%>    
    
<%
	// 이전화면에서 사용자 입력값을 얻어오기
	String empno = request.getParameter("empno");
	System.out.println("사번"+empno);
	String ename = request.getParameter("ename");
	System.out.println("사원명"+ename);
	String sal = request.getParameter("sal");
	System.out.println("월급"+sal);
	String dept = request.getParameter("dept");
	System.out.println("부서"+dept);
	String job = request.getParameter("job");
	System.out.println("업무"+job);
	
	/* 추후에는 절대 jsp에서 데이터베이스 연동하지 않음 */
	// 1. 드라이버 로딩
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("드라이버로딩성공");
	
	// 2. 연결객체 얻어오기
	String url		= "jdbc:mysql://localhost:3306/basic";
	String user		= "scott";
	String pass		= "tiger";
	Connection con = DriverManager.getConnection(url, user, pass);
	System.out.println("디비 연결 성공");
	
	// 3. SQL 문장
	String sql = "INSERT INTO emp(empno, ename, sal, deptno, job)"
				+" VALUES(?,?,?,?,?)";
	
	// 4. 전송객체 얻어오기
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, empno);
	ps.setString(2, ename);
	ps.setString(3, sal);
	ps.setString(4, dept);
	ps.setString(5, job);
	
	// 5. 전송
	ps.executeUpdate();
	
	// 6. 닫기
	con.close();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpInsert.jsp</title>
</head>
<body>
입력되었습니다

</body>
</html>