package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String homepage="MyPages/userDetail.jsp";
		try {
			System.out.println("my servlet");
			String spclChar=request.getParameter("spclChar");
			String hiddeninput=request.getParameter("hiddeninput");
			System.out.println("Special Character"+spclChar);
			response.sendRedirect(homepage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
