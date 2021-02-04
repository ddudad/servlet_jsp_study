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
			//get��û�� ���� ó��
			System.out.println("GET��û�� ���Խ��ϴ�.");
		}
		else if(request.getMethod().equals("POST")) {
			//post��û�� ���� ó��
			System.out.println("POST��û�� ���Խ��ϴ�.");
		}
	}
}
