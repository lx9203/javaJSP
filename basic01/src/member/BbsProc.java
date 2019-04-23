package member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/member/BbsProcServlet")
public class BbsProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int memberId = (Integer) session.getAttribute("memberId");
		String title = null;
		String content = null;
		String message = null;
		String url = null;
		RequestDispatcher rd = null;
		BbsDAO bDao = null;
		BbsDTO bDto = new BbsDTO();
		int id =0;
		
		String action = request.getParameter("action");
		switch(action) {
			case "insert" :
				title = request.getParameter("title");
				content = request.getParameter("content");
				
				bDto = new BbsDTO(memberId, title, content);
				bDao = new BbsDAO();
				bDao.insertBbs(bDto);
				response.sendRedirect("bbsMain.jsp");
				bDao.close();
				break;
			case "update" :
				if (!request.getParameter("id").equals("")) {
					id = Integer.parseInt(request.getParameter("id"));
				}
				bDao = new BbsDAO();
				bDto = bDao.selectOne(id);
				if (memberId != bDto.getMemberId()) {
					message = "Id = " + id + " 에 대한 수정 권한이 없습니다.";
					url = "bbsMain.jsp";
					request.setAttribute("message", message);
					request.setAttribute("url", url);
					rd = request.getRequestDispatcher("alertMsg.jsp");
					rd.forward(request, response);
					break;
				}
				bDao.close();
				request.setAttribute("modify", bDto);
				rd = request.getRequestDispatcher("bbsUpdate.jsp");
		        rd.forward(request, response);
		        break;
				
		}
	}

}
