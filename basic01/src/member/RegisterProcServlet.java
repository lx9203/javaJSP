package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch05/login/registerProcServlet")
public class RegisterProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterProcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		MemberDTO member = new MemberDTO(password, name, birthday, address);
		System.out.println(member.toString());
		
		MemberDAO mDao = new MemberDAO();
		mDao.insertMember(member);
		mDao.close();
		
		response.sendRedirect("login_main.jsp");
	}

}
