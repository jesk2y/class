package org.zerock.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.service.TodoService;

import com.google.gson.Gson;

/**
 * Servlet implementation class TodoAll
 */
@WebServlet("/todo/all")
public class TodoAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TodoService service 
	  = new TodoService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		
		String str = gson.toJson(service.getAll());
		
		response.getWriter().print(str);
		
	}

}




