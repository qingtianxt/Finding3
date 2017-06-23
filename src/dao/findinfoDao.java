package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.User;
import domain.losefindinfo;
import utils.DBUtil;

public class findinfoDao {
	//����ʱ��˳�򷵻ظ��û���ʧ��Ʒ����Ϣ 
	public List<losefindinfo> getLoseinfobyUser(String user) {
		List<losefindinfo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = null;
		String sql = "select * from message1 where user=? order by date desc";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();
			while(rs.next()){
				l= new losefindinfo();
				l.setNumber(Integer.parseInt(rs.getString("number")));
				l.setUser(rs.getString("user"));
				l.setAddress(rs.getString("address"));
				l.setCategory(rs.getString("category"));
				l.setDatetime(rs.getString("date"));
				l.setImage(rs.getString("image"));
				l.setInformation(rs.getString("information"));
				l.setPhone(rs.getString("phone"));
				l.setReleasetime(rs.getString("release"));
				l.setShorttitle(rs.getString("shorttitle"));
				l.setPlace(rs.getString("place"));
				list.add(l);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		}
		return list;
	}
//����ʱ��˳�򷵻ظ��û��ҵ���Ʒ����Ϣ
	public List<losefindinfo> getFindinfobyUser(String user) {
		List<losefindinfo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = null;
		String sql = "select * from message2 where user=? order by date desc";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();
			while(rs.next()){
				l= new losefindinfo();
				l.setNumber(Integer.parseInt(rs.getString("number")));
				l.setUser(rs.getString("user"));
				l.setAddress(rs.getString("address"));
				l.setCategory(rs.getString("category"));
				l.setDatetime(rs.getString("date"));
				l.setImage(rs.getString("image"));
				l.setInformation(rs.getString("information"));
				l.setPhone(rs.getString("phone"));
				l.setReleasetime(rs.getString("release"));
				l.setShorttitle(rs.getString("shorttitle"));
				l.setPlace(rs.getString("place"));
				list.add(l);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		}
		return list;
	}
	/**
	 * ����ȡ���Ķ�ʧ��Ϣ�浽message1����
	 * @param lfi
	 * @return
	 */
	public boolean insertlose(losefindinfo lfi) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = null;
		String sql = "insert into message1 values(?,?,?,?,?,?,?,?,?,?,?)";
		int i=0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, lfi.getUser());
			pstmt.setString(3, lfi.getAddress());
			pstmt.setString(4, lfi.getCategory());
			pstmt.setString(5, lfi.getDatetime());
			pstmt.setString(6, lfi.getImage());
			pstmt.setString(7,lfi.getInformation());
			pstmt.setString(8, lfi.getPhone());
			pstmt.setString(9,lfi.getReleasetime());
			pstmt.setString(10, lfi.getShorttitle());
			pstmt.setString(11,lfi.getPlace());
			i = pstmt.executeUpdate();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		}
		boolean flag= true;
		if(i==0){
			flag= false;
		}
		return flag;
	}
	/**
	 * ���ҵ�����Ϣ�浽message2����
	 * @param lfi
	 * @return
	 */
	public boolean insertfind(losefindinfo lfi) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = null;
		String sql = "insert into message2 values(?,?,?,?,?,?,?,?,?,?,?)";
		int i=0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, lfi.getUser());
			pstmt.setString(3, lfi.getAddress());
			pstmt.setString(4, lfi.getCategory());
			pstmt.setString(5, lfi.getDatetime());
			pstmt.setString(6, lfi.getImage());
			pstmt.setString(7,lfi.getInformation());
			pstmt.setString(8, lfi.getPhone());
			pstmt.setString(9,lfi.getReleasetime());
			pstmt.setString(10, lfi.getShorttitle());
			pstmt.setString(11,lfi.getPlace());
			i = pstmt.executeUpdate();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		boolean flag= true;
		if(i==0){
			flag= false;
		}
		return flag;
	}
	
	
	
	
	
	
	/**
	 * ͨ����Ʒ�����ͷ���������Ϣ
	 * @param type
	 * @return
	 */
	public List<losefindinfo> findbytype(String type) {
		List<losefindinfo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = null;
		String sql = "select * from message2 where category=? order by date desc";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while(rs.next()){
				l= new losefindinfo();
				l.setNumber(Integer.parseInt(rs.getString("number")));
				l.setUser(rs.getString("user"));
				l.setAddress(rs.getString("address"));
				l.setCategory(rs.getString("category"));
				l.setDatetime(rs.getString("date"));
				l.setImage(rs.getString("image"));
				l.setInformation(rs.getString("information"));
				l.setPhone(rs.getString("phone"));
				l.setReleasetime(rs.getString("release"));
				l.setShorttitle(rs.getString("shorttitle"));
				l.setPlace(rs.getString("place"));
				list.add(l);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		return list;
	}
	
	
	
	/**
	 * ͨ����Ʒ�����ͷ���������Ϣ
	 * @param type
	 * @return
	 */
	public List<losefindinfo> losebytype(String type) {
		List<losefindinfo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = null;
		String sql = "select * from message1 where category=? order by date desc";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while(rs.next()){
				l= new losefindinfo();
				l.setNumber(Integer.parseInt(rs.getString("number")));
				l.setUser(rs.getString("user"));
				l.setAddress(rs.getString("address"));
				l.setCategory(rs.getString("category"));
				l.setDatetime(rs.getString("date"));
				l.setImage(rs.getString("image"));
				l.setInformation(rs.getString("information"));
				l.setPhone(rs.getString("phone"));
				l.setReleasetime(rs.getString("release"));
				l.setShorttitle(rs.getString("shorttitle"));
				l.setPlace(rs.getString("place"));
				list.add(l);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		return list;
	}
	/**
	 * ͨ��number����ȡ��ʧ����Ϣ
	 * @param id
	 * @return
	 */
	public losefindinfo getinfobyId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = new losefindinfo();
		String sql = "select * from message1 where number=?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				l.setNumber(Integer.parseInt(rs.getString("number")));
				l.setUser(rs.getString("user"));
				l.setAddress(rs.getString("address"));
				l.setCategory(rs.getString("category"));
				l.setDatetime(rs.getString("date"));
				l.setImage(rs.getString("image"));
				l.setInformation(rs.getString("information"));
				l.setPhone(rs.getString("phone"));
				l.setReleasetime(rs.getString("release"));
				l.setShorttitle(rs.getString("shorttitle"));
				l.setPlace(rs.getString("place"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		return l;
	}
	/**
	 * ͨ��number��ȡ������Ϣ
	 * @param id
	 * @return
	 */
	public losefindinfo getinfobyId1(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = new losefindinfo();
		String sql = "select * from message2 where number=?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				l.setNumber(Integer.parseInt(rs.getString("number")));
				l.setUser(rs.getString("user"));
				l.setAddress(rs.getString("address"));
				l.setCategory(rs.getString("category"));
				l.setDatetime(rs.getString("date"));
				l.setImage(rs.getString("image"));
				l.setInformation(rs.getString("information"));
				l.setPhone(rs.getString("phone"));
				l.setReleasetime(rs.getString("release"));
				l.setShorttitle(rs.getString("shorttitle"));
				l.setPlace(rs.getString("place"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		return l;
	}
	public List<losefindinfo> getfindinfo() {
		List<losefindinfo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = new losefindinfo();
		String sql = "select * from message2 order by date desc";
		
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				l= new losefindinfo();
				l.setNumber(Integer.parseInt(rs.getString("number")));
				l.setUser(rs.getString("user"));
				l.setAddress(rs.getString("address"));
				l.setCategory(rs.getString("category"));
				l.setDatetime(rs.getString("date"));
				l.setImage(rs.getString("image"));
				l.setInformation(rs.getString("information"));
				l.setPhone(rs.getString("phone"));
				l.setReleasetime(rs.getString("release"));
				l.setShorttitle(rs.getString("shorttitle"));
				l.setPlace(rs.getString("place"));
				list.add(l);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<losefindinfo> getloseinfo() {
		List<losefindinfo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = new losefindinfo();
		String sql = "select * from message1 order by date desc";
		
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				l= new losefindinfo();
				l.setNumber(Integer.parseInt(rs.getString("number")));
				l.setUser(rs.getString("user"));
				l.setAddress(rs.getString("address"));
				l.setCategory(rs.getString("category"));
				l.setDatetime(rs.getString("date"));
				l.setImage(rs.getString("image"));
				l.setInformation(rs.getString("information"));
				l.setPhone(rs.getString("phone"));
				l.setReleasetime(rs.getString("release"));
				l.setShorttitle(rs.getString("shorttitle"));
				l.setPlace(rs.getString("place"));
				
				list.add(l);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		return list;
	}
	/**
	 * ����numberɾ���û�Ѱ����Ϣ
	 * @param number
	 * @return
	 */
	public boolean deleteinfo1(String number) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = null;
		String sql = "delete from message1 where number=?";
		System.out.println(1);
		int i=0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			i = pstmt.executeUpdate();
			System.out.println(2);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		boolean flag= true;
		if(i==0){
			flag= false;
		}
		System.out.println(3);
		return flag;
	}
	/**
	 * ����numberɾ���û�������Ϣ
	 * @param number
	 * @return
	 */
	public boolean deleteinfo2(String number) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		losefindinfo l = null;
		String sql = "delete from message2 where number=?";
		System.out.println(1);
		int i=0;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			i = pstmt.executeUpdate();
			System.out.println(2);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {DBUtil.closeDB(conn, pstmt, rs);
		}
		boolean flag= true;
		if(i==0){
			flag= false;
		}
		System.out.println(3);
		return flag;
	}
	
}	
