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

import com.dao.AddPayeeDao;
import com.model.AddPayee;

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

		try {
			HttpSession session = request.getSession(true);
			int accountNo = (Integer) session.getAttribute("acc_no");
			String acc_name = request.getParameter("accName");
			String acc_type = request.getParameter("accType");
			String accNo = request.getParameter("accNo");
			String conAccNo = request.getParameter("con_accNo");

			if(acc_name=="" || acc_type=="" || accNo=="" || conAccNo==""  ) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("addpayee.jsp");
				request.setAttribute("error_ap", "Please fill all the fields!!!!");
				requestDispatcher.forward(request, response);

			}

			if(!accNo.equals(conAccNo)){
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("addpayee.jsp");
				request.setAttribute("error_ap", "Account no and confirm account no do not match!!!!");
				requestDispatcher.forward(request, response);
			}
			else {

				int accno = Integer.parseInt(accNo);
				int con_accno = Integer.parseInt(conAccNo);
				AddPayee addPayee = new AddPayee(accountNo, con_accno, acc_name, acc_type);
				AddPayeeDao dao = new AddPayeeDao();
				int ans = dao.addPayee(addPayee);
				System.out.println(ans);
				RequestDispatcher rq = request.getRequestDispatcher("addpayee.jsp");
				if(ans == -1) {

					request.setAttribute("error_ap", "User with this account number does not exists. ");
					rq.forward(request, response);
				}
				if(ans == -2) {

					request.setAttribute("error_ap", "User with this account number is already added to your payee list. ");
					rq.forward(request, response);
				}
				if(ans == -3) {

					request.setAttribute("error_ap", "Unknown error. Please try again later. ");
					rq.forward(request, response);
				}
				if(ans == 1) {

					ArrayList<AddPayee> lst = dao.payeeList(accountNo);
					System.out.println(lst.get(0).getAccountName());

					request.setAttribute("payeelist", lst);
					rq.forward(request, response);
					System.out.println("successfully");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
