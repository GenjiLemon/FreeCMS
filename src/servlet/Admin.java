package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.User;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends MyServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//身份验证
		super.doGet(request, response);
		Identity identity=(Identity)request.getSession().getAttribute("identity");
		if(!identity.isAdmin()) {
			response.sendRedirect("error.jsp");
		}
		else if(request.getParameter("type")!=null) {//处理增删改
			
			if(request.getParameter("type").equals("3"))		
			{//处理删除
				int uid=Integer.parseInt(request.getParameter("uid"));
				new dao.User().delete(uid);
				response.sendRedirect(request.getContextPath()+"/Admin");
			}
			else if(request.getParameter("type").equals("2")) {
				//处理增加
				request.setAttribute("type", "2");
				request.getRequestDispatcher("useredit.jsp").forward(request, response);
				
			}
			else {//处理编辑
				int uid=Integer.parseInt(request.getParameter("uid")); 
				UserBean user=new User().find(uid);
				request.setAttribute("user", user);
				request.setAttribute("type", "1");
				request.getRequestDispatcher("useredit.jsp").forward(request, response);
			}
		}
			
		
		else {													//处理查
			ArrayList<UserBean> list=new User().getUser(identity.getStatus());
			request.setAttribute("userList", list);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		Identity identity=(Identity)request.getSession().getAttribute("identity");
		
		if(!identity.isAdmin()) {
			response.sendRedirect("error.jsp");
		}
		else {
			if(request.getParameter("type").equals("1")) {//处理编辑
				UserBean user=new UserBean(Integer.parseInt(request.getParameter("uid")),request.getParameter("username"),request.getParameter("password"),Integer.parseInt(request.getParameter("status")));
				if(user.update()) {
					request.setAttribute("forwardURL", "/Admin");
					request.setAttribute("forwardTips", "更改成功！");
				}
				else {
					request.setAttribute("forwardURL", "/Admin");
					request.setAttribute("forwardTips", "更改失败！");
				}
				request.getRequestDispatcher("forward.jsp").forward(request, response);
			}
			else if(request.getParameter("type").equals("2")) {//处理新增
				UserBean user=new UserBean(request.getParameter("username"),request.getParameter("password"),Integer.parseInt(request.getParameter("status")));
				if(user.create()) {
					request.setAttribute("forwardURL", "/Admin");
					request.setAttribute("forwardTips", "增加成功！");
				}
				else {
					request.setAttribute("forwardURL", "/Admin");
					request.setAttribute("forwardTips", "增加失败！");
				}
				request.getRequestDispatcher("forward.jsp").forward(request, response);
				
			}
		}
	}

}
