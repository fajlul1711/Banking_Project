<%-- 

<%@page import="dto.BankAccount"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Account Home Page</h1>
	<%  List<BankAccount> list=(List<BankAccount>)request.getSession().getAttribute("list"); %>
	<table border="1">
		<tr>
			<th>Account Number</th>
			<th>Account Type</th>
			<th>Amount</th>
			<th>Account Limit</th>
			<th>Account Status</th>
			<th>Customer name</th>
			<th>Customer Id</th>
			<th>Change status</th>
		</tr>
		<%for(BankAccount bankAccount:list){ %>
		<tr>
			<th><%=bankAccount.getAccno()%></th>
			<th><%=bankAccount.getAccountType()%></th>
			<th><%= bankAccount.getAmount() %></th>
			<th><%=bankAccount.getAccountLimit()%></th>
			<th><%=bankAccount.isStatus()%></th>
			<th><%= bankAccount.getCustomerTableDto().getFirstname()%></th>
			<th><%=bankAccount.getCustomerTableDto().getIBHID()%></th>
			<th><a href="changestatus?acno=<%=bankAccount.getAccno()%>"><button>Change
						Status</button></a></th>
		</tr>




		<%} %>
	</table>
</body>
</html>

--%>

<%@page import="dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Home Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
            color: #333;
            text-align: center;
        }

        h1 {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        button {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }

        button:hover {
            background-color: #45a049;
        }

        .back-button {
            margin-top: 20px;
        }

        .back-button a {
            display: inline-block;
            padding: 8px 16px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
        }

        .back-button a:hover {
            background-color: #555;
        }
    </style>
</head>
<body>

    <h1>Welcome to Account Home Page</h1>

    <% List<BankAccount> list = (List<BankAccount>) request.getSession().getAttribute("list"); %>

    <table>
        <tr>
            <th>Account Number</th>
            <th>Account Type</th>
            <th>Amount</th>
            <th>Account Limit</th>
            <th>Account Status</th>
            <th>Customer name</th>
            <th>Customer Id</th>
            <th>Change status</th>
        </tr>
        <% for (BankAccount bankAccount : list) { %>
            <tr>
                <td><%= bankAccount.getAccno() %></td>
                <td><%= bankAccount.getAccountType() %></td>
                <td><%= bankAccount.getAmount() %></td>
                <td><%= bankAccount.getAccountLimit() %></td>
                <td><%= bankAccount.isStatus() %></td>
                <td><%= bankAccount.getCustomerTableDto().getFirstname() %></td>
                <td><%= bankAccount.getCustomerTableDto().getIBHID() %></td>
                <td><a href="changestatus?acno=<%= bankAccount.getAccno() %>"><button>Change Status</button></a></td>
            </tr>
        <% } %>
    </table>

    <div class="back-button">
      <%--  <a href="Account.jsp">Back</a>--%> 
      <a href="account.html">Back</a>
    </div>

</body>
</html>
