<%--

<%@page import="dto.CustomerTableDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Responsive JSP Page</title>

<style>
body {
	font-family: 'Arial', sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f5f5f5;
	color: #333;
	text-align: center;
}

.container {
	display: flex;
	max-width: 800px;
	margin: 50px auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.left-side {
	flex: 1;
	text-align: center;
}

.left-side img {
	max-width: 100%;
	height: auto;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.right-side {
	flex: 1;
	padding: 0 20px;
}

label {
	display: block;
	margin-bottom: 10px;
	text-align: left;
}

select, input {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	box-sizing: border-box;
}

button {
	display: inline-block;
	padding: 10px 20px;
	background-color: #333;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-right: 10px;
}

button[type="reset"] {
	background-color: #888;
}
</style>
</head>
<body>

	<div class="container">
		<div class="left-side">
			<img src="image/banktype.png" alt="Image">
		</div>

		<div class="right-side">
			<h1>Welcome to Bank Account Creation Page</h1>

			<%
			CustomerTableDto customerTableDto = (CustomerTableDto) request.getSession().getAttribute("customerTableDto");
			%>
			<h1>
				Hello:
				<%=customerTableDto.getFirstname()%></h1>
				
			<form action="createbankaccount" method="post">
				<label for="select1">Select Bank Type:</label> <select id="select1"
					name="select1">
					<option name="banktype" value="savings" required="required">Savings</option>
					<option name="banktype" value="current">Current</option>
					<option value="salaryaccount">Salary Account</option>
				</select>

				<!-- 
                <label for="select2">Select Option 2:</label>
                <select id="select2" name="select2">
                    <option value="optionA">Option A</option>
                    <option value="optionB">Option B</option>
                    <option value="optionC">Option C</option>
                </select>
                 -->

				<button type="submit">Submit</button>
				<button type="reset">Cancel</button>
			</form>
		</div>
	</div>

</body>
</html>
 --%>
 
 
 <%@page import="dto.CustomerTableDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
           	display: flx;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            display: flex;
            max-width: 800px;
            margin: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            overflow: hidden;
            margin: 50px auto;
        }

        .image-container {
            flex: 1;
            overflow: hidden;
        }

        .image-container img {
            width: 100%;
            height: auto;
            display: block;
        }

        .form-container {
            flex: 1;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        button[type="reset"] {
            background-color: #f44336;
        }
        
        .btn{
        margin-top: 250px;
        margin-right: 50px;
        }
    </style>
    <title>Bank Account Creation Page</title>
</head>
<body>
			<h1>Welcome to Bank Account Creation Page</h1>

			<%
			CustomerTableDto customerTableDto = (CustomerTableDto) request.getSession().getAttribute("customerTableDto");
			%>
			<h1>
				Hello:
				<%=customerTableDto.getFirstname()%></h1>
    
    <div class="container">
        <div class="image-container">
            <!-- Replace 'your-image-path.jpg' with the actual path to your image -->
            <img src="image/banktype.png" alt="Bank Image">
        </div>
        <div class="form-container">
            <h1>Select bank type</h1>
            <form action="createbankaccount">
                <input type="radio" name="banktype" value="savings" required="required">Savings
                <input type="radio" name="banktype" value="current" required="required">Current<br><br>
                <button type="submit">Submit</button><button type="reset">Cancel</button>
            </form>
        </div>
        
        <div class="btn"><a href="account.html"> <button>Back</button> </a></div>
        
    </div>
    
</body>
</html>
 
