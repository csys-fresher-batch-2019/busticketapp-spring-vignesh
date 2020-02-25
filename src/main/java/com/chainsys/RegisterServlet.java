package com.chainsys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.busticketapp.dao.impl.UserRegistrationDAOImplementation;
import com.chainsys.busticketapp.model.UserRegistration;

@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long contact = Long.parseLong(request.getParameter("contactNumber"));
		//int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println(email);
		System.out.println(name);
		System.out.println(password);
		System.out.println(contact);
		//System.out.println(userid);

		UserRegistrationDAOImplementation dao = new UserRegistrationDAOImplementation();
		UserRegistration ul = new UserRegistration();
		ul.setContactNumber(contact);
		ul.setEmailId(email);
		ul.setPassword(password);
		//ul.setUserId(userid);
		ul.setUserName(name);
		try {
			dao.newUserRegister(ul);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("userlogin.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
