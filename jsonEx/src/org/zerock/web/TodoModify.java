package org.zerock.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.Todo;
import org.zerock.service.TodoService;

/**
 * Servlet implementation class TodoModify
 */
@WebServlet("/todo/modify")
public class TodoModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TodoService service 
	  = new TodoService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int pk = Integer.parseInt(request.getParameter("pk"));
		
		String title = 
				request.getParameter("title");
		
		Todo target = new Todo();
		target.setPk(pk);
		target.setTitle(title);
		
		boolean result = service.modify(target);
		
		response.setContentType("application/json");
		
		response.getWriter().print("{\"result\":"+result+"}");
	}

}










