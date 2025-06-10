package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  // id, pw 활용 -> 로그인 기능 구현
      String id = req.getParameter("mid");
      String pw = req.getParameter("pass");
      //로그인
      MemberService svc = new MemberServiceImpl();
      MemberVO member = svc.login(id, pw);
      // 로그인 성공여부 체크
      if(member != null) {
    	// 글등록화면
    	// 세션객체에 setAttribute("logId", member.memberId)
    	HttpSession session = req.getSession();  // cookie
    	session.setAttribute("logId", member.getMemberId());  // 어떠한 페이지에서도 접근가능  // 생명주기가 긺
    	
    	resp.sendRedirect("addBoard.do");
      } else {
    	// 로그인화면으로 이동
    	req.setAttribute("msg", "ID와 PW를 확인하세요");
    	req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
      }
      
	}

}
