package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class RemoveEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");// 원본이름
		String start = req.getParameter("start");// 시작일
		String end = req.getParameter("end");// 마지막일


		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("start", start);
		map.put("end", end);

		BoardService svc = new BoardServiceImpl();
		if (svc.removeEvent(map)) {
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}

}