<%@page import="dto.BankTransaction"%>
<%@page import="dto.BankAccount"%>
<%@page import="dao.BankDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
        }
         h2 {
        text-align: center;
       
    }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            
           
        }
        a{
        text-decoration: none;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h1>Welcome to Transaction History Page</h1>

<%
    long acno =(long) request.getSession().getAttribute("acno");
    BankDao bankDao = new BankDao();
    BankAccount bankAccount= bankDao.fetchByAccno(acno);
    List<BankTransaction> list = bankAccount.getBankTransactions();
%>

<h2>Account Number: <%=acno %></h2>
<h2>Account Type: <%=bankAccount.getAccountType() %></h2><br>

<table>
    <tr>
        <th>Transaction Id</th>
        <th>Deposit Amount</th>
        <th>Withdraw Amount</th>
        <th>Balance</th>
        <th>Time and Date</th>
    </tr>
    <% for(BankTransaction bankTransaction: list) { %>
        <tr>
            <td><%=bankTransaction.getTid() %></td>
            <td><%=bankTransaction.getDeposit() %></td>
            <td><%=bankTransaction.getWithdraw() %></td>
            <td><%=bankTransaction.getBalance() %></td>
            <td><%=bankTransaction.getLocalDateTime() %></td>
        </tr>
    <% } %>
</table>

<a href="TransactionPage.jsp"><button>Back</button></a>
</body>
</html>
