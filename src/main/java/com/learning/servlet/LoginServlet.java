package com.learning.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.dao.UserDao;
import com.learning.object.CreateUser;
import com.learning.object.Request;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session= req.getSession();
		CreateUser cu = new CreateUser();
		
		cu.setUsername(req.getParameter("email"));
		cu.setPassword(req.getParameter("pwd"));
		
		String userName=req.getParameter("email");
		
		
		UserDao userDao=new UserDao();
		
		try
		{
			if(userDao.verifyCredentials(cu))
			{
				session.setAttribute("Username",userName );
				resp.sendRedirect("DashBoard.jsp");
			}
			
			else
			{
				resp.sendRedirect("login.jsp");
			}
		
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

		
	}

}
