package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        // 한 건만 조회할 예정
    	// http://localhost:8080/board.do?bno=34   => url 호출형태
    	String bno = req.getParameter("bno");  // bno의 번호를 받아와서 전달
        // 추가파라미터 (page, searchCondition, keyword) => board.jsp에 담아두어야 함
    	String page = req.getParameter("page");
    	String sc = req.getParameter("searchCondition");
    	String kw = req.getParameter("keyword");
    	
    	// 메소드의 매개값 전달을 위해서
    	BoardService svc = new BoardServiceImpl();
    	BoardVO board = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("board",board); // 요청정보 값을 담아서 전달
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
    	// 요청재지정(페이지이동)
    	req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
    }
}