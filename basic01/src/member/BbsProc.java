package member;

import java.io.*;
import java.util.*;

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
		BbsDAO bDao = null;;
		BbsDTO bDto = new BbsDTO();
		int id =0;
		BbsMember bMem = null;
		
		String action = request.getParameter("action");
		switch(action) {
			case "insert" :
				title = request.getParameter("title");
				content = request.getParameter("content");
				bDto = new BbsDTO(memberId, title, content);
				bDao = new BbsDAO();
				bDao.insertBbs(bDto);
				response.sendRedirect("BbsProcServlet?action=bbsJoin");
				bDao.close();
				break;
			case "update" :
				if (!request.getParameter("id").equals("")) {	// 아이디값이 0이 아니면
					id = Integer.parseInt(request.getParameter("id")); // 아이디에 아이디값을 저장
				}
				bDao = new BbsDAO();
				bDto = bDao.selectOne(id); // bDto에 id,memberId,title,date,content,name을 저장
				bDao.close();
				if (memberId != bDto.getMemberId()) {	// 세션어트리뷰트memberId와 셀렉트원memberId를 비교
					message = "Id = " + id + " 에 대한 수정 권한이 없습니다.";
					url = "BbsProcServlet?action=bbsJoin";
					request.setAttribute("message", message);
					request.setAttribute("url", url);
					rd = request.getRequestDispatcher("alertMsg.jsp");
					rd.forward(request, response);		
					break;								// 경고창을 띄우고 돌아가기
				} 								// 멤버 아이디가 같으면
				bDao = new BbsDAO();
				bDto = bDao.selectOne(id);
				bDao.close();
				request.setAttribute("member", bDto);
				rd = request.getRequestDispatcher("bbsUpdate.jsp");
		        rd.forward(request, response);
		        break;
				
			case "delete" :
				if (!request.getParameter("id").equals("")) {
					id = Integer.parseInt(request.getParameter("id")); 
				}
				bDao = new BbsDAO();
				bDto = bDao.selectOne(id); // bDto에 id,memberId,title,date,content,name을 저장
				if (memberId != bDto.getMemberId()) {
					message = "id = " + id + " 에 대한 삭제권한이 없습니다.";
					url = "BbsProcServlet?action=bbsJoin";
					request.setAttribute("message", message);
					request.setAttribute("url", url);
					rd = request.getRequestDispatcher("alertMsg.jsp");
					rd.forward(request, response);
					bDao.close();
					break;
				}
				bDao.deleteBbs(id);
				bDao.close();
				//response.sendRedirect("loginMain.jsp");
				message = "id = " + id + " 이/가 삭제되었습니다.";
				url = "BbsProcServlet?action=bbsJoin";
				request.setAttribute("message", message);
				request.setAttribute("url", url);
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				break;
			case "execute":
				title = request.getParameter("title");
				content = request.getParameter("content");
				id = Integer.parseInt(request.getParameter("id")); 
				bDto = new BbsDTO(id, title, "*", content);
				bDao = new BbsDAO();
				bDao.updateBbs(bDto);
				bDao.close();
				
				rd = request.getRequestDispatcher("BbsProcServlet?action=bbsJoin");
		        rd.forward(request, response);
		        break;
			case "bbsJoin" :
				
				bDao = new BbsDAO();
				List<BbsDTO> list = (List<BbsDTO>) bDao.selectJoinAll();
				request.setAttribute("modify", list);
				rd = request.getRequestDispatcher("bbsMain.jsp");
				rd.forward(request, response);
				bDao.close();
				break;
			case "view":
				if (!request.getParameter("id").equals("")) {
					id = Integer.parseInt(request.getParameter("id"));
				}
				bDao = new BbsDAO();
				bMem = bDao.ViewData(id);
				bDao.close();
				
				request.setAttribute("bbsMember", bMem);
				rd = request.getRequestDispatcher("bbsView.jsp");
		        rd.forward(request, response);
				break;	
		}
	}

}
