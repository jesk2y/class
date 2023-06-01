package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuizActionServlet
 */
public class QuizActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String qnoStr = request.getParameter("qno");
		String answer = request.getParameter("answer");
		
		System.out.println(qnoStr);
		System.out.println(answer);
		
		int qno = Integer.parseInt(qnoStr);
		
		response.sendRedirect("quiz?qno="+  ++qno );
		
		
	}

}
