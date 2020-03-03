package com.chainsys.busticketapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.BookingDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Booking;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;
import com.chainsys.busticketapp.util.logger.Logger;
import com.chainsys.busticketapp.util.mail.Mail;
@Repository
public class BookingDAOImplementation implements BookingDAO {
	Booking obj = new Booking();
	Logger logger=Logger.getInstance();
	public void addReservationList(Booking obj) throws Exception {
		try(Connection con = ConnectionUtil.getConnection();){
		
			try(CallableStatement stmt = con.prepareCall("{call ticket_booking(?,?,?,?,?,?)}");){
		stmt.setInt(1, obj.getBusNo());
		logger.info(obj.getBusNo());
		stmt.setInt(2, obj.getPassengerId());
		logger.info(obj.getPassengerId());
		stmt.setInt(3, obj.getNoOfTicket());
		stmt.setTimestamp(4, Timestamp.valueOf(obj.getJourneyDate()));
		//stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
		logger.info(obj.getNoOfTicket());
		stmt.setInt(5, obj.getUserId());
		stmt.registerOutParameter(6, Types.INTEGER);
		
		stmt.executeUpdate();
		int result=stmt.getInt(6);
		logger.info(result);
		
		String sql="select Email_id from user_register where user_id in (select user_id from reserve where status='Booked' and user_id="+obj.getUserId()+")";
		try(Statement stm=con.createStatement();){
		ResultSet rs=stm.executeQuery(sql);
		logger.debug(rs);
		String email="";
		if(rs.next()) {
			email=rs.getString("Email_id");
			logger.debug("EmailId:"+email);
		
			if(result>=100) {
			Mail.send("vignesh280519@gmail.com","6369541046",email," Your Ticket is Booked ","Thanks for using this application",obj.getPassengerId());
		}	
		}
	}
			}
		catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorMessages.NO_DATA_FOUND);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	
	}
	public void cancelReservationList(int ticketNo) throws Exception {
		String sql = "delete from reserve where ticket_no=?";
		logger.debug(sql);
		try(Connection con = ConnectionUtil.getConnection();){
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setInt(1, ticketNo);
			int row = pst.executeUpdate();
		logger.info(row);
	}
		catch (Exception e) {
			throw new DBException(ErrorMessages.NO_DATA_FOUND);
		}
	}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}
	public ArrayList<Booking> reserveDetails() throws Exception {
		String sql = "select * from reserve";
		logger.debug(sql);
		ArrayList<Booking> List = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {

			try(ResultSet rs = stmt.executeQuery(sql);){
			while (rs.next()) {
				Booking obj = new Booking();
				obj.setTicketNo(rs.getInt("ticket_no"));
				obj.setBusNo(rs.getInt("bus_no"));
				obj.setPassengerId(rs.getInt("pas_id"));
				obj.setNoOfTicket(rs.getInt("no_of_ticket"));
				obj.setJourneyDate(rs.getTimestamp("journey_date").toLocalDateTime()); 
				obj.setTotalAmount(rs.getInt("total_amount"));
				obj.setStatus(rs.getString("status"));
				obj.setUserId(rs.getInt("user_id"));
				List.add(obj);
			}
			}
			catch(SQLException e) {
				throw new Exception("Unable to execute resultset query");
			}
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
		return List;
	}

	public int getBusNo(int ticketNo) throws DBException {
		int busid = 0;
		String sql = "select bus_no from reserve where ticket_no= ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, ticketNo);
			try (ResultSet rs = pst.executeQuery();) {
				
				if (rs.next()) {
					busid = rs.getInt("bus_no");
				}
			}
			catch (Exception e) {
				throw new DBException(ErrorMessages.NO_DATA_FOUND);
			}
		} 
		
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
		return busid;
	}
	

	public void updateNoOfTicket(int ticketNo, int passengerId, int noOfTicket) throws Exception {
		int busid = getBusNo(ticketNo);

		//String sql2 = "update reserve set no_of_ticket=? where ticket_no=? and pas_id=?";
		//System.out.println(sql2);
		
		try (Connection con = ConnectionUtil.getConnection(); ) {
			String sql = "update seat_availability set available_seats= available_seats+" + noOfTicket+ " where bus_no=" + busid;
			try(Statement stmt = con.createStatement();){
				int row = stmt.executeUpdate(sql);
				String sql1 = "update reserve r set total_amount = ( (no_of_ticket - ?)*(select amount from bus_time where bus_no=r.bus_no)),"
						+ "no_of_ticket=no_of_ticket- ? where ticket_no = ?";
			try(PreparedStatement pst1 = con.prepareStatement(sql1);){
				pst1.setInt(1, noOfTicket);
				pst1.setInt(2, noOfTicket);
				pst1.setInt(3, ticketNo);
				logger.debug(sql1);
				int row1 = pst1.executeUpdate();
				logger.info(row);
				logger.info(row1);
		}
			catch(SQLException e) {
				logger.error("Unable to execute preparedstatement query");
			}
			
		}catch(SQLException e) {
			logger.error("Unable to execute statement query");
		}
			
		}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}

	}

	public ArrayList<Booking> listMyTickets(int userId) throws Exception{
		String sql="select * from reserve where user_id=?";
		logger.debug(sql);
		ArrayList<Booking> myticket = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try(PreparedStatement pst = con.prepareStatement(sql);){
				pst.setInt(1,userId );
			try(ResultSet rs = pst.executeQuery();){
			while (rs.next()) {
				Booking obj = new Booking();
				obj.setTicketNo(rs.getInt("ticket_no"));
				obj.setBusNo(rs.getInt("bus_no"));
				obj.setPassengerId(rs.getInt("pas_id"));
				obj.setNoOfTicket(rs.getInt("no_of_ticket"));
				obj.setJourneyDate(rs.getTimestamp("journey_date").toLocalDateTime()); 
				obj.setTotalAmount(rs.getInt("total_amount"));
				obj.setStatus(rs.getString("status"));
				obj.setUserId(rs.getInt("user_id"));
				myticket.add(obj);
			}
			}
			catch(SQLException e) {
				throw new Exception("Unable to execute resultset query");
			}
		}catch(SQLException e) {
			throw new Exception("Unable to execute preparestatement query");
		}
		}
			catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	
		return myticket;
		
	}
	
}