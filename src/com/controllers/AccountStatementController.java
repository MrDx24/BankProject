package com.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AccountStatementDao;
import com.model.Transaction;

/**
 * Servlet implementation class AccountStatementController
 */
@WebServlet("/AccountStatementController")
public class AccountStatementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountStatementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("account_st.jsp");
		if(from_date == "" || to_date == "") {
			
			request.setAttribute("error_acc_st", "Please fill all the fields!!!!");
			requestDispatcher.forward(request, response);
		}
		else{
			HttpSession session = request.getSession(true);
			int id = (Integer) session.getAttribute("acc_no");
			AccountStatementDao dao = new AccountStatementDao();
			ArrayList<Transaction> lst =  dao.account_statement(id, from_date, to_date);
			
			
			request.setAttribute("lst", lst);
			requestDispatcher.forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
