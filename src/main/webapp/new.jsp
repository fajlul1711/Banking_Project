<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

        .button-container {
            text-align: center;
            margin-bottom: 20px;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .button[type="reset"] {
            background-color: #888;
        }

        form {
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="left-side">
            <img src="image/banktype.png" alt="Image">
        </div>

        <div class="right-side">
            <h1>Welcome to Responsive JSP Page</h1>

            <div class="button-container">
                <a href="#" class="button">Link Button 1</a>
                <a href="#" class="button">Link Button 2</a>
            </div>

            <form action="your_action_url" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required="required">

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required="required">

                <div class="button-container">
                    <button type="submit">Submit</button>
                    <button type="reset" class="button" style="background-color: #888;">Cancel</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
