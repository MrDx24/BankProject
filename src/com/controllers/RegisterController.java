package com.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.Customer;
import com.model.Register;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String firstName = request.getParameter("first_name");
		String middleName = request.getParameter("middle_name");
		String lastName = request.getParameter("last_name");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String pc = request.getParameter("pincode");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String aadhar = request.getParameter("aadhar");
		String pancard = request.getParameter("pancard");
		String nationality = request.getParameter("nationality");
		String accountType = request.getParameter("account_type");
		String username = request.getParameter("username");
		String password = request.getParameter("password");


		if(firstName=="" || middleName=="" || lastName=="" || gender=="" || dob=="" || state=="" || city=="" ||
				area=="" || pc=="" || email=="" || mobile=="" || aadhar=="" || pancard=="" || nationality=="" ||
				accountType=="" || username=="" || password=="" ) {
			RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
			request.setAttribute("error_register", "Please fill all the fields !!!!");
			rq.forward(request, response);

		}
		else {
			int pincode = Integer.parseInt(request.getParameter("pincode"));
			Customer customer= new Customer(firstName, middleName, lastName, gender, dob, state, city, 
					area, pincode, email, mobile, aadhar, pancard, nationality);

			LocalDate date = LocalDate.now();
			String opdate = date.toString();
			Register r = new Register(customer, accountType, username, password, opdate);

			RegisterDao rdao = new RegisterDao();
			int i = rdao.setDetails(r);
			if(i==0) {
				System.out.println("Successful");
				response.sendRedirect("login.jsp");
			}
			else {
				System.out.println("not");
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
