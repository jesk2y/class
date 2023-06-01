package web;


import service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class QuizServlet
 */
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private QuizService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        service = new QuizService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String qnoStr = request.getParameter("qno");
		
		System.out.println("qnoStr: " + qnoStr);
		
		response.sendRedirect("quiz"+qnoStr+".html");
		
	}

}





