<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Navbar</title>
	<script src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/mainpage.css">
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" style="background: #111111!important;">
       <a class="navbar-brand" href="#">
           <img src="images/logo-black.png" alt="Navbar" width="180px">
       </a>
       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
       </button>
     
       <div class="collapse navbar-collapse" id="navbarSupportedContent" style="/*border: 1px solid white;*/">
         <ul class="navbar-nav ml-auto" style="/*border: 1px solid white;*/">
           <li class="nav-item ">
             <a class="nav-link" href="homepage1.jsp">Home</a>
           </li>
           <li class="nav-item">
             <a class="nav-link" href="about_us.jsp">About Us</a>
           </li>
           <li class="nav-item ">
             <a class="nav-link" href="userprofile.jsp">Profile</a>
           </li>
           <li class="nav-item">
             <a class="nav-link" href="login.jsp">Logout</a>
           </li>
           <!-- <a class="btn btnSignUp" href="register.html">SignUp</a> -->
           
           
         </ul>
         
       </div>
     </nav>
</body>
</html>