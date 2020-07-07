<%@page import="java.util.ArrayList"%>
<%@page import="com.model.AddPayee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Payee</title>
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
	<!-- <link href="cong.css" rel="stylesheet"type="text/css"/> -->
	<link href="https://fonts.googleapis.com/css?family=play" rel="stylesheet">
</head>
<body>
	
	<%!ArrayList<AddPayee> lst ;%>
	<% lst = (ArrayList<AddPayee>) request.getAttribute("payeelist") ;%>
	<div class="row p-3" style="height: 280px; ">
    	<div class="container col-md-12 " style="" >
		    <form action="AddPayeeController" method="post" style=" border-radius : 5px; margin: 20px">
		    	<h3 class="text-center">Add Payee</h3>
		    	<span class="text-danger" style="margin-left: 10px ">${error_ap}</span>
		    	<div class="formGroup form-inline">
		    		<input class="form-control" name = "accName" type="text" placeholder="Enter account name : " style="margin-left: 10px ">
		    		<input class="form-control" name = "accType" type="text" placeholder="Enter account type : " style="margin-left: 10px ">
		    		<input class="form-control" name = "accNo" type="number" placeholder="Enter account number :" style="margin-left: 10px ">
		    		<input class="form-control" name = "con_accNo" type="number" placeholder="Enter account number : " style="margin-left: 10px ">
		    		<button type="submit" class="btn btn-success" style="margin-left: 10px ">Add Payee</button>
		    	</div>
		    	
		    </form>
		    
		    <h3>Payees List </h3>
		    <table class="table table-bordered">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Account No </th>
				      <th scope="col">Account name</th>
				      <th scope="col">Account type</th>
				      <th scope="col">Delete Payee</th>
				    </tr>
				  </thead>
				  <tbody>
				  <%if(lst==null) { %>
				  	<tr >
				     
				      <td colspan="4">No payees added. </td>
				      
				    </tr>
				    <%} else { %>
				    	<% for(int i=0; i<lst.size(); i++){ %>
				    		<% AddPayee ap = (AddPayee) lst.get(i); %>
						    <tr>
						      <td><%= ap.getPayeeAccNo() %></td>
						      <td><%= ap.getAccountName() %></td>
						      <td><%= ap.getAccountType() %></td>
						      <td><button class="btn btn-success" style="margin-left: 10px ">Delete</button></td>
						    </tr>
				    
				   <%  } } %>
				  </tbody>
			</table>
			
		</div>

    </div>
    

</body>
</html>