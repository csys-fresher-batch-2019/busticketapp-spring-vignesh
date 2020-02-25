package com.chainsys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.busticketapp.dao.impl.LoginDAOImplementation;
@WebServlet("/Adminloginservlet")
public class Adminloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Adminloginservlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
    	String password=request.getParameter("password");
		
		System.out.println(name);
		System.out.println(password);
		
		LoginDAOImplementation com=new LoginDAOImplementation();
		try {
			if(com.adminLogin(name, password)) {
				HttpSession session1=request.getSession();
				session1.setAttribute("Admin",name);	
			System.out.println("Login Success");
			response.sendRedirect("Adminportal.jsp");
				}
			else {
				System.out.println("Login faild");
				response.sendRedirect("adminlogin.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
