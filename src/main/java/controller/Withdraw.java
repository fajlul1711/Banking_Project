package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccount;
import dto.BankTransaction;


@WebServlet("/withdraw")
public class Withdraw extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amount= req.getParameter("amount");
		double amt= Double.parseDouble(amount);
			Long acno= (Long) req.getSession().getAttribute("acno");
		BankDao bankDao	= new BankDao();
	BankAccount bankAccount= 	bankDao.fetchByAccno(acno);
	if(bankAccount.getAmount()<amt) {
		
		resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
				+ "        <h1>Insufficient Balance your actual balance is: "+bankAccount.getAmount()+"</h1>\r\n"
				+ "    </div>");
		req.getRequestDispatcher("TransactionPage.jsp").include(req, resp);
	}else {
		if(amt>bankAccount.getAccountLimit()) {
		
			
			resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
					+ "        <h1>Your Account Limit is Exceeding and actual acount limit is: "+bankAccount.getAccountLimit()+"</h1>\r\n"
					+ "    </div>");
			req.getRequestDispatcher("TransactionPage.jsp").include(req, resp);
			
		}else {
			bankAccount.setAmount((bankAccount.getAmount()-amt));//before putting any data inside database we should set the data
			
			BankTransaction bankTransaction= new BankTransaction();
			//bankTransaction.setTid(0);
			bankTransaction.setDeposit(0);
			bankTransaction.setBalance(bankAccount.getAmount());
			bankTransaction.setWithdraw(amt);
			bankTransaction.setLocalDateTime(LocalDateTime.now());
			
			bankDao.update(bankAccount);
			List<BankTransaction>	list=bankAccount.getBankTransactions();//older Previous transaction history
			list.add(bankTransaction);
			//today
			//req.getSession().setAttribute("list", list);
			
			
			bankDao.update(bankAccount);
			
			resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
					+ "        <h1>Money has been Successfully Withdrawn</h1>\r\n"
					+ "    </div>");
			req.getRequestDispatcher("TransactionPage.jsp").include(req, resp);
		}
	}
	
	}

}
