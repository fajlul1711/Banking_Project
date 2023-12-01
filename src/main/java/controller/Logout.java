package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class Logout extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
 req.getSession().invalidate();
 
 

 resp.getWriter().print("<div style=\"height: 100px; width: 100%; background-color: rgb(217, 243, 243); padding-top:20px;  text-align: center;\">\r\n"
			+ "        <h1>Logout successfully</h1>\r\n"
			+ "    </div>");
 req.getRequestDispatcher("home.html").include(req, resp);
 
}
}
