package com.yedam.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.mapper.BoardMapper;

public class AppTest {
  public static void main(String[] args) {
//	  ReplyService svc = new ReplyServiceImpl();
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
//	  List<ReplyVO> list = svc.replyList(221, 1);
//	  for (ReplyVO reply : list) {
//		  System.out.println(reply.toString());
//	  }
	  
    /*  selectUserByCount(); SQL구문 테스트  */
     SqlSession sqlsession = DataSource.getInstance().openSession();
     BoardMapper mapper= sqlsession.getMapper(BoardMapper.class);
     
     List<Map> list = mapper.selectUserByCount();
     
     Gson gson = new GsonBuilder().setPrettyPrinting().create();
     String json = gson.toJson(list);
     
     System.out.println(json);
	  
  }
}
