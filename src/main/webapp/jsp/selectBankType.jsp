<%@page import="dto.CustomerTableDto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Bank Account Creation Page</h1>
<!-- <h1>This is a Hard coding  so we go for jsp tags</h1/> -->	
<%CustomerTableDto customerTableDto=(CustomerTableDto) request.getSession().getAttribute("customerTableDto"); %>
<h1>Hello: <%= customerTableDto.getFirstname()+ customerTableDto.getLastname() %></h1>
<h1>Select bank type</h1>
<form action="createbankaccount">
<input type="radio" name="banktype" value="savings" required="required">Savings
<input type="radio" name="banktype" value="current" required="required">Current<br><br>
<button>Submit</button><button type="reset">Cancel</button>

</form>
</body>
</html>