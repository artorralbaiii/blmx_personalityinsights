package net.tutorial.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tutorial.utilities.PersonalityInsightsService;


@WebServlet({"home", ""})
public class MainController extends HttpServlet {
	
	RequestDispatcher dispatcher;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String text = req.getParameter("params");
		PersonalityInsightsService service = new PersonalityInsightsService();
		req.setAttribute("text", text);
		req.setAttribute("profile", service.getProfile(text));
		dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
}
