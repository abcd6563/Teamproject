package com.woodmall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.MemberDao;
import com.woodmall.dto.MemberVo;




@WebServlet("/memberMypage.do")
public class MemberMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("userId");
		
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		
		mVo = mDao.getMember(userId);
		System.out.println(mVo);
		request.setAttribute("member", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberMypage.jsp");
		dispatcher.forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
