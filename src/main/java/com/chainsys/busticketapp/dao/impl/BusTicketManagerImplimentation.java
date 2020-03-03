package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.BusTicketDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.BusTiming;
import com.chainsys.busticketapp.model.ListOfBuses;
import com.chainsys.busticketapp.model.SeatAvailability;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;
import com.chainsys.busticketapp.util.logger.Logger;
@Repository
public class BusTicketManagerImplimentation implements BusTicketDAO {
	private int busCount;

	public int getBusCount() {
		return busCount;
	}

	public void setBusCount(int busCount) {
		this.busCount = busCount;
	}

	Logger logger = Logger.getInstance();

	public void addBuslist(String busName, String busSource, String busDestination, String clazz)
			throws Exception {
		String sql = "insert into bus_list (bus_no,bus_name,bus_source,bus_destination,class)values(bus_no_seq.nextval,?,?,?,?)";

		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement pst = con.prepareStatement(sql);) {

				logger.debug(sql);

				//pst.setInt(1, busNo);
				pst.setString(1, busName);
				pst.setString(2, busSource);
				pst.setString(3, busDestination);
				pst.setString(4, clazz);
				int row = pst.executeUpdate();
				logger.info(row);

			} catch (Exception e) {
				throw new DBException(ErrorMessages.INORRECT_VALUE);
			}
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public void deleteBuslist(int busNo) throws Exception {
		String sql1 = "delete from seat_availability where bus_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setInt(1, busNo);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
		String sql2 = "delete from bus_time where bus_no=?";
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement pst = con.prepareStatement(sql2);) {
				pst.setInt(1, busNo);
				pst.executeUpdate();
			} catch (SQLException e) {
				throw new Exception("unable to execute preparedstatement query");
			}
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
		String sql = "delete from bus_list where bus_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, busNo);
			pst.executeUpdate();
			logger.info(busNo + " Bus Details are delete successfully");
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public int noOfBuses() throws Exception {
		String sql = "select count(*) as busCount  from bus_list";
		logger.debug(sql);

		try (Connection con = ConnectionUtil.getConnection();) {
			try (Statement stmt = con.createStatement();) {
				try (ResultSet rs = stmt.executeQuery(sql);) {

					if (rs.next()) {
						busCount = rs.getInt("busCount");
					}
				} catch (Exception e) {
					throw new DBException(ErrorMessages.NO_DATA_FOUND);
				}
			} catch (SQLException e) {
				throw new Exception("Unable to execute query");
			}
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
		return busCount;

	}

	// String sql = "select bus_name,bl.bus_no, bt.time from bus_list bl, bus_timing
	// bt where bl.bus_no = bt.bus_no";
	public HashMap<String, Integer> noOfBuslist() throws Exception {
		String sql = "select bus_name,bus_no from bus_list";
		logger.debug(sql);
		HashMap<String, Integer> obj = new HashMap<String, Integer>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {

				while (rs.next()) {
					// System.out.println(""+rs.getString("bus_name"));
					String busName = rs.getString("bus_name");
					int busNo = rs.getInt("bus_no");
					obj.put(busName, busNo);
				}

			} catch (SQLException e) {
				throw new Exception("Unable to execute resultset query");
			}
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
		return obj;
	}

	public List<ListOfBuses> sourceStationlist(String busSource, String busDestination) throws DBException {
		String sql = "select * from bus_list_view where bus_source=? and bus_destination=?";
		
		List<ListOfBuses> source = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setString(1, busSource);
				pst.setString(2, busDestination);
				try (ResultSet rs = pst.executeQuery();) {
					// System.out.println("BusNo:\tSource:\tDestination\tBusName:\tClass:");
					while (rs.next()) {
						ListOfBuses p = new ListOfBuses();
						p.setBusNo(rs.getInt("bus_no"));
						p.setBusName(rs.getString("bus_name"));
						p.setBusSource(rs.getString("bus_source"));
						p.setBusDestination(rs.getString("bus_destination"));
						p.setClazz(rs.getString("class"));
						p.setAmount(rs.getInt("amount"));
						SeatAvailability s = new SeatAvailability();
						s.setTotalSeats(rs.getInt("total_seats"));
						s.setAvailableSeats(rs.getInt("available_seats"));
						p.setSeatAvailability(s);
						BusTiming bt = new BusTiming();
						bt.setDepartureTime(rs.getTime("departure_time").toLocalTime());
						p.setBusTiming(bt);

						source.add(p);
					}
				}
			}
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		return source;
	}

}
