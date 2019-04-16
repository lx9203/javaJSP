package jspbook_ch04;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(description = "Score 서블릿", urlPatterns = { "/ScoreServlet" })
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int num1, num2, num3;
		int sum = 0;

		res.setContentType("text/html; charset=UTF-8");

		PrintWriter out = res.getWriter();

		num1 = Integer.parseInt(req.getParameter("num1"));
		num2 = Integer.parseInt(req.getParameter("num2"));
		num3 = Integer.parseInt(req.getParameter("num3"));

		Score result = new Score(num1, num2, num3);
		sum = result.getResult();
		double avg = sum/3;

		out.println("<HTML>");
		out.println("<HEAD><TITLE>성적입력</TITLE></HEAD>");
		out.println("<BODY><center>");
		out.println("<H2>성적표</H2>");
		out.println("<HR>");
		out.println("국어" + num1 + " " + "영어" + num2 + " " + "수학" + num3 + " " + "총점" + sum + " " + "평균" + avg );
		out.println("</BODY></HTML>");
	}

}
