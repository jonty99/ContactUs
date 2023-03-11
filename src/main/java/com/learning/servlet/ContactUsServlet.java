package com.learning.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.dao.RequestDao;
import com.learning.object.Request;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("ContactUs.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Request contReq = new Request();
		contReq.setFullName(req.getParameter("username"));
		contReq.setEmailId(req.getParameter("email"));
		contReq.setMessage(req.getParameter("msg"));

		RequestDao requestDao = new RequestDao();

		try {
			if (requestDao.saveRequest(contReq)) {
				resp.getWriter().println("Thanks for contact");
				doGet(req, resp);
			}

			else {
				resp.getWriter().println("Data cannot be saved");
			}

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
