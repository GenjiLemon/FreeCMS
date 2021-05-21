package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Identity;
import bean.UserBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends MyServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		Identity identity=(Identity)request.getSession().getAttribute("identity");
		if(!identity.isVisitors()) {
			request.setAttribute("forwardURL", "/Main");
			request.setAttribute("forwardTips", "您已登录！");
			request.getRequestDispatcher("forward.jsp").forward(request, response);
		}//如果登录了直接跳转主页
		else if(request.getParameter("username")==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}//如果没有username则跳转
		//处理验证
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//处理登录
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		Identity identity=(Identity)request.getSession().getAttribute("identity");
		UserBean user =new UserBean(request.getParameter("username"),request.getParameter("password"));
		if(user.checkUsername()==false) {
			request.setAttribute("forwardUrl", "/Login");
			request.setAttribute("forwardTips", "用户名不存在！");
			request.getRequestDispatcher("forward.jsp").forward( request,  response);
		}
		else if(user.checkPassword()==false) {
			request.setAttribute("forwardUrl", "/Login");
			request.setAttribute("forwardTips", "密码不正确！");
			request.getRequestDispatcher("forward.jsp").forward( request,  response);
		}
		else {
		user.checkStatus();
		identity.setUsername(user.getUsername());
		identity.setStatus(user.getStatus());
		request.setAttribute("forwardUrl", "/Main");
		request.setAttribute("forwardTips", "登陆成功！");
		request.getRequestDispatcher("forward.jsp").forward( request,  response);
		}
	}

}
