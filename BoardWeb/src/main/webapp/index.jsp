<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.yedam.service.BoardService" %>
<%@page import="com.yedam.service.BoardServiceImpl" %>
<%@page import="com.yedam.vo.BoardVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
</head>
<body>
  <%
  for(int i = 0; i < 10; i++) {
	  System.out.println("Hello, World");
  }
  // 주석문
  // smaple_jsp -> sample_jsp.java -> smaple_jsp.class 실행
  %>
  
  <h3>html 테스트</h3>
  <%
  String str = "Hello, world";
  BoardService svc = new BoardServiceImpl();
  List<BoardVO> list = svc.boardList();
  %>

  <ul>
  <%
    for(BoardVO board : list) {
      System.out.println(str);
    }
  %>
  </ul>

</body>
</html>