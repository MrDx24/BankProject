<%@page import="com.dao.TransactionDao"%>
<%@page import="com.dao.AddPayeeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.AddPayee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
    <!-- Latest compiled JavaScript -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/transaction.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
</head>
<body>

	<%! ArrayList<AddPayee> lst = new ArrayList<AddPayee>(); %>
	<%! AddPayeeDao dao = new AddPayeeDao(); %>
	<%! int id; %>
	<% id = (Integer) session.getAttribute("acc_no");
	lst = (ArrayList<AddPayee>) dao.payeeList(id) ; %>
	<%! String payeeDetails; TransactionDao tdao = new TransactionDao(); %>
	<% String error= (String) request.getAttribute("error_tr");
		String success = (String) request.getAttribute("success_tr"); %>
	<% int balance = tdao.account_balance(id); %>

	<div class="container-fluid cont">
	    <form class="mt-3 p-3 form formacc" action="TransferController" method="post" >
		    <div class="row p-3 payeeName" style="margin-top: 0px">
		    
		    	<h3 class="head" >Fund Transfer 
		    	<i class="fa fa-user" aria-hidden="true"></i>
		    	<i class="fa fa-arrow-right" aria-hidden="true"></i>
		    	<i class="fa fa-user" aria-hidden="true"></i>
		    	<span class="float-right">
		    	<i class="fa fa-money" aria-hidden="true"></i>
		    	Balance : Rs. <%= balance %></span>
		    	</h3>
					
			    	
				
			     <% if(error != null) { %>
				    <span class="text-danger " style="margin-left: 15px; margin-top: -10px ; font-family:'Lato'; ">
				    <i class="fa fa-times-circle-o" aria-hidden="true"></i>
				     ${error_tr} </span>
			     <%} %>
			     <% if(success != null) {  %>
				    <span class="text-success " style="margin-left: 15px; margin-top: -10px ; font-family:'Lato';">
				    <i class="fa fa fa-check-circle-o" aria-hidden="true"></i>
				     ${success_tr} </span>
			     <% } %>
		        
		        
		            <div class="form-group col-md-12 ">
		            	<hr>
		            	<label>Beneficiary Details : </label><br>
		                <select class="form-control text-center" id="payeeNo" name="payeeNo" >
		                 	
		                 	<% if(lst.size()==0){%>
		                 		<option selected disabled>--Please add beneficiaries to perform transaction--</option>
		                 	<% } else { %>
		                 		<option selected disabled>--Select beneficiary--</option>
		                 	 <% for(AddPayee ap : lst) {%>
		                 	 <% payeeDetails = ap.getPayeeAccNo()+"-"+ap.getAccountName(); %>
		                    <option><%= payeeDetails %></option>
		                    <%} } %>
	                    <!-- add alphabeticalyohk-->
	                </select>
	                </div>
	            </div>
	            <hr>
	        	
		        <div class="row p-3 payeeAmount" style="margin-top: 0px">
		            <div class="form-group col-md-12">
		            	<label>Amount to transfer : </label><br>
		                <input type="text" class="form-control text-center" id="amount" name="amount" placeholder="Enter amount" />
		            </div>
		            <div class="form-group col-md-12">
		            	<label>Transaction Password : </label><br>
		                <input type="password" class="form-control text-center" id="trpsswd" name="trpsswd" placeholder="Enter transaction password" />
		            </div>
		            <div class="form-group col-md-12">
		            	<label>Click here : </label><br>
		                <button type="submit" id="perform" name="submit" value="Submit" class="btn btn-primary sbtn">Perform transaction</button>
		            </div>
		        </div>
	    </form>
        </div>
		
		

</body>
</html>

<%@ include file="footer.jsp" %>