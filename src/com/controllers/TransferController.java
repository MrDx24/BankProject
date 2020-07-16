package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TransactionDao;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

/**
 * Servlet implementation class TransferController
 */
@WebServlet("/TransferController")
public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String payeeDetails = request.getParameter("payeeNo");
		String amount_to_transfer = request.getParameter("amount");
		String trpassword = request.getParameter("trpsswd");
		RequestDispatcher rq = request.getRequestDispatcher("transaction.jsp");
		HttpSession session = request.getSession(true);
		if(payeeDetails=="" || amount_to_transfer=="" || trpassword=="") {
			request.setAttribute("error_tr", "Please fill all the fields!!!!");
			rq.forward(request, response);
		}
		else {
			int accno = (Integer) session.getAttribute("acc_no");
			TransactionDao dao = new TransactionDao();
			int ans = dao.checkTrpsswd(accno, trpassword);
			if(ans==-1) {
				request.setAttribute("error_tr", "Inavlid password!");
				rq.forward(request, response);
			}
			if(ans==-2 ) {
				request.setAttribute("error_tr", "Unknown error. Please try again later. ");
				rq.forward(request, response);
			}
			if(ans==1) {
				String arr[] = payeeDetails.split("-");
				int reciever_acc = Integer.parseInt(arr[0]);
				int amount = Integer.parseInt(amount_to_transfer);
				int res = dao.trancsactionProcess(accno, reciever_acc, amount);
				if(res == -1) {
					request.setAttribute("error_tr", "Cannot perform transaction. Reason : Balance is less than minimiun balance");
					rq.forward(request, response);
				}
				if(res == -2) {
					request.setAttribute("error_tr", "Not sufficient balance");	
					rq.forward(request, response);
				}
				if(res == -3) {
					request.setAttribute("error_tr", "Cannot perform transaction. Reason : Balance going less than minimiun balance");
					rq.forward(request, response);
				}
				if(res == -4) {
					request.setAttribute("error_tr", "Unknown error");
					rq.forward(request, response);
				}
				if(res == 1) {
					request.setAttribute("success_tr", "Transfered successfully");
					rq.forward(request, response);
				}
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
