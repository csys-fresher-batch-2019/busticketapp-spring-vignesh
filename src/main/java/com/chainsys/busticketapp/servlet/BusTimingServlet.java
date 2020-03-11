package com.chainsys.busticketapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dao.SeatAvailabilityDAO;
import com.chainsys.busticketapp.dao.impl.SeatAvailabilityimplementation;
import com.chainsys.busticketapp.model.BusTiming;
import com.chainsys.busticketapp.service.BusTimingService;

@WebServlet("/BusTimingServlet")
public class BusTimingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BusTimingServlet() {
		super();
	}
	 @Autowired
	 BusTimingService obj;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String busNo = request.getParameter("busNo");
		try {

			int bNo = Integer.parseInt(busNo);
			BusTiming bustime = obj.bustimes(bNo);

			//LocalDate journeyDate = LocalDate.now();
			// List<BusTiming> List= obj.bustimeDetails();
			// System.out.println("No of BusTimings" + List.size());
			HttpSession session = request.getSession();
			session.setAttribute("Timing", bustime);
			session.setAttribute("BusNo", bNo);

			SeatAvailabilityDAO dao = new SeatAvailabilityimplementation();
			int availableseats = dao.availableSeatDetails(bNo);
			request.setAttribute("AVAILABLE_SEATS", availableseats);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rs = request.getRequestDispatcher("viewavailablebus.jsp?BusNo=" + busNo);
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
