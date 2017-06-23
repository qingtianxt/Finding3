package servlet;

import java.io.IOException;
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
 * Servlet implementation class selectServlet
 */
@WebServlet("/select")
public class selectServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String method = req.getParameter("method");
		if(method.equals("lose")){
			lose(req,resp);
		}
		else if(method.equals("show")){
			show(req,resp);
		}
		else{
			find(req,resp);
		}
	}
	/**
	 * 根据id显示某个信息的所有内容
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String type = req.getParameter("type");
		findinfoDao dao = new findinfoDao();
		losefindinfo l = new losefindinfo();
		
		if(type.equals("1")){
			l =dao.getinfobyId(id);
		}
		else{
			l =dao.getinfobyId1(id);
			
		}
		req.setAttribute("info", l);
//		User user = (User)req.getSession().getAttribute("user");
//		req.getSession().setAttribute("user", user);
		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}

/**
 * 用来处理从login页面跳转过来的根据类型返回认领的消息
 * @param req
 * @param resp
 * @throws IOException 
 * @throws ServletException 
 */
	private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String status = req.getParameter("status");
		if(status.equals("2")){
			findinfoDao dao =new findinfoDao();
			List<losefindinfo> list = dao.getfindinfo();
			req.setAttribute("list", list);
			req.getRequestDispatcher("find.jsp").forward(req, resp);
		}
		else{
			//通过类型
			String type = req.getParameter("type");

			System.out.println(type);
			findinfoDao dao =new findinfoDao();
			List<losefindinfo> list =dao.findbytype(type);
			
			req.setAttribute("list", list);

			System.out.println(type);
			req.setAttribute("category", type);
			req.getRequestDispatcher("select.jsp?status=2").forward(req, resp);
		}
		
		
	}
/**
 * 用来处理从login页面跳转过来的根据类型返回丢失的消息
 * @param req
 * @param resp
 * @throws IOException 
 * @throws ServletException 
 */
	private void lose(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String status = req.getParameter("status");
		if(status.equals("1")){
			findinfoDao dao =new findinfoDao();
			List<losefindinfo> list = dao.getloseinfo();
			req.setAttribute("list", list);
			req.getRequestDispatcher("lose.jsp").forward(req, resp);
		}
		else{
			//通过类型
			String type = req.getParameter("type");
			System.out.println(type);
			findinfoDao dao =new findinfoDao();
		
			List<losefindinfo> list =dao.losebytype(type);
			
			req.setAttribute("list", list);
			System.out.println(type);
			req.setAttribute("category", type);
			req.getRequestDispatcher("select.jsp?status=1").forward(req, resp);
		}
		
	}

	
		//对于查询的筛选方式，寻物或者丢失消息这个决定了要查找的表。时间取填表单时间的前5天和后五天，哪一个里输入的时间越接近，越先被打印出来
		//地点和物品直接作为决定条件，如果满足这两个条件的数据优先被挑选出来，满足其中一个均可，不满足则不被打印出来，这个通过两次查询获得
		
	}


