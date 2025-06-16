package com.yedam.vo;

import java.util.Date;
import lombok.Data;


@Data
public class ReplyVO {
  public int replyNo;
  public int boardNo;
  public String reply;
  public String replyer;
  public Date replyDate;
}
