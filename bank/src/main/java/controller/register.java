package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.model;

public class register extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String accno=req.getParameter("acc");
			String passw=req.getParameter("password");
			String name=req.getParameter("name");
			String balance=req.getParameter("balance");
			String mobile=req.getParameter("mobile");
			String email=req.getParameter("email");


			
			model m=new model();
			m.setAccount(accno);
			m.setPassword(passw);
			m.setName(name);
			m.setBalance(balance);
			m.setEmail(email);
			m.setMobile(mobile);
			
			boolean status=m.register();
			if(status==true) {
				String a=m.getAccount();
				String b=m.getName();
				String c=m.getBalance();
				String d=m.getPassword();
				String e=m.getEmail();
				String f=m.getMobile();
				
				HttpSession hs=req.getSession(true);
				hs.setAttribute("accountno", a);
				hs.setAttribute("name", b);
				hs.setAttribute("balance",c);
				hs.setAttribute("passsword", d);
				hs.setAttribute("email", e);
				hs.setAttribute("mobile", f);
				
				res.sendRedirect("/bank/welcome.jsp");
			}
			else {
				res.sendRedirect("/bank/newuserincorrect.html");
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
