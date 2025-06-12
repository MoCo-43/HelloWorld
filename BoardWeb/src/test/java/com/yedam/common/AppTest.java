package com.yedam.common;

import java.util.List;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
  public static void main(String[] args) {
	  ReplyService svc = new ReplyServiceImpl();
	  
	  // 입력
//	  ReplyVO rep = new ReplyVO();
//	  rep.setBoardNo(221);
//	  rep.setReply("댓글없음 ㅅㄱ");
//	  rep.setReplyer("newbie");
//	  svc.addReply(rep);
//	  
//	  // 삭제
//	  svc.removeReply(7);
	  
	  
	  // 목록
	  List<ReplyVO> list = svc.replyList(221);
	  for (ReplyVO reply : list) {
		  System.out.println(reply.toString());
	  }
  }
}
