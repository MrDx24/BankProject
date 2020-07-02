package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPayeeController
 */
@WebServlet("/AddPayeeController")
public class AddPayeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acc_name = request.getParameter("accName");
		String acc_type = request.getParameter("accType");
		int accno = Integer.parseInt(request.getParameter("accNo"));
		int con_accno = Integer.parseInt(request.getParameter("con_accNo"));
		
		if(acc_name=="" || acc_type=="" || request.getParameter("accNo")=="" || request.getParameter("con_accNo")==""  ) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error_ap", "Please fill all the fields!!!!");
			requestDispatcher.forward(request, response);
			
		}
		else {
			
			
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
