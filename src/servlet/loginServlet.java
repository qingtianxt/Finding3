package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if(method.equals("login")){
			login(req,resp);
		}
		else if(method.equals("register"))
		{
			register(req,resp);
		}
		else if(method.equals("exit")){
			exit(req,resp);
		}
	}
	/**
	 * 通过设置session对象失效来推出
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//使session对象失效
		req.getSession().invalidate();
			req.getRequestDispatcher("login.jsp?status=5").forward(req, resp);
		}
private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		//E:\workek\Find3\WebContent\images
		
		
		User u = new User();
		u.setUser(user);
		u.setPassword(password);
		u.setEmail(email);
		u.setPhone(phone);
		u.setDate(date);
		
		UserDao dao = new UserDao();
		boolean flag = dao.register(u);
		
		
		if(flag==true){
//			req.getRequestDispatcher("login.jsp?status=1").forward(req, resp);
			req.getSession().setAttribute("user", u);
			resp.sendRedirect(req.getContextPath()+"/Persenal?method=login");
			
		}
		else{
			req.getRequestDispatcher("login.jsp?status=2").forward(req, resp);
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		UserDao dao = new UserDao();
		User u=dao.login(user,password);
		
		if(u==null){
			req.getRequestDispatcher("login.jsp?status=3").forward(req, resp);
		}
		else
		{
			req.getSession().setAttribute("user", u);
			resp.sendRedirect(req.getContextPath()+"/Persenal?method=login");
		}
	}
}
