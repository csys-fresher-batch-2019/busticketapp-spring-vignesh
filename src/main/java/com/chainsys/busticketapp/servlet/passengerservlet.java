package com.chainsys.busticketapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.model.Passenger;
import com.chainsys.busticketapp.service.PassengerService;
@WebServlet("/passengerservlet")
public class passengerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    public passengerservlet() {
        super();
    }
    @Autowired
    PassengerService dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PassengerDAO dao=new PassengerImplementation();
		Passenger p=new Passenger();
		p.setPassengerName(request.getParameter("passengerName"));
		String age=request.getParameter("Age");
		p.setPassengerAge(Integer.parseInt(age));
		p.setPassengerGender(request.getParameter("Gender"));
		String mobileNumber=request.getParameter("mobileNumber");
		p.setPassengerContact(Long.parseLong(mobileNumber));
		if(p.getPassengerAge()>0) {
		try {
			dao.addPassengerlist(p);
			request.setAttribute("infoMessage","Passenger Added");
			response.sendRedirect("Booking.jsp");
		}
		catch(Exception e) {
			request.setAttribute("errorMessage", "Passenger Not Added");
		}
		}
		else {
		response.sendRedirect("Passengerinfo.jsp");
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
