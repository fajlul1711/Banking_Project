package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.CustomerTableDto;

@WebServlet("/customerLogin")
public class CustomerLoginPage extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String custid=req.getParameter("custid");
	String pdws = req.getParameter("pwd");
	
	long id= Long.parseLong(custid);
	
	CustomerDao customerDao= new CustomerDao();
	CustomerTableDto customerTableDto=	customerDao.fetchBycustId(id);
	
	if(customerTableDto==null) {
		
		
		resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
				+ "        <h1>Invalid Customer Id</h1>"+"</div>");
		
		req.getRequestDispatcher("login.html").include(req, resp);
		
	}else {
		if(customerTableDto.getPassword().equals(pdws)) {
			
			resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
					+ "        <h1>Customer Login Successfully</h1>"+"</div>");
			
			req.getSession().setAttribute("customerTableDto", customerTableDto);
			req.getRequestDispatcher("account.html").include(req, resp);
			
		}else {
			
			resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
					+ "        <h1>Invalid Customer Password</h1>"+"</div>");
			
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}
}
