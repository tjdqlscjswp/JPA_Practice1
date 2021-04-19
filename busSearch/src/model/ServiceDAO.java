package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import util.DBUtil;
import util.LoggableStatement;

public class ServiceDAO {
	// 버스 번호 입력하여 노선 조회
	public List<BusStopsVO> selectByNo(int busNo) {
		List<BusStopsVO> stopsList = new ArrayList<>();
		Connection conn = null;
		conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = " select stopNo, stopName"
				+ " from bus join visit on bus.bus_no = visit.vBusNo join stops on visit.vStopNo = stops.stopNo"
				+ " where bus.bus_no = ?";

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, busNo);
			rs = st.executeQuery();
			while (rs.next()) {

				stopsList.add(makeStops(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return stopsList;

	}

	public static BusStopsVO makeStops(ResultSet rs) throws SQLException {
		BusStopsVO stops = new BusStopsVO();
		stops.setStop_number(rs.getInt("stopNo"));
		stops.setStop_name(rs.getString("stopName"));

		return stops;
	}

	public static VisitVO makeRes(ResultSet rs) throws SQLException {
		VisitVO stops = new VisitVO();
		stops.setBus_number(rs.getInt("bus_no"));
		stops.setStop_number(rs.getInt("stopNo"));
		stops.setStop_name(rs.getString("stopName"));

		return stops;
	}

	public int PassengerSignIn(String id, String password, String name) {
		Connection conn = null;
		conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into passenger values(?, ?, ?)";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, password);
			st.setString(3, name);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;

	}

	public int login(String loginId, String loginPass) {
		Connection conn = null;
		conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "select * from passenger where passenger_id = ? and passenger_password=?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, loginId);
			st.setString(2, loginPass);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}

	public List<VisitVO> searchByDest(String depart, String arrive) {
		Connection conn = null;
		conn = DBUtil.getConnection();
		PreparedStatement st = null;
		List<VisitVO> res = new ArrayList<>();
		int cnt = 0;
		ResultSet rs = null;
		String sql = " select stopNo, stopName, bus_no"
				+ " from stops join visit on stops.stopNo = visit.vStopNo join bus on visit.vBusNo = bus.bus_no"
				+ " where visit.vStopNo between" + " (select stops.stopNo" + " from stops"
				+ " where stops.stopName = ?) and" + " (select stops.stopNo" + " from stops"
				+ " where stops.stopName = ?)";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, depart);
			st.setString(2, arrive);
			rs = st.executeQuery();

			while (rs.next()) {
				res.add(makeRes(rs));
				cnt++;

			}
			if (cnt < 6) {
				System.out.println("운임: 1200원");
				System.out.println("예상소요시간: 약" + (cnt * 2) + "분");
			} else {
				System.out.println("운임: " + (1200 + cnt * 30) + "원");
				System.out.println("예상소요시간: 약" + (cnt * 3) + "분");
			}

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return res;

	}

	public int adminLogin(String adminId, String adminPass) {
		Connection conn = null;
		conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "select * from adstaff where adminId = ? and adminPassword=?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, adminId);
			st.setString(2, adminPass);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;

	}

	public int addStops( int addStopno, String addStopName) {
		Connection conn = null;
		conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		int result = 0;
		String sql = "insert into stops values(?, ?)";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, addStopno);
			st.setString(2, addStopName);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;

	}

	public int addBusno(int addBusno, int addStopno) {
		Connection conn = null;
		conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		int result = 0;
		String sql = "insert into visit values(?, ?)";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, addBusno);
			st.setInt(2, addStopno);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
	}

	public int delete(int deleteBusNo, int deleteStopNo) {
		Connection conn = null;
		conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		int result = 0;
		String sql = "delete from visit where vBusNo = ? and vStopNo = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deleteBusNo);
			st.setInt(2, deleteStopNo);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
		
	}

}
