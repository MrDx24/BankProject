package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TransactionDao;

@WebServlet("/SetPinController")
public class SetPinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SetPinController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pin=request.getParameter("pin");
		String conformPin=request.getParameter("conformPin");
		if(pin == "" || conformPin == "" ) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("setPin.jsp");
			request.setAttribute("error", "Please fill all the fields!!!!");
			requestDispatcher.forward(request, response);
		} 
		else if(!(pin.equals(conformPin))) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("setPin.jsp");
			request.setAttribute("error", "PIN and Conform PIN not similar!!!!");
			requestDispatcher.forward(request, response);
		}
		else {

			HttpSession session =request.getSession();
			int acc_no = (Integer) session.getAttribute("acc_no");
			TransactionDao transactionDao =new TransactionDao();

			int result=transactionDao.setpassword(acc_no,Integer.parseInt(pin));

			if (result==1) {
				response.sendRedirect("transaction.jsp");
			}else
			{
				response.sendRedirect("setPin.jsp");
			}

		}
	}
}

