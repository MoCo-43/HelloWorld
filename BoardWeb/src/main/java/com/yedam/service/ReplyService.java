package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
 public boolean addReply(ReplyVO rvo);  // 댓글추가
 public List<ReplyVO> replyList(int bno);  // 댓글목록
 public ReplyVO getReply(int rno);  // 단건조회
 public boolean removeReply(int rvo);  // 댓글삭제
}
