package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class ReplyCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 글번호의 댓글건수 반환
		String bno = req.getParameter("bno");
		
        ReplyService svc = new ReplyServiceImpl();
        int totalCnt = svc.totalCount(Integer.parseInt(bno));
        // {"totalCnt": 27}과 같은 형태로 보여줄 예정
        resp.getWriter().print("{\"totalCnt\": "+ totalCnt + "}");
	}

}
