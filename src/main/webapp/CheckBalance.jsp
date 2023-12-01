<%@page import="dto.CustomerTableDto"%>
<%@page import="dto.BankAccount"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Check Balance Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: block;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .container {
            display: flex;
            max-width: 800px;
            width: 100%;
             margin: 20px auto;
        }

        .left-side {
            flex: 1;
            padding: 20px;
           
        }

        .right-side {
            flex: 2;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }

        h1 {
            text-align: center;
        }

        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to Check Balance Page</h1>

    <%
        long acno = (long) request.getSession().getAttribute("acno");
        BankDao bankDao = new BankDao();
        BankAccount bankAccount = bankDao.fetchByAccno(acno);
        CustomerTableDto customerTableDto = bankAccount.getCustomerTableDto();
    %>

    <div class="container">
        <div class="left-side">
            <!-- Adjust the image path accordingly -->
            <img src="image/check-bank-transaction-history.jpeg" alt="Profile Image">
        </div>
        <div class="right-side">
            <h1>Hello <%=customerTableDto.getFirstname() %> Your Bank Balance: <%= bankAccount.getAmount() %></h1>
            <a href="TransactionPage.jsp"><button>Back</button></a>
        </div>
    </div>
</body>
</html>
