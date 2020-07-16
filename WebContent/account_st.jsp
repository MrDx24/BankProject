<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="navbar.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Statement</title>
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
<link rel="stylesheet" href="css/account.css">
</head>
<body>
	
	<%!ArrayList<Transaction> lst = new ArrayList<Transaction>(); %>
	<%lst = (ArrayList<Transaction>)request.getAttribute("lst"); %>
	
	<div class="container-fluid cont"  id="body1"  >
	    <form class="mt-3 p-3 form formacc" id="formacc" name="myform" action="AccountStatementController" method="post" >
		    <h2 class="head">Account Statement  <i class="fa fa-list-alt" aria-hidden="true"></i></h2>
		    <hr>
		    <span class="text-danger" style="margin-left: 15px; margin-top: -10px ; "> ${error_acc_st} </span>
	        <div class="row p-3" style="margin-top: 0px">
	        
	            <div class="form-group col-md-4">
	            	<label>From date : </label><br>
	                <input type="text" class="form-control text-center" onfocus="(this.type='date')" onfocusout="(this.type='text')" id="from_date" name="from_date" placeholder="From date" />
	            </div>
	            <div class="form-group col-md-4">
	            	<label>Till date : </label><br>
	                <input type="text" class="form-control text-center" onfocus="(this.type='date')" onfocusout="(this.type='text')"  id="to_date" name="to_date" placeholder="To date" />
	            </div>
	            <div class="form-group col-md-4">
	            	<label>Click here : </label><br>
	                <button type="submit" name="submit" value="Submit" class="btn btn-primary sbtn">Get Statement</button>
	            </div>
	        </div>
	        
        </form>
        <hr>
        <div class="table-custom">
	        <table id="account_st_table" class="table table-bordered ">
		        <thead class="thead-dark">
		        	<tr>
				      <th scope="col">Transaction Id</th>
				      <th scope="col">Payee name</th>
				      <th scope="col">Amount</th>
				      <th scope="col">Transaction date</th>
				      <th scope="col">Transaction time</th>
				    </tr>
		        </thead>
		        <tbody>
		        	<%if(lst==null) { %>
						  	<tr >
						     
						      <td colspan="5">Please select dates from where to where you want transactions. </td>
						      
						    </tr>
				    <%} else { %>
				    	<% for(int i=0;i<lst.size();i++) { %>
				    		<% Transaction tr = (Transaction) lst.get(i); %>
						    <tr>
						      <td><%= tr.getTransaction_id() %></td>
						      <td><%= tr.getPayee_acc_no() %></td>
						      <% if(tr.getOperation().equals("sent")) {%>
						      	<td style="color:red;"> - <%= tr.getAmount() %> <i class="fa fa-arrow-right" style="transform: rotate(-45deg);"></i></td>
						      <% } %>
						      <% if(tr.getOperation().equals("recieved")) {%>
						      	<td style="color:green;"> + <%= tr.getAmount() %> <i class="fa fa-arrow-left" style="transform: rotate(-45deg);"></i></td>
						      <% } %>
						      <td><%= tr.getTransaction_date() %></td>
						      <td><%= tr.getTransaction_time() %></td>
						      
						    </tr>
				    
				   <%  } } %>
		        </tbody>
	        </table>
        </div>
  		<script >
  			$(document).ready(function () {
			  $('#account_st_table').DataTable();
			  $('.dataTables_length').addClass('bs-select');
			});
  		</script>
  	
  	</div>
</body>
</html>

