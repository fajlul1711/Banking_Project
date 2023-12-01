package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.CustomerTableDto;

@WebServlet("/signupPage")
public class CustomerSignupPage extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String firstname= req.getParameter("firstname");
	String lastname=req.getParameter("lastname");
	String mobile=req.getParameter("mobile");
	String email= req.getParameter("email");
	String password= req.getParameter("password");
	String confirmpassword= req.getParameter("confirmpassword");
	String dob= req.getParameter("dob");
	String gender=req.getParameter("gender");
	String country= req.getParameter("country");
	String terms= req.getParameter("terms");
	
	//Display the credintial to the UI or Web page
//	res.getWriter().println("<h1> Customer First Name is: "+firstname+""
//			+ "<h1> Customer Last Name is: "+lastname+""
//			+ "<h1> Customer Mobile Number is: "+mobile+""
//			+ "<h1> Customer Email id is: "+email+""
//			+ "<h1> Customer Password is: "+password+""
//			+ "<h1> Customer Confirm Password is: "+confirmpassword+""
//			+ "<h1> Customer Date of Birth is: "+dob+""
//			+ "<h1> Customer Gender is: "+gender+""
//			+ "<h1> Customer Country Name is: "+country+""
//			+ "<h1> Customer Terms and Condition is: "+terms+""
//			+ "<h1>");
	
	//Variable are converted to the respective data type by using parsing and wrapper class
	long mob= Long.parseLong(mobile);
	
	Date date = Date.valueOf(dob);
	Period period =	Period.between(date.toLocalDate(), LocalDate.now());
	int age= period.getYears();
	
	if(age<18) {
		res.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243);\">\r\n"
				+ "        <h1> He is Not Eligible to Create an Bank account Because of Age</h1>\r\n"
				+ "    </div>");
		
		req.getRequestDispatcher("home.html").include(req, res);
	}else {
		CustomerDao customerDao= new CustomerDao();
		List<CustomerTableDto> list1= customerDao.fetch(mob);
		List<CustomerTableDto> list2 = customerDao.fetch(email);
		
		if(list1.isEmpty() && list2.isEmpty()) {
			CustomerTableDto customerTableDto= new CustomerTableDto();
			customerTableDto.setFirstname(firstname);
			customerTableDto.setLastname(lastname);
			customerTableDto.setMobile(mob);
			customerTableDto.setEmail(email);
			customerTableDto.setPassword(password);
			customerTableDto.setConfirmpassword(confirmpassword);
			customerTableDto.setDob(date);
			customerTableDto.setGender(gender);
			customerTableDto.setCountry(country);
			customerTableDto.setTerms(terms);
			
			customerDao.save(customerTableDto);
			CustomerTableDto customerTableDto2=customerDao.fetch(email).get(0);
			
//			res.getWriter().print("<h1>Bank Account Has Been Created Successfully</h1>");
			if(customerTableDto2.getGender().equals("male")) {
				
				res.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:10px;  text-align: center;\">\r\n"
						+ "        <h1>Hello Sir, Your Account Has Been Created Successfully <br> Please note Your Customer Id is: "
						+ "            "+customerTableDto2.getIBHID()+"</div>");
				
//				res.getWriter().print("<h1>Welcome Sir Your Account has been created Successfully <br> Please note your Customer id:  "+customerTableDto2.getIBHID()+"</h1>");
				req.getRequestDispatcher("home.html").include(req, res);
				
			}else {
//				res.getWriter().print("<h1>Welcome Madam Your Account has been created Successfully</h1>");
//				res.getWriter().print("<h1>Please note your Customer id:  "+customerTableDto2.getIBHID()+"</h1>");
//				req.getRequestDispatcher("home.html").include(req, res);
				
				res.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
						+ "        <h1>Hello Madam, Your Account Has Been Created Successfully <br> Please note Your Customer Id is: "
						+ "            "+customerTableDto2.getIBHID()+"</div>");
				
				req.getRequestDispatcher("home.html").include(req, res);
			}
			
		}
		else {
			res.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
					+ "        <h1>Bank Account is Already Existed</h1>\r\n"
					+ "    </div>");
			req.getRequestDispatcher("home.html");
		}
	}
	
	
}
}
