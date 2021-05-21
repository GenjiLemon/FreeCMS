package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.*;
/**
 * Servlet implementation class Ezedit
 */
@WebServlet("/Essay")
public class Essay extends MyServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Essay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		//没处理好的地方，新增文章
		Identity identity=(Identity)request.getSession().getAttribute("identity");
		if(request.getParameter("eid")==null) {
			if(request.getParameter("type")==null||!request.getParameter("type").equals("2")) {
				response.sendRedirect("error.jsp");
				
				}
			else {
					if(identity.isVisitors()) {
						response.sendRedirect("error.jsp");
					}
					else {
						request.setAttribute("type", "2");
						request.getRequestDispatcher("editez.jsp").forward(request, response);
					}
			}
		}
		
		int eid=Integer.parseInt(request.getParameter("eid"));
		EssayBean essay=new EssayBean(eid);

		if(essay.getTitle()==null) {
			response.sendRedirect("error.jsp");
		}
		else {
			String type=request.getParameter("type");
			if(type==null) {//处理展示
				if(request.getParameter("auto")!=null) {
					EssayBean newessay=null;
					int newth=essay.getEid();
					if(request.getParameter("auto").equals("pre")) {//处理上一个
						java.util.ArrayList<bean.EssayBean> essayList=new dao.Essay().getAllEaasy();
						for(EssayBean node :essayList) {  //此处注意essayList里放的是什么，并且不要直接用index方法
							if(node.getEid()==essay.getEid())
								newth=essayList.indexOf(node)-1;
						}
						if(newth<0)newth=essayList.size()-1;
						 newessay=essayList.get(newth);
					}
					else if(request.getParameter("auto").equals("next")) {//处理下一个
						java.util.ArrayList<bean.EssayBean> essayList=new dao.Essay().getAllEaasy();
						for(EssayBean node :essayList) {  
							if(node.getEid()==essay.getEid())
								newth=essayList.indexOf(node)+1;
						}					
						if(newth>essayList.size()-1)newth=0;
						 newessay=essayList.get(newth);
					}
					else
					{
						response.sendRedirect("error.jsp");
					}
					response.sendRedirect(request.getContextPath()+"/Essay?eid="+newessay.getEid());
					
				}
				else {
					
					request.setAttribute("essay",essay);
					request.getRequestDispatcher("ezindex.jsp").forward(request, response);
				}
				
			}
			else {
				//先处理身份问题
				
		
				if(!identity.canEdit(essay.getAuthor())) {
					response.sendRedirect("error.jsp");
				}
				else {
					
				
				if(type.equals("1")) {//处理编辑
				request.setAttribute("essay",essay);
				request.setAttribute("type", "1");
				request.getRequestDispatcher("editez.jsp").forward(request, response);
			}
			else if(type.equals("2")) {//处理新增
				request.setAttribute("type", "2");
				request.getRequestDispatcher("editez.jsp").forward(request, response);
			}
			else if(type.equals("3")) {//处理删除
				int uid=essay.getEid();
				new dao.Essay().delete(eid);
				response.sendRedirect(request.getContextPath()+"/Main");
			}
			else  {
				response.sendRedirect("error.jsp");
			}
				}
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//先处理身份问题
		super.doPost(request, response);
				Identity identity=(Identity)request.getSession().getAttribute("identity");

		if(request.getParameter("type").equals("1")) {//保存更改
			if(!identity.canEdit(request.getParameter("author"))) {
				response.sendRedirect("error.jsp");
			}
			EssayBean newessay=new EssayBean(Integer.parseInt(request.getParameter("eid")),request.getParameter("title"),request.getParameter("author"),request.getParameter("content"));
			if(newessay.update()) {
				request.setAttribute("forwardURL", "/Main");
				request.setAttribute("forwardTips", "更改成功！");
			}
			else {
				request.setAttribute("forwardURL", "/Main");
				request.setAttribute("forwardTips", "更改失败！");
			}
			request.getRequestDispatcher("forward.jsp").forward(request, response);
		}
		else if(request.getParameter("type").equals("2")) {//新增
			EssayBean newessay=new EssayBean(request.getParameter("title"),request.getParameter("author"),request.getParameter("content"));
			
			if(newessay.create()) {
				request.setAttribute("forwardURL", "/Main");
				request.setAttribute("forwardTips", "新增成功！");
			}
			else {
				request.setAttribute("forwardURL", "/Main");
				request.setAttribute("forwardTips", "新增失败！");
			}
			request.getRequestDispatcher("forward.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("error.jsp");
		}
	
	}

}
