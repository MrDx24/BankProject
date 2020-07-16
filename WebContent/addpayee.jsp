<%@page import="com.dao.AddPayeeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.AddPayee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Payee</title>
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	
	<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" ></script>
	<link rel="stylesheet" href="css/addpayee.css">
</head>
<body>
	
	<%!ArrayList<AddPayee> lst ;%>
	<%!int id; %>
	<% id = (Integer) session.getAttribute("acc_no");  %>
	<%!AddPayeeDao dao = new AddPayeeDao(); %>
	<% lst =  (ArrayList<AddPayee>) dao.payeeList(id) ;%>
	
    	<div class="container-fluid cont" >
		    <form class="mt-3 p-3 form formpayee" action="AddPayeeController" method="post" style=" border-radius : 5px; ">
		    	<h3 class="">Add Beneficiary <i class="fa fa-user" aria-hidden="true"></i></h3>
		    	<hr>
		    	<span class="text-danger" style="margin-left: 10px ">${error_ap}</span>
		    	<div class="row p-3" style="margin-top: 0px">
			    	<div class="form-group col-md-2">
			    		<label>Enter account name : </label>
			    		<input class="form-control" name = "accName" type="text" placeholder="Enter account name : " >
			    	</div>
			    	<div class="form-group col-md-2">
			    		<label>Enter account type : </label>
			    		<input class="form-control" name = "accType" type="text" placeholder="Enter account type : " >
			    	</div>
			    	<div class="form-group col-md-3">
			    		<label>Enter account number : </label>
			    		<input class="form-control" name = "accNo" type="number" placeholder="Enter account number :" >
			    	</div>
			    	<div class="form-group col-md-3">
			    		<label>Enter confirm account number : </label>
			    		<input class="form-control" name = "con_accNo" type="number" placeholder="Enter confirm account number : " >
			    	</div>
			    	<div class="form-group col-md-2">
			    		<label>Click here : </label>
			    		<input type="submit" class="btn btn-success"  value="Add Beneficiary" >
			    	</div>
		    	</div>
		    </form>
			
		<hr>
		<div class="table-custom" >
		<!-- <h3>Payees List </h3> -->
		    <table id="payeeList" class="table table-bordered">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Account No </th>
				      <th scope="col">Account name</th>
				      <th scope="col">Account type</th>
				      <th scope="col">Delete Beneficiary</th>
				    </tr>
				  </thead>
				  <tbody>
				  <%if(lst.size()<=0) { %>
				  	<tr >
				     
				      <td colspan="4">No payees added. </td>
				      
				    </tr>
				    <%} else { %>
				    	<% for(AddPayee ap : lst){ %>
				    		<%-- <% AddPayee ap = (AddPayee) lst.get(i); %> --%>
						    <tr>
						      <td><%= ap.getPayeeAccNo() %></td>
						      <td><%= ap.getAccountName() %></td>
						      <td><%= ap.getAccountType() %></td>
						      <td>
							      <form action="DeletePayee" method="post">
							      	<input id="payee_acc_no" name="payee_acc_no" value=<%= ap.getPayeeAccNo() %> type="hidden" >
							      	<button class="btn btn-success" style="margin-left: 10px; width: 90% ">Delete</button>
							      </form>
						      </td>
						    </tr>
				    
				   <%  } } %>
				  </tbody>
			</table>

    	</div>
    	</div>
    	<script >
  			$(document).ready(function () {
			  $('#payeeList').DataTable();
			  $('.dataTables_length').addClass('bs-select');
			});
  		</script>
    

</body>
</html>

<%@ include file="footer.jsp" %>

