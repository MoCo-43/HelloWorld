package com.yedam.control;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 한글처리
		
		// 요청방식에 따라 GET요청이면 화면 open
		//             POST요청이면 저장
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		// 추가파라미터
    	String page = req.getParameter("page");
    	String sc = req.getParameter("searchCondition");
    	String kw = req.getParameter("keyword");
    	kw = URLEncoder.encode(kw); // 주소표시줄
    	System.out.println(kw);

		BoardService svc = new BoardServiceImpl();

		
		
		if(req.getMethod().equals("GET")) {
			// 요청재지정(페이지이동)  modifyBoard.do?bno=23   <-이러한 형태로 지정함
			BoardVO board = svc.getBoard(Integer.parseInt(bno)); //
			req.setAttribute("board", board); // 조회만을 위해 사용함
			req.setAttribute("page", page);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
		} else if(req.getMethod().equals("POST")) {
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setContent(content);
			board.setTitle(title);
			
			svc.modifyBoard(board); // 수정
			
			// 목록페이지로 이동
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
			
		}
	}

}
