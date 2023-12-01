package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BankAccount;
import dto.CustomerTableDto;

@WebServlet("/fetchActiveAccount")
public class FetchActiveAccounts extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//	CustomerTableDto customerTableDto = (CustomerTableDto) req.getSession().getAttribute("customerTableDto");
	CustomerTableDto 	customerTableDto= (CustomerTableDto) req.getSession().getAttribute("customerTableDto");
	
	List<BankAccount> list = customerTableDto.getList();
	
	List<BankAccount>list2= new ArrayList<BankAccount>();
	
	for(BankAccount bankAccount: list) {
		
		if(bankAccount.isStatus()) {
			
			list2.add(bankAccount);
			
			resp.getWriter().print("<h1> Active Account found<h1>");
			
//		}else {
//			resp.getWriter().print("<h1>There is No Active Account found<h1>");
		}
	}
	req.getSession().setAttribute("list", list2);
	req.getRequestDispatcher("Account.jsp").include(req, resp);
}
}
