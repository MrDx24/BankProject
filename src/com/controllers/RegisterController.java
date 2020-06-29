package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String accName = request.getParameter("acc_name");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String aadhar = request.getParameter("aadhar");
		String pancard = request.getParameter("pancard");
		String nationality = request.getParameter("nationality");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String opdate = request.getParameter("opdate");
		
		Register r = new Register(accName, gender,dob ,state, city, area, pincode, email, mobile, aadhar, pancard, nationality, username, password, opdate);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
