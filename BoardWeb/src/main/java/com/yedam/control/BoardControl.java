package com.yedam.control;

import java.io.IOException;
import java.util.Date;
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

    	BoardService svc = new BoardServiceImpl();
    	List<BoardVO> list = svc.boardList();
		// 메소드의 매개값 전달을 위해서
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		req.setAttribute("board",board);

    	req.setAttribute("blist", list);  // 요청정보 값을 담아서 전달
    	// 요청재지정(페이지이동)
    	req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
    }
}