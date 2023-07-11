package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regvalid extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String accno=req.getParameter("acc");
			String passw=req.getParameter("password");
			String name=req.getParameter("name");
			String mobile=req.getParameter("mobile");
			if(accno.length()==4 || passw.length()!=0 || name.length()!=0 || mobile.length()==10) {
				req.getServletContext().getRequestDispatcher("/register").forward(req, res);
			}
			else {
				res.sendRedirect("/bank/newuserinvvalid.html");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
