package com.jsoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsoft.dao.RegisterDao;
import com.jsoft.daoImpl.RegisterDaoImpl;
import com.jsoft.pojo.RegisterBean;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterBean registerBean=new RegisterBean();
		registerBean.setFname(request.getParameter("fname"));
		registerBean.setLname(request.getParameter("lname"));
		registerBean.setUsername(request.getParameter("username"));
		registerBean.setPassword(request.getParameter("pwd"));
		registerBean.setGender(request.getParameter("gender"));
		registerBean.setMno(request.getParameter("mno"));
		registerBean.setAno(request.getParameter("ano"));
		registerBean.setAddress(request.getParameter("address"));
		registerBean.setDte(request.getParameter("dte"));
		RegisterDao registerDao=new RegisterDaoImpl();
		registerDao.registerAdd(registerBean);
		response.sendRedirect("register.jsp");
		
	}

}
