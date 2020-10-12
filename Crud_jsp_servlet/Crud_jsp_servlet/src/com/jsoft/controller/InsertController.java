package com.jsoft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsoft.dao.InsertDao;
import com.jsoft.daoImpl.InsertDaoImpl;
import com.jsoft.pojo.UserBean;

@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean=new UserBean();
		userBean.setId(Integer.parseInt(request.getParameter("id")) );
		InsertDao insertDao=new InsertDaoImpl();
		insertDao.delete(userBean);
		
		response.sendRedirect("crud.jsp");
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean=new UserBean();
		InsertDao insertDao=new InsertDaoImpl();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		/*String contact=request.getParameter("contact");
		int age=Integer.parseInt(request.getParameter("age"));*/
		userBean.setUname(uname);
		userBean.setPwd(pwd);
		userBean.setEmail(email);
		userBean.setContact(request.getParameter("contact"));
		userBean.setAge(Integer.parseInt(request.getParameter("age")));
		String button = request.getParameter("submit");
		//System.out.println(uname+pwd+email+contact+age);
		if(button.equals("Save")){
		insertDao.insertValues(userBean);
		}
		
		else if(button.equals("update")){
			userBean.setId(Integer.parseInt(request.getParameter("id")) );
			insertDao.updateValues(userBean);
			System.out.println(button);
			
			}
		response.sendRedirect("crud.jsp");
		
		
	}

}
