<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <title>Mainpage</title>
    <head>  
    	<script src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <link rel="stylesheet" type="text/css" href="css/homepage.css">
        
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
 
 <style type="text/css">
 body {
 	background: url("images/test3.png");
    background-size: cover;
    font-family: 'Lato';
    
 }
 </style>
    </head>
    <body  >
   
          <div class="row " style="height: 50%; margin-top: 100px">
              <div class="col-lg-6 col-md-6 col-sm-4 col-xs-12 text-center mainpagetxttr">
                    <h4 style="margin-top: 100px">Welcome to</h4> 
                    <h3>Linko Bank</h3>
                    <h6>Expertise you need. Service you deserve!</h6>
                </div>
                <!-- card 2-->
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 center-align">
                    
                </div>
        </div>
        
            <div class="row" style="padding : 10px 40px 10px 40px;">
                <div class="col-lg-12 col-md-3 col-sm-4 col-xs-12">
                    <h3>Services : </h3>
                </div>
                <!-- card 1-->
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 text-center test-cust">
                <form >
                <!-- <a class="custom-link" href="userprofile.jsp"> -->
                    <div class="card">
                        <div class="card-content">
                            <i class="material-icons large">person</i>
							<i class="material-icons large">list_alt</i>
                            <h5>Profile</h5>
                            <p>
                                Profile shows the details about the customer's account. 
                            </p>
                            <a class="custom-link btn btn-primary" href="userprofile.jsp">Go to profile
                            <i class="fa fa-arrow-right" aria-hidden="true"></i></a>
                        </div>
                    </div>
                   <!-- </a> -->
                </form>
                </div>
                <!-- card 2-->
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 text-center test-cust">
                <form action="TransactionController" method="post">
                
                    <div class="card">
                        <div class="card-content">
                            <!-- <i class="material-icons large">insert_link</i> -->
                            <i class="material-icons large">person</i>
                            <i class="material-icons large">arrow_forward</i>
                            <i class="material-icons large">person</i>
                            <h5>Fund Transfer</h5>
                            <p>
                                Fund transfer is sending money from one party to another party. 
                            </p>
                            <button class="custom-link btn btn-success" >Perform transaction
                            <i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                        </div>
                    </div>
                 
                 </form>
                </div>
                <!-- card 3-->
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 text-center test-cust">
                <form >
                
                    <div class="card">
                        <div class="card-content">
                        	<i class="material-icons large">person</i>
                            <i class="material-icons large">insert_link</i>
                            <i class="material-icons large">person</i>
                            <h5>Add Beneficiary</h5>
                            <p>
                                Add beneficiary is to add a person or company to perform fund transfer.  
                            </p>
                            <a class="custom-link btn btn-info" href="addpayee.jsp">Add Beneficiary
                            <i class="fa fa-arrow-right" aria-hidden="true"></i></a>
                        </div>
                    </div>
                
                </form>
                </div>
                <!-- card 4-->
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 text-center test-cust">
                <form >
                
                    <div class="card">
                        <div class="card-content">
                            <i class="material-icons large">list_alt</i>
                            <h5>Account Statement</h5>
                            <p>
                                List of all transaction for customer's bank account. 
                            </p>
                            <a class="custom-link btn btn-danger" href="account_st.jsp">Get account statement
                            <i class="fa fa-arrow-right" aria-hidden="true"></i></a>
                        </div>
                    </div>
                
                </form>
                </div>
            </div>
              
            
              
                  
          
        <!--style!-->
       
                
    </body>
</html>

<%@ include file="footer.jsp" %>
