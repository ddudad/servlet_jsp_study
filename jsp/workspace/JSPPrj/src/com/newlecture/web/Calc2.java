package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//application객체 받아올 변수 선언
		ServletContext application = request.getServletContext();
		
		//session객체 받아올 변수 선언
		//기본적인 사용법은 application, session 둘 다 똑같다.
		//getAttribute(), setAttribute() 
		HttpSession session = request.getSession();
		
		//cookie 받아올 변수 선언
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		//계산하기
		if(op.equals("=")) {
			//int x = (Integer)application.getAttribute("value");
			//int x = (Integer)session.getAttribute("value");
			//cookies 중에서 찾아야 함.
			int x = 0;
			for(Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			int y = v;
			//String operator = (String)application.getAttribute("op");
			//String operator = (String)session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) {
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			int result = 0;
			
			if(operator.equals("+")) {
				result = x+y;
			}
			else {
				result=x-y;
			}
			out.printf("result is %d\n", result);
		}
		//값을 저장하기
		else {
			//application객체에 저장하기
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			
			//session객체에 저장하기
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);
			
			//cookie에 저장하기
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/");
			opCookie.setPath("/");
			//client에 cookie 전달하기
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			//calc2.html 리턴
			response.sendRedirect("calc2.html");
		}
	}
}
