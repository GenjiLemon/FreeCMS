package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.*;
/**
 * Servlet implementation class Logon
 */
@WebServlet("/Logon")
public class Logon extends MyServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //注册验证
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		super.doGet(request, response);
		Identity identity=(Identity)request.getSession().getAttribute("identity");
		request.getRequestDispatcher("logon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		Identity identity=(Identity)request.getSession().getAttribute("identity");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
		UserBean user=new UserBean(username,password);
		if(user.checkUsername()==true) {
			request.setAttribute("forwardUrl", "/Logon");
			request.setAttribute("forwardTips", "用户名已存在！");
			request.getRequestDispatcher("forward.jsp").forward( request,  response);
		}
		else {
			if(user.create()) {
				request.setAttribute("forwardUrl", "/Main");
				request.setAttribute("forwardTips", user.getUsername()+"，欢迎您，创建成功！");
				if(identity.isVisitors()) {
					identity.setStatus(user.getStatus());
					identity.setUsername(user.getUsername());
				
				}
				request.getRequestDispatcher("forward.jsp").forward( request,  response);
			}
			else {
				request.setAttribute("forwardUrl", "/Logon");
				request.setAttribute("forwardTips", "创建失败！");
				request.getRequestDispatcher("forward.jsp").forward( request,  response);
			}
		}
		
	}

}
