package com.yedam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

//@WebServlet("/addBoard.serv")
public class AddBoard extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// addBoard.serv?title=제목&content=내용&writer=user01 이러한 형태로 들어갈 예정
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		// 메소드의 매개값 전달을 위해서
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);

		// 업무 서비스
		BoardService svc = new BoardServiceImpl();
		if (svc.registerBoard(board)) {
			System.out.println("등록성공.");
			// 목록페이지로 이동
			resp.sendRedirect("boardList.serv");
		} else {
			System.out.println("등록실패.");
		}

	}
}
