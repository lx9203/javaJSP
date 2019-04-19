package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/ch05/login/memberProcServlet")
public class MemberProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberProcServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String strId = request.getParameter("id");
		System.out.println(action + " " + strId);
		MemberDAO mDao = new MemberDAO();
		RequestDispatcher rd;
		switch (action) {
		case "update" :
			MemberDTO member = mDao.selectMemberOne(Integer.parseInt(strId));

			request.setAttribute("member", member);
			rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
			mDao.close();
			break;
		case "delete" : 
			mDao = new MemberDAO();
			mDao.deleteMember(Integer.parseInt(strId));
			mDao.close();
			//response.sendRedirect("login_main.jsp");
			String message = "id = " + strId + " 가 삭제되었습니다.";
			String url = "login_main.jsp";
			request.setAttribute("message", message);
			request.setAttribute("url", url);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			break;
		default:
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
