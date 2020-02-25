package com.chainsys;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.busticketapp.dao.impl.BookingDAOImplementation;
import com.chainsys.busticketapp.model.Booking;
import com.chainsys.busticketapp.model.UserRegistration;

@WebServlet("/MyTicketServlet")
public class MyTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MyTicketServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userid");
		
		HttpSession session = request.getSession();
		UserRegistration user = (UserRegistration)session.getAttribute("User");
				
		int userid=user.getUserId() ;///Integer.parseInt(userId);
		System.out.println(userid);
		BookingDAOImplementation dao= new BookingDAOImplementation();
		//Booking ul= new Booking();
		//ul.setUserId(userid);
		try {
			ArrayList<Booking> listMyTickets = dao.listMyTickets(userid);
			request.setAttribute("MyTickets",listMyTickets);
			//System.out.println(listMyTickets);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Ticketlist.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
