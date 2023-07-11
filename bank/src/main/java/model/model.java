package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

public class model {

	private String account;
	private String name;
	private String balance;
	private String password;
	private String mobile;
	private String email;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="SYSTEM";
	String pwd="SYSTEM";
	String path="oracle.jdbc.driver.OracleDriver";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	HttpSession hs=null;
	
	public model() {
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,user,pwd);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public boolean login() {
		try {
			String sql="SELECT * FROM BANK WHERE ACCOUNT = ? AND PASSWORD = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next()==true) {
				account=rs.getString(1);
				name=rs.getString(2);
				balance=rs.getString(3);
				password=rs.getString(4);
				return true;
			}
			else {
				return false;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean register() {
		try {
			String sql="INSERT INTO BANK VALUES (?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, name);
			pstmt.setString(3, balance);
			pstmt.setString(4, password);
			pstmt.setString(5, mobile);
			pstmt.setString(6, email);
			rs=pstmt.executeQuery();
			if(rs!=null) {	
				return true;
			}
			else {
				return false;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean forgot() throws InvalidDetail {
		try {
			String sql="SELECT PASSWORD FROM BANK WHERE NAME='?' AND ACCOUNT='?' AND MOBILE='?'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, account);
			pstmt.setString(3, mobile);
			rs=pstmt.executeQuery();
			if(rs!=null) {
				password=String.valueOf(rs.getString(1));
				return true;
			}
			return true;
			
		} catch (Exception e) {
			throw new InvalidDetail("Account Not Found");
		}
		
	}
}
