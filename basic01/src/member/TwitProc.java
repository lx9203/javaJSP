package member;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/member/twitServlet")
public class TwitProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TwitProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String msg = request.getParameter("msg");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("memberName");
		ServletContext application = request.getServletContext();
		
		//메시지 저장을 위해 application에서 msg로 저장된 ArrayList를 가져옴
		List<String> msgs = (ArrayList<String>)application.getAttribute("msgs");
		
		if(msgs == null) {
			msgs = new ArrayList<String>();
			// application 에 ArrayList 저장
			application.setAttribute("msgs",msgs);
		}
		
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MM월 dd일(E) HH:mm", Locale.KOREA);
		msgs.add(username+" :: "+msg+" , "+ f.format(date));
		
		application.log(msg + ", " + username);
		
		response.sendRedirect("twitter_list.jsp");
	}
	

}
