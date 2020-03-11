package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.model.Booking;
import com.chainsys.busticketapp.model.BusTiming;
import com.chainsys.busticketapp.model.UserRegistration;
import com.chainsys.busticketapp.service.ReservationService;
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookingServlet() {
        super();
    }
    @Autowired
    ReservationService dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String passengerId=request.getParameter("passengerid");
			String noOfTicket=request.getParameter("noOfTicket");
			String journeyDate=request.getParameter("journeydate");
			//int passengerid = Integer.parseInt(request.getParameter("passengerid"));
			//int noOfTicket = Integer.parseInt(request.getParameter("noOfTicket"));
		
		int passengerid=Integer.parseInt(passengerId);
		int noofticket=Integer.parseInt(noOfTicket);
		LocalDate journeydate=LocalDate.parse(journeyDate);
		HttpSession session=request.getSession();
		Integer busno = (Integer)session.getAttribute("BusNo");
		
		BusTiming bustime =(BusTiming)session.getAttribute("Timing");
		
		System.out.println(busno);
		System.out.println(passengerid);
		System.out.println(noofticket);
		System.out.println(journeydate);
		//BookingDAOImplementation dao= new BookingDAOImplementation();
		Booking ul= new Booking();
		ul.setBusNo(busno);
		ul.setPassengerId(passengerid);
		ul.setNoOfTicket(noofticket);
		String time = bustime.getDepartureTime().toString();
		System.out.println(time);//"10:00";
		LocalDateTime jDate = LocalDateTime.parse(journeyDate + "T" + time); 
		ul.setJourneyDate(jDate);
		
		UserRegistration user = (UserRegistration)session.getAttribute("User");
		ul.setUserId(user.getUserId());
		
		System.out.println(ul);
		try {
			dao.addReservationList(ul);
			response.sendRedirect("welcomepage.jsp?infoMessage=Success");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Booking.jsp?BusNo="+ ul.getBusNo() + "&errorMessage=" + e.getMessage());
		}

	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
