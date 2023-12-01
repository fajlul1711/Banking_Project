<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            margin-top: 50px;
        }

        h1 {
            text-align: center;
        }

        .content {
            display: flex;
            justify-content: space-between;
            align-items: center;
            flex-wrap: wrap;
        }

        .image-container {
            flex: 1;
        }

        .image-container img {
            width: 100%;
            border-radius: 5px;
        }

        .buttons-container {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            margin-top: 20px;
            margin-left: 50px;
        }

        .buttons-container a {
            text-decoration: none;
            margin-bottom: 10px;
            display: block;
            
        }

        button {
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .back-button {
            margin-top: 20px;
            text-align: center;
        }

        .back-button a {
            text-decoration: none;
            padding: 10px 20px;
            background-color: #555;
            color: #fff;
            border-radius: 5px;
        }

        .back-button a:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome To Transaction Page</h1>
        <div class="content">
            <div class="image-container">
                <img src="image/bankingservices.jpg" alt="Image">
            </div>
            <div class="buttons-container">
                <a href="Deposit.html"><button>Deposit</button></a>
                <a href="Withdraw.html"><button>Withdraw</button></a>
                <a href="CheckBalance.jsp"><button>Check Balance</button></a>
                <a href="TransactionHistory.jsp"><button>View Transaction History</button></a>
                <a href="Logout"><button>Logout</button></a>
            </div>
        </div>
        <div class="back-button">
            <a href="account.html">Back</a>
        </div>
    </div>
</body>
</html>
