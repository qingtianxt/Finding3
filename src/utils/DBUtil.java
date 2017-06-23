package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String userName = "wzw";
//	private static String userName = "root";
	private static String userPwd = "121203";
	private static String dbName = "day09";
	private static String url1 = "jdbc:mysql://localhost:3306/" + dbName;
	private static String url2 = "?user=" + userName + "&password=" + userPwd;
	private static String url3 = "&useUnicode=true&characterEncoding=UTF-8";
	private static String url = url1 + url2 + url3;
	
	public static void main(String[] args) {
		Connection conn = getConn();
		closeDB(conn, null, null);
	}
	
	public static Connection getConn()
	{
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeDB(Connection conn,PreparedStatement pstmt,ResultSet rs)
	{
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void close(ResultSet rs,Statement state,Connection conn){
		if(rs!=null)
		{
			try{
				rs.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(state!=null)
		{
			try{
				state.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try{
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
}
