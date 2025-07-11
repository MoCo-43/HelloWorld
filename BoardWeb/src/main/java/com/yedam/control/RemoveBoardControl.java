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
		String rno = req.getParameter("rno");
        // 글 상세조회
		BoardService svc = new BoardServiceImpl();
	    svc.removeBoard(Integer.parseInt(rno));
	    
	    // 요청재지정(페이지이동)
	    resp.sendRedirect("boardList.do");
	}
}
