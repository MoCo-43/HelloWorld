package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class CheckControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aaaa.do?id=user01 이런 형태로 전달
		String user = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl();
		if (svc.getMemberInfo(user, pw)) {
			resp.getWriter().print("{\"retCode\" : \"Exist\"}");  // {"retCode" : "Exist"} Ajax에서 json형태로 넘김 
		} else {
			resp.getWriter().print("{\"retCode\" : \"NotExist\"}"); // {"retCode" : "NotExist"} Ajax에서 json형태로 넘김
		}

	}

}
