<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>Homepage</title>
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/cong.css" rel="stylesheet"type="text/css"/>
	<link href="https://fonts.googleapis.com/css?family=play" rel="stylesheet">
</head>
<body>
    <div class="row" style="border : 1px solid black ;height: 280px; ">
    	<div class="container col-md-6 text-center" style="border : 1px solid black">
		    <form action="TransactionController" method="post">
				<button class="btn btn-success" >Transaction</button>
		    </form>
		</div>
		<div class="container col-md-6 text-center" style="border : 1px solid black">
		    <form>
				<a class="btn btn-primary" href="addpayee.jsp" >Add payee</a>
		    </form>
	    </div>
    </div>
    
    <div class="row"style="border : 1px solid black; height: 280px; ">
    	<div class="container col-md-6 text-center" style="border : 1px solid black">
		    <form>
				<a class="btn btn-warning" href="userprofile.jsp" >User Profile</a>
		    </form>
		 </div>
		 <div class="container col-md-6 text-center" style="border : 1px solid black">   
		    <form>
				<a href="account_st.jsp" class="btn btn-success">Account statement</a>
		    </form>
	    </div>
    </div>
</body>
</html>