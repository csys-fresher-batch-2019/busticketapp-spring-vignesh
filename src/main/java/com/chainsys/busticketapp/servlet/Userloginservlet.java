package com.chainsys.busticketapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.model.User;
import com.chainsys.busticketapp.service.LoginService;

@WebServlet("/Userloginservlet")
public class Userloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	LoginService com;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ServiceLogin com=new ServiceLogin();

		String EmailId = request.getParameter("Email_id");
		// int userId=Integer.parseInt(UserName);
		// boolean result=false;
		// PrintWriter out=response.getWriter();
		String password = request.getParameter("password");
		System.out.println(EmailId);
		System.out.println(password);

		try {
			User user = com.user(EmailId, password);
			if (user != null) {
				System.out.println("Login Success");
				HttpSession session = request.getSession();
				session.setAttribute("User", user);
				response.sendRedirect("homeuser.jsp");
			} else {
				// response.sendRedirect("userlogin.jsp?errorMessage=Invalid login");
				System.out.println("Login failed");

			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("userlogin.jsp?errorMessage=Invalid login");
		}

	}

}
