<%@page import="com.dao.UserProfileDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.UserProfile"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
	<!-- <link href="cong.css" rel="stylesheet"type="text/css"/> -->
	<link href="https://fonts.googleapis.com/css?family=play" rel="stylesheet">
	
<style type="text/css">
	input {
		font-weight: bold;
	}
</style>
</head>
<body>
	
	<%! int id ; %>
	<% id = (Integer) session.getAttribute("acc_no"); %>
	<%!UserProfileDao updao = new UserProfileDao(); %>
	<%!ArrayList<UserProfile> lst = new ArrayList<UserProfile>(); %>
	<% lst = updao.userProfile(id); %>
	<div class="container"  id="body1">
   
	    <h2 class="head">User Profile</h2>
	    <form class="mt-3 p-3" name="myform" action="RegisterController" method="post">
        <div class="row p-3">
            <div class="form-group col-md-12">
            	<label>Full Name : </label><br>
                <input type="text" class="form-control text-center" id="full_name" name="full_name" placeholder="Full Name" 
                	value=<%=lst.get(0).getFullName() %> readonly="readonly"/>
            </div>
            
        </div>

        <div class="row p-3">
            <div class="form-group col-md-6">
            	<label>Gender : </label><br>
               <input type="text" class="form-control text-center" id="gender" name="gender" placeholder="Gender" 
               	value=<%=lst.get(0).getGender() %> readonly="readonly"/>
            </div>
            <div class="form-group col-md-6">
            	<label>Date of birth : </label><br>
                <input type="text" class="form-control text-center" id="full_name" name="full_name" placeholder="Date of Birth" 
                 value=<%=lst.get(0).getDob() %> readonly="readonly"/>
            </div>
        </div>
        <div class="row p-3">
            <div class="form-group col-md-3">
            	<label>State : </label><br>
                <input type="text" class="form-control text-center" id="state" name="state" placeholder="State" 
                	value=<%=lst.get(0).getState() %> readonly="readonly"/>
            </div>
            <div class="form-group col-md-3">
            	<label>City : </label><br>
                <input type="text" class="form-control text-center" id="city" name="city" placeholder="City" 
                	value=<%=lst.get(0).getCity() %> readonly="readonly"/>
            </div>
            <div class="form-group col-md-3">
            	<label>Area : </label><br>
                <input type="text" class="form-control text-center" id="area" name="area" placeholder="Area" 
                	value=<%=lst.get(0).getArea() %> readonly="readonly"/>
            </div>
            <div class="form-group col-md-3">
            	<label>Pincode : </label><br>
                <input type="text" class="form-control text-center" id="pincode" name="pincode" placeholder="Pincode" 
                	value=<%=lst.get(0).getPincode() %> readonly="readonly"/>
            </div>
        </div>
        
        <div class="row p-3">
        	
            <div class="form-group col-md-6">
            <label>Email : </label><br>
                <input type="text" class="form-control text-center" id="email" name="email" placeholder="Email Id" 
                	value=<%=lst.get(0).getEmail() %> readonly="readonly"/>
            </div>
            <div class="form-group col-md-6">
            	<label>Mobile : </label><br>
                <input type="text" class="form-control text-center" id="mobile" name="mobile" placeholder="Contact Number" 
                	value=<%=lst.get(0).getMobile() %> readonly="readonly"/>
            </div>
        </div>
        
        <div class="row p-3">
            <div class="form-group col-md-6">
            	<label>Aadhar card : </label><br>
                <input type="text" class="form-control text-center" id="aadhar" name="aadhar" placeholder="Aadhar Number" 
                 	value=<%=lst.get(0).getAadhar() %> readonly="readonly"/>
            </div>
        
            <div class="form-group col-md-6">
            <label>Pancard : </label><br>
                <input type="text" class="form-control text-center" id="pancard" name="pancard" placeholder="PAN" 
                	value=<%=lst.get(0).getPancard() %> readonly="readonly"/>
                	
            </div>
        </div>
        
        <div class="row p-3">
            <div class="form-group col-md-12">
            	<label>Account Number : </label><br>
                <input type="text" class="form-control text-center" id="account_no" name="account_no" placeholder="Account no" 
                	value=<%=lst.get(0).getAccount_no() %> readonly="readonly"/>
            </div>
        </div>
        <div class="row p-3">
            <div class="form-group col-md-12">
            	<label>Account type : </label><br>
                <input type="text" class="form-control text-center" id="account_type" name="account_type" placeholder="Account type" 
                	value=<%=lst.get(0).getAccount_type() %> readonly="readonly"/>
            </div>
        </div>
        <div class="row p-3">
            <div class="form-group col-md-12">
            	<label>Account balance : </label><br>
                <input type="text" class="form-control text-center" id="account_balance" name="account_balance" placeholder="Account Balance" 
                	value=<%=lst.get(0).getAccount_balance() %> readonly="readonly"/>
            </div>
            
        </div>	
        
         
	</form>
	</div>

</body>
</html>