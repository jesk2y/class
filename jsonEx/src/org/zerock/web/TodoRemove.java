package org.zerock.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.service.TodoService;

/**
 * Servlet implementation class TodoRemove
 */
@WebServlet("/todo/remove")
public class TodoRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TodoService service 
	  = new TodoService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pkStr = request.getParameter("pk");
		
		response.setContentType("application/json");
		
		boolean result = service.delete(Integer.parseInt(pkStr));
		
		System.out.println(pkStr);
		System.out.println(result);
		
		response.getWriter().print("{\"result\":"+result+"}");
		
		
	}

}





