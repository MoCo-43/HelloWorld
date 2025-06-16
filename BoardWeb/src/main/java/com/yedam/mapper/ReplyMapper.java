package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {

	public int insertReply(ReplyVO rvo);  // 추가
	public List<ReplyVO>selectReply(@Param("bno")int bno, @Param("page") int page);  // 목록
	public ReplyVO getReply(int rvo);  // 단건댓글 
	public int removeReply(int rvo);  // 삭제
	public int selectTotal(int bno);
}
