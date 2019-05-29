package prectice;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/AdditionServlet")
public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdditionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2");
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
		
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("add", add);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("07_add.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
