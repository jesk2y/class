package org.zerock.web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet(urlPatterns="/quiz")


public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public QuizServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		
		System.out.println("service..............................");
		
		Quiz quiz = new Quiz("aaa", new String[] {"1. A ","2. B","3. C"},"A");
		
		Gson gson = new Gson();
		String json = gson.toJson(quiz);
		
		response.getWriter().print(json);
	}

}

