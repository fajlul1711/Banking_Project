

<%@page import="dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Page</title>
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

        button {
            display: block;
            margin: 10px auto;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            text-decoration: none;
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
        a{
        text-decoration: none;
        }

        .back-button a:hover {
            background-color: #555;
        }
    </style>
</head>
<body>

    <h1>Welcome to the Account Page</h1>
    
   

    <% List<BankAccount> list = (List<BankAccount>) request.getSession().getAttribute("list"); %>

  <%  if (list.isEmpty()) { %>

        <h1>No Active Accounts Found</h1>

    <% } else { %>

        <% for (BankAccount bankAccount : list) { %>
            <a href="setactiveaccount?acno=<%=bankAccount.getAccno() %>"><button><%=bankAccount.getAccno()%></button></a>
        <% } %>

    <% } %>
 
 
 		
    <div class="back-button">
        <a href="account.html">Back</a>
    </div>

</body>
</html>
