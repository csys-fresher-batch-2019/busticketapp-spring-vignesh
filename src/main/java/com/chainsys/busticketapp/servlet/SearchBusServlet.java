package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.model.Buses;
import com.chainsys.busticketapp.service.BusService;

@WebServlet("/SearchBusServlet")
public class SearchBusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SearchBusServlet() {
		super();
	}

	@Autowired
	BusService dao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// BusDAO dao = new BusDAOImplementation();
		String BusSource = request.getParameter("source");
		String BusDestination = request.getParameter("destination");
		String journeydate = request.getParameter("journeydate");

		HttpSession sessiondate = request.getSession();
		sessiondate.setAttribute("journeydate", journeydate);
		try {
			List<Buses> list = dao.findBySourceAndDestination(BusSource, BusDestination);
			request.setAttribute("busList", list);
			// dao.sourceStationlist(BusSource, BusDestination);
			RequestDispatcher rs = request.getRequestDispatcher("NoOfBuses.jsp");
			rs.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("searchbus.jsp?errorMessage=" + e.getMessage());
		}
//		RequestDispatcher rs = request.getRequestDispatcher("NoOfBuses.jsp");
//		rs.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
