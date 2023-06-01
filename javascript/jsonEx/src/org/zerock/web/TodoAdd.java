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
 * Servlet implementation class TodoAdd
 */
@WebServlet("/todo/add")
public class TodoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private TodoService service 
	  = new TodoService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		
		System.out.println(title);
		
		Todo obj = new Todo();
		obj.setTitle(title);
		
		int pk = service.add(obj);
		
		response.setContentType("application/json");
		
		response.getWriter().print("{\"pk\":"+pk+"}");
		
	}

}
