package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccount;



@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("adminemil");
	String pdw=req.getParameter("adminpwd");
	
	if(email.equals("admin@gmail.com") && pdw.equals("admin")) {
		
		resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
				+ "        <h1>Admin Login Successfully</h1>"+"</div>");
		
		BankDao bankDao	=new BankDao();
		List<BankAccount> list=	bankDao.fetch_All_Bank_Details();
		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("Account_home.jsp").include(req, resp);
		
	}else {
		
		resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
				+ "        <h1>Invalid credentials</h1>"+"</div>");
		
		req.getRequestDispatcher("admin.html").include(req, resp);
	}
	
	
}

}
