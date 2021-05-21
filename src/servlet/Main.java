package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Identity;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends MyServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
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
		 java.util.ArrayList<bean.EssayBean> essayList=new dao.Essay().getAllEaasy();
		 request.setAttribute("essayList", essayList);
		 request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//身份验证
		super.doPost(request, response);
		Identity identity=(Identity)request.getSession().getAttribute("identity");
		doGet(request, response);
	}

}
