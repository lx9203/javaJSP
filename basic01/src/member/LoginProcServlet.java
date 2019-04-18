package member;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ch05/login/LoginProcServlet")
public class LoginProcServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
       
    public LoginProcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		
		MemberDAO mDao = new MemberDAO();
		int result = mDao.verifyIDPassword(id, password);
		String errorMessage = null;
		switch (result) {
		case MemberDAO.ID_PASSWORD_MATCH:
			break;
		case MemberDAO.ID_DOES_NOT_EXIST:
			errorMessage = "ID가 없음";
			break;
		case MemberDAO.PASSWORD_IS_WRONG:
			errorMessage = "패스워드가 틀렸음";
			break;
		case MemberDAO.DATABASE_ERROR:
			errorMessage = "DB 오류";
		}
		mDao.close();
		
		if(result == MemberDAO.ID_PASSWORD_MATCH){
			response.sendRedirect("login_main.jsp");
		} else {
			/*request.setAttribute("error", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);*/
			String uri = "login.jsp?error=" + URLEncoder.encode(errorMessage, "UTF-8");
			response.sendRedirect(uri);
		}
	}
	
}
