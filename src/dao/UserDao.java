package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.User;
import utils.DBUtil;

public class UserDao {
/**
 * 通过登录获取该用户的信息
 * @param user
 * @param password
 * @return
 */
	public User login(String user, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		User s = null;
		String sql = "select * from user where user=? and password=?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				s= new User();
				s.setUser(rs.getString("user"));
				s.setPassword(rs.getString("password"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getString("phone"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeDB(conn, pstmt, rs);
		}
		return s;
	}

	public boolean register(User u) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		User s = null;
		String sql = "insert into user values(?,?,?,?,?,?)";
		int i = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUser());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getImage());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getPhone());
			pstmt.setString(6, u.getDate());
			i = pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(conn, pstmt, rs);
		}
		boolean flag= true;
		if(i==0){
			flag= false;
		}
		return flag;
	}
/**
 * 获取账号的基本信息
 * @param user
 * @return
 */
	public User getinfo(String user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		User s = null;
		String sql = "select * from user where user=?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();
			if(rs.next()){
				s= new User();
				s.setUser(rs.getString("user"));
				s.setImage(rs.getString("image"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getString("phone"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeDB(conn, pstmt, rs);
		}
		return s;
	}
/**
 * 重新设置账户信息
 * @param password
 * @param email
 * @param phone
 * @return
 */
public boolean reset(String password, String email, String phone,String user) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	conn = DBUtil.getConn();
	User s = null;
	String sql = "update user set password=?,email=?,phone=? where user='"+user+"'";
	int i = 0;
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, email);
		pstmt.setString(3, phone);
		i = pstmt.executeUpdate();
	}
	catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBUtil.closeDB(conn, pstmt, rs);
	}
	boolean flag= true;
	if(i==0){
		flag= false;
	}
	return flag;
}

	
}
