package org.zerock.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//text/plain
		response.setContentType("application/json");
		
		List<Menu> menuList = new ArrayList<>();
		menuList.add(new Menu("A", 3000));
		menuList.add(new Menu("B", 4000));
		menuList.add(new Menu("C", 5000));
		menuList.add(new Menu("D", 6000));
		menuList.add(new Menu("E", 7000));
		
		Collections.shuffle(menuList);
		
		Gson gson = new Gson();
		String json = gson.toJson(menuList.get(0));
		
		response.getWriter().print(json);
	}

}

















