package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class validation extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String accno=req.getParameter("acc");
			String passw=req.getParameter("password");
			if(accno.length()==4 || passw.length()!=0) {
				req.getServletContext().getRequestDispatcher("/login").forward(req, res);
			}
			else {
				res.sendRedirect("/bank/invalid.html");

			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
