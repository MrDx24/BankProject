package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TransactionDao;

@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public TransactionController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		int acc_no = (Integer) session.getAttribute("acc_no");

		TransactionDao transactionDao =new TransactionDao();

		int result = transactionDao.checkPassword(acc_no);
		if (result==-1) {
			response.sendRedirect("setPin.jsp");
		}else
		{
			response.sendRedirect("transaction.jsp");
		}

	}

}
