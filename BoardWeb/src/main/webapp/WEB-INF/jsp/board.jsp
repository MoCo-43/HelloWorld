<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>상세화면(board.jsp)</h3>
  <table class="table">
  <% 
  BoardVO board = (BoardVO) request.getAttribute("board"); 
  %>
    <tr>
        <th>글번호</th><td><%=board.getBoardNo() %></td><th>조회수</th><td>5</td>
    </tr>
    <tr>
        <th>제목</th><td colspan="3">JSP연습글..</td>
    </tr>
    <tr>
        <th>내용</th><td colspan="3"><textarea readonly>글내용입니다...</textarea></td>
    </tr>
    <tr>
        <th>작성자</th><td colspan="3">uesr01</td>
    </tr>
        <tr>
        <th>작성일시</th><td colspan="3">2025-05-31 12:12:12</td>
    </tr>
    <tr>
        <td>
          <input type="submit" value="수정">
          <button>삭제</button>
        </td>
    </tr>
  </table>
</body>
</html>