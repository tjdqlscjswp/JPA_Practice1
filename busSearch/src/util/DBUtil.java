package util;

import java.sql.*;

public class DBUtil {
	
	//1. DB 연결을 만들어준다.
	public static Connection getConnection() {
		Connection conn = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";// connect 하려면 드라이버 이름을 꼭 알아야함
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr", password = "hr";
		
		try {
			Class.forName(driverName); //드라이버를 메모리에 올린다.
			conn = DriverManager.getConnection(url, userid, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	//2. 자원을 반납해준다.
	public static void dbClose(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
