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
import dao.BankDao;


@WebServlet("/deposit")
public class Deposit extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amount= req.getParameter("amount");
		
		double amt= Double.parseDouble(amount);
			Long acno= (Long) req.getSession().getAttribute("acno");
		BankDao bankDao	= new BankDao();
	BankAccount bankAccount= 	bankDao.fetchByAccno(acno);
//		double currentAmount= (bankAccount.getAmount()+amt);
		bankAccount.setAmount((bankAccount.getAmount()+amt));//before putting any data inside database we should set the data
		bankDao.update(bankAccount);
		
		 
		BankTransaction bankTransaction= new BankTransaction();
		//bankTransaction.setTid(0);
		bankTransaction.setDeposit(amt);
		bankTransaction.setBalance(bankAccount.getAmount());
		bankTransaction.setWithdraw(0);
		bankTransaction.setLocalDateTime(LocalDateTime.now());
		
		//bankDao.update(bankAccount);
		List<BankTransaction>	list=bankAccount.getBankTransactions();//older Previous transaction history
		list.add(bankTransaction);//inside this we are having older transaction history plus + current transaction
		//today
		//req.getSession().setAttribute("list", list);
		bankDao.update(bankAccount);
		
	
		resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
				+ "        <h1>Amount Added Sucessfully</h1>"+"</div>");
		req.getRequestDispatcher("TransactionPage.jsp").include(req, resp);
}
}
