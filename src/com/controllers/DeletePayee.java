package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AddPayeeDao;

/**
 * Servlet implementation class DeletePayee
 */
@WebServlet("/DeletePayee")
public class DeletePayee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePayee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String payee_acc_no = request.getParameter("payee_acc_no") ;
		System.out.println("payee acc no : " + payee_acc_no);
		RequestDispatcher rq = request.getRequestDispatcher("addpayee.jsp");
		if( payee_acc_no.equals("")) {
			request.setAttribute("error_ap", "Error in deleting payee. Please try again later. ");
			rq.forward(request, response);
		}
		else {
			HttpSession session = request.getSession(true);
			int accNo = (Integer) session.getAttribute("acc_no");
			int payeeAccNo = Integer.parseInt(payee_acc_no);
			
			AddPayeeDao dao = new AddPayeeDao();
			int ans = dao.deletePayee(accNo, payeeAccNo);
			if(ans==1) {
				request.setAttribute("success", "Deleted successfully");
				rq.forward(request, response);
			}
			if(ans==-1) {
				request.setAttribute("error_ap", "Error in deleting payee");
				rq.forward(request, response);
			}
			if(ans==-2) {
				request.setAttribute("error_ap", "Unkown error. Error in deleting payee");
				rq.forward(request, response);
			}
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
