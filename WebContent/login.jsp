<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet"  type="text/css" href="css/log.css">
</head>
<body>
	<div class="container" style="height: 360px;" >
	<h3><img src="images/small-logo.png" alt="Bank" width="50px">Login</h3>
	<hr>
		<form class="form" action="LoginController" method="post">
		
			<div class="row p-3">
	            <div class="form-group col-md-12">
	                <input type="text" class="form-control " id="username" name="username" placeholder="Username"  />
	            </div>
	        	
	            <div class="form-group col-md-12">
	                <input type="password" class="form-control " id="password" name="password" placeholder="Password"  />
	            </div>
	            
	            <% String str = (String) request.getAttribute("error"); %>
	    		<% if(str !=null) {%>
	        	<div class="form-group col-md-12" style="border: 1px solid inherit;">
	        		<span class="text-danger fa fa-times-circle-o"> ${error} </span>
	        	</div>
	        	<%} %>
	            <div class="form-group col-md-12">
					<a class="float-right " href="index.jsp" >New user? Register</a><br>
					<button class="btn btn-block btn-success" type="submit">Login</button>	
				</div>
			</div>	
		</form>
	</div>
</body>
</html>