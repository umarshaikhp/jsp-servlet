package com.jsoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsoft.dao.LoginDao;
import com.jsoft.daoImpl.LoginDaoImpl;
import com.jsoft.pojo.RegisterBean;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RegisterBean registerBean=new RegisterBean();
	registerBean.setUsername(request.getParameter("uname"));
	registerBean.setPassword(request.getParameter("pwd"));
	LoginDao loginDao=new LoginDaoImpl();
	if(loginDao.checkauthentication(registerBean)){
		response.sendRedirect("crud.jsp");
	}else{
		response.sendRedirect("failed.jsp");
	}
	
	}

}
