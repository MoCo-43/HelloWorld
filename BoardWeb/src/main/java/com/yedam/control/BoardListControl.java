package com.yedam.control;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control  {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// 여기에 페이지 이동 or 출력 로직 작성
    	//req.setAttribute("myName", "HongKilDong");  // hongkildong을 전달
    	// boardList.do?page=2
    	String page = req.getParameter("page");
    	page = page == null ? "1" :page;  // boardList.do => 페이지 출력
    	String sc = req.getParameter("searchCondition");
    	sc = sc == null ? "" : sc; // null값이 경우
    	String kw = req.getParameter("keyword");
    	kw = kw == null ? "" : kw; // null값이 경우
    	kw = URLDecoder.decode(kw);
    	
    	req.setAttribute("page", page);
    	req.setAttribute("searchCondition", sc);
    	req.setAttribute("keyword", kw);
    	
    	// 검색조건
    	SearchDTO search = new SearchDTO();
    	search.setPage(Integer.parseInt(page));
    	search.setSearchCondition(sc);
    	search.setKeyword(kw);
    	// 데이터처리
    	BoardService svc = new BoardServiceImpl();
    	List<BoardVO> list = svc.boardList(search);  // boardList.do => 1페이지 출력
    	// 페이징 계산
    	int totalCnt = svc.getTotalCount(search);
    	PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
    	// jsp페이지에 정보 전달
    	req.setAttribute("blist", list);  // 요청정보 값을 담아서 전달
    	req.setAttribute("pageInfo", paging);  // 페이지 보여주는 기능 전달
    	req.setAttribute("search", search);
    	HttpSession session = req.getSession();
    	String auth = (String) session.getAttribute("auth");
    	// 요청재지정(페이지 이동이 발생)	admin/board/
    	if(auth != null && auth.equals("User")) { /* 일반사용자 */
    		req.getRequestDispatcher("user/boardList.tiles").forward(req, resp);   // forward 페이지 이동    		
    	} else if (auth != null && auth.equals("Admin")) { /* 관리자 */    		
    		req.getRequestDispatcher("admin/board/boardList.tiles").forward(req, resp);
    	} else {
    		req.getRequestDispatcher("user/boardList.tiles").forward(req, resp);
    	}
    }
}