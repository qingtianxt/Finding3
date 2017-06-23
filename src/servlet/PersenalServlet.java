package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.findinfoDao;
import domain.User;
import domain.losefindinfo;

/**
 * Servlet implementation class PersenalServlet
 */
@WebServlet("/Persenal")
public class PersenalServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String method = req.getParameter("method");
		
		if(method.equals("login")){
			login(req,resp);
		}else if(method.equals("insert")){
			insert(req,resp);
		}else if(method.equals("update")){
			update(req,resp);
		}else if(method.equals("updateinfo")){
			deleteinfo(req,resp);
		}
	}
	private void deleteinfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("status");
		String number = req.getParameter("id");
		boolean flag= true;
		findinfoDao dao = new findinfoDao();
		if(type.equals("1")){
			flag=dao.deleteinfo1(number);
		}
		else {
			flag=dao.deleteinfo2(number);
		}
		System.out.println(flag);
		if(flag==true){
			resp.sendRedirect("Persenal?method=login&status=5");
		}
		else
		{
			resp.sendRedirect("Persenal?method=login&status=6");
		}
	}
	/**
	 * 修改账户的个人信息
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String user = req.getParameter("user");
		String password = req.getParameter("repassword");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		UserDao dao =new UserDao();
		boolean flag=dao.reset(password,email,phone,user);
		User u = dao.getinfo(user);
		if(flag==true){
			resp.sendRedirect("Persenal?method=login&status=3");
			//req.getRequestDispatcher("Persenal.jsp?status1=1").forward(req, resp);
		}
		else
		{
			resp.sendRedirect("Persenal?method=login&status=4");
			//req.getRequestDispatcher("Persenal.jsp?status1=2").forward(req, resp);
		}
	}

	/**丢失物品或者捡到物品的信息的发布
	 * 通过填表单进行
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String status = req.getParameter("status");
		
		losefindinfo lfi = new losefindinfo();
		lfi.setCategory(req.getParameter("category"));
		lfi.setPlace(req.getParameter("place"));
		lfi.setDatetime(req.getParameter("date"));
		lfi.setInformation(req.getParameter("infomation"));
		lfi.setShorttitle(req.getParameter("shorttitle"));
		
		
		User user = (User)req.getSession().getAttribute("user");
		
		
		UserDao dao = new UserDao();
		User u = dao.getinfo(user.getUser());
		
		lfi.setAddress(u.getEmail());
		lfi.setPhone(u.getPhone());
		lfi.setUser(u.getUser());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		lfi.setReleasetime(date);
		
		
		
		
		findinfoDao dao1  = new findinfoDao();
		
		
		boolean flag=true;
		if(status.equals("1")){
			flag=dao1.insertlose(lfi);
		}
		else
		{
			flag=dao1.insertfind(lfi);
		}
		if(flag==true){
			resp.sendRedirect("Persenal?method=login&status=1");
		}
		else{
			resp.sendRedirect("Persenal?method=login&status=2");
		}
	}




/**
 * 从登录界面过来，在跳转到个人主页之前需要把
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("status");
		
		User user = (User)req.getSession().getAttribute("user");
		
		findinfoDao dao =new findinfoDao();
		//根据时间顺序获取丢失信息
		List<losefindinfo> list = new ArrayList<>();
		list=dao.getLoseinfobyUser(user.getUser());
		
		//根据时间顺序获取全部东西信息
		List<losefindinfo> list1 = new ArrayList<>();
		list1=dao.getFindinfobyUser(user.getUser());
		
		req.setAttribute("list", list);
		req.setAttribute("list1", list1); 
		req.getRequestDispatcher("Persenal.jsp?status="+status).forward(req, resp);
	}
	

}
