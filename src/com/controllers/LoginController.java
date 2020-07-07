package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.model.Login;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public LoginController() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username == "" || password == "") {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error", "Please fill all the fields!!!!");
			requestDispatcher.forward(request, response);
		} 
		else {
			Login l = new Login();
			l.setUsername(username);
			l.setPassword(password);
			LoginDao loginDao = new LoginDao();
			try {

				int result = loginDao.validate(l);

				System.out.println("Login result : id :  " + result);
				HttpSession session = request.getSession(true);
				if (result==-1) {
					System.out.println("Error in login");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
					request.setAttribute("error", "Invalid credentials!!!!");
					requestDispatcher.forward(request, response);

				} 
				else {
					session.setAttribute("error", " ");
					session.setAttribute("acc_no", result);
					System.out.println("Successful");
					response.sendRedirect("homepage.jsp");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
