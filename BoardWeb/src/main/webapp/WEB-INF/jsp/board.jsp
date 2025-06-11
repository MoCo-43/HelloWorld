<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h3>상세화면(board.jsp)</h3>
  
<form action="modifyBoard.do">
    <input type="hidden" name="bno" value="${board.boardNo">
    <input type="hidden" name="page" value="${pg}">
    <input type="hidden" name="searchCondition" value="${sc}">
    <input type="hidden" name="keyword" value="${kw}">
    
    <table class="table">
        <tr>
            <th>글번호</th>
            <td>${board.boardNo}</td>
            <th>조회수</th>
            <td>${board.readCnt}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td colspan="3">${board.title}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td colspan="3">
                <textarea cols="45" rows="4" class="form-control" readonly>${board.content}</textarea></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td colspan="3">${board.writer}</td>
        </tr>
        <tr>
            <th>작성일시</th>
            <td colspan="3">${board.writeDate}</td>
        </tr>
        <tr>
                <!-- 
                if (글작성자 != 글조회자) {
                  수정버튼 활성화
                } else {
                  disabled
                }
                 -->
            <td colspan="4" align="center">
                <input type="submit" value="수정" class="btn btn-warning">
                <button class="btn btn-danger" type="button">삭제</button>
            </td>
        </tr>
    </table>
</form>
<script>
    let bno = "${board.boardNo}";
    console.log(bno);
    document.querySelector('button.btn-danger').addEventListener('click', function () {
        location.href = 'removeBoard.do?bno=' + bno;
    })
</script>