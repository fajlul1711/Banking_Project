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


@WebServlet("/changestatus")
public class ChangeStatus extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String acno1=req.getParameter("acno");
	
	long acno2=Long.parseLong(acno1);
	
	BankDao bankDao= new BankDao();
	
	BankAccount bankAccount=bankDao.fetchByAccno(acno2);
	
	if(bankAccount.isStatus()) {
		bankAccount.setStatus(false);
		
	}else {
		bankAccount.setStatus(true);
	}
	bankDao.update(bankAccount);
	List<BankAccount> list=bankDao.fetch_All_Bank_Details();
	req.getSession().setAttribute("list", list);
	req.getRequestDispatcher("Account_home.jsp").include(req, resp);
	
	resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
			+ "        <h1>Bank Status Has Been Updated</h1>"+"</div>");
	
}
}
