package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");

		BoardService svc = new BoardServiceImpl();
	    BoardVO board = new BoardVO();
	    board.setBoardNo(Integer.parseInt(bno));
	    svc.deleteBoard(board);
	    
	    resp.sendRedirect("boardList.do");
	}
}
