package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control  {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// 여기에 페이지 이동 or 출력 로직 작성
    	
//    	req.setAttribute("myName", "HongKilDong");  // hongkildong을 전달
    	
    	// boardList.do?page=2
    	
    	String page = req.getParameter("page");
    	page = page == null ? "1" :page;
    	// 글목록
    	BoardService svc = new BoardServiceImpl();
    	List<BoardVO> list = svc.boardList(Integer.parseInt(page));  // boardList.do => 1페이지 출력
    	
    	// 한화면에 페이지 보여주는 기능
    	int totalCnt = 112;
    	PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
    	

    	req.setAttribute("blist", list);  // 요청정보 값을 담아서 전달
    	req.setAttribute("pageInfo", paging);  // 페이지 보여주는 기능 전달 
    	
    	// 요청재지정(페이지 이동이 발생)	
    	req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);   // forward 페이지 이동
    }
}