package com.yedam.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class BoardListControl implements Control {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("글목록");
        // 여기에 페이지 이동 or 출력 로직 작성
    }
}