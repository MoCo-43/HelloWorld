package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// GET요청=화면출력, POST요청=회원등록
		if(req.getMethod().equals("GET")) {
          req.getRequestDispatcher("member/signUp.tiles").forward(req, resp);			
		} else if (req.getMethod().equals("POST")) {
		  // db insert 하고, images 폴더에 업로드 해야함
		  // MultipartRequest 생성자에 5개 값 (요청정보, 경로, 파일의최대크기, 인코딩, 리네임정책)
		  String savePath = req.getServletContext().getRealPath("images");  // 경로를 위해 생성
		  MultipartRequest mr = new MultipartRequest(
				                req,  // 요청정보
				                savePath,  // 업로드경로
				                1024 * 1024 * 5,  // 최대크기(5MB로 지정) 
				                "UTF-8",  // 인코딩방식
				                new DefaultFileRenamePolicy()  // 리네임정책
				  );
		  // db입력
		  String id = mr.getParameter("userId");
		  String pw = mr.getParameter("userPw");
		  String nm = mr.getParameter("userName");
		  String img = mr.getFilesystemName("userImg");
		  
		  // parameter 셋팅
		  MemberVO member = new MemberVO();
		  member.setMemberId(id);
		  member.setPassword(pw);
		  member.setMemberName(nm);
		  member.setImg(img);
		  
		  MemberService svc = new MemberServiceImpl();
		  if(svc.addMember(member)) {
			  resp.sendRedirect("boardList.do");
		  }
		  
		}

	}

}