package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.model;

public class login extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String accno=req.getParameter("acc");
			String passw=req.getParameter("password");
			
			model m=new model();
			m.setAccount(accno);
			m.setPassword(passw);
			
			boolean status=m.login();
			if(status==true) {
				String a=m.getAccount();
				String b=m.getName();
				String c=m.getBalance();
				String d=m.getPassword();
				
				HttpSession hs=req.getSession(true);
				hs.setAttribute("accountno", a);
				hs.setAttribute("name", b);
				hs.setAttribute("balance",c);
				hs.setAttribute("passsword", d);
				
				res.sendRedirect("/bank/welcome.jsp");
			}
			else {
				res.sendRedirect("/bank/inncorrect.html");
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
