package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Control  {
    void exec(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException; // throw 뒤에 문이 try-catch문 제거
}