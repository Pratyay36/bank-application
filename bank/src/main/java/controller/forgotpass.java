package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.model;

public class forgotpass extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String accno = req.getParameter("acc");
			String name = req.getParameter("name");
			String mobile = req.getParameter("mobile");
			
			model m=new model();
			m.setAccount(accno);
			m.setName(name);
			m.setMobile(mobile);
			
			Boolean passwordStatus=m.forgot();
			if(passwordStatus==true) {
				String a=m.getPassword();
				PrintWriter pw=res.getWriter();
				pw.println(a);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
