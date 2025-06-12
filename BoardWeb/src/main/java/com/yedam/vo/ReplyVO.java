package com.yedam.vo;

import lombok.Data;
import oracle.sql.DATE;

@Data
public class ReplyVO {
  public int replyNo;
  public int boardNo;
  public String reply;
  public String replyer;
  public DATE replyDate;
}
