package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dao.CustomerDao;
import dto.BankAccount;
import dto.CustomerTableDto;


@WebServlet("/createbankaccount")
public class Create_Bank_Account extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String banktype=req.getParameter("banktype");
		CustomerTableDto customerTableDto= (CustomerTableDto) req.getSession().getAttribute("customerTableDto");
		
		List<BankAccount> list1 = customerTableDto.getList();//it will give the list of bank account which have been created for current User
		boolean flag=true;
		
		for (BankAccount bankAccount : list1) {
			if(bankAccount.getAccountType().equals(banktype)) {
				
				resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
						+ "        <h1>Already Account is Existed</h1>"+"</div>");
				
				flag=false;
				req.getRequestDispatcher("account.html").include(req, resp);
			}
		}
		
		if(flag) {
		BankAccount bankAccount = new BankAccount();
		//bankAccount.setAccno(0);//it will get generated automatically so its not required to set externally
		//bankAccount.setAmount(0);//---
		//bankAccount.setStatus(false);//---
		
		bankAccount.setAccountType(banktype);
		
		if(bankAccount.getAccountType().equals("savings"))
			bankAccount.setAccountLimit(10000);
		else 
			bankAccount.setAccountLimit(15000);
		
		bankAccount.setCustomerTableDto(customerTableDto);
		
		BankDao bankDao=new BankDao();
		bankDao.save(bankAccount);
		
		List<BankAccount>list2=list1;//savings
		list2.add(bankAccount);//saving + current=list2
		customerTableDto.setList(list2);
		
		CustomerDao customerDao = new CustomerDao();
		customerDao.update(customerTableDto);
		
		resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
				+ "        <h1>Bank Account has been created Successfully Waiting for Bank Manager Approval</h1>"+"</div>");
		
		req.getRequestDispatcher("admin.html").include(req, resp);
		}
		
	}

}
