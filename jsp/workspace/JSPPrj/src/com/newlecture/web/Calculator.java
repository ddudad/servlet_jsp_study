package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			//get요청에 대한 처리
			System.out.println("GET요청이 들어왔습니다.");
		}
		else if(request.getMethod().equals("POST")) {
			//post요청에 대한 처리
			System.out.println("POST요청이 들어왔습니다.");
		}
	}
}
