package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// rno을 삭제
		String rno = req.getParameter("rno");

		// 객체 처리
		ReplyService svc = new ReplyServiceImpl();
		if(svc.removeReply(Integer.parseInt(rno))) {
			//{"retCode": "Success"} 성공하면 출력
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		} else {
			//{"retCode": "Fail"} 실패하면 출력
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}

}
