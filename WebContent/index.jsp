 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- Material Kit CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>

	<div class="container cont"  >
    
	    <form class="mt-3 p-3 form formreg" name="myform" action="RegisterController" method="post">
	    <h3 class="head"><img src="images/small-logo.png" alt="Bank" width="50px">Registration Form</h3>
	    <hr>
	    <% String str = (String) request.getAttribute("error_register"); %>
	    <%if(str !=null) {%>
	    	<span class="text-danger fa fa-times-circle-o" style="margin-left: 15px"> ${error_register} </span>
	    <%} %>
        <div class="row p-3">
            <div class="form-group col-md-4">
                <input type="text" class="form-control text-center" id="first_name" name="first_name" placeholder="First Name" />
            </div>
            <div class="form-group col-md-4">
                <input type="text" class="form-control text-center"   id="middle_name" name="middle_name" placeholder="Middle Name" />
            </div>
            <div class="form-group col-md-4">
                <input type="text" class="form-control text-center"   id="last_name" name="last_name" placeholder="Last Name" />
            </div>
        </div>

        <div class="row p-3">
            <div class="form-group col-md-6">
                <select class="form-control selectpicker" data-style="btn btn-link" id="gender" name="gender"
                    style="text-indent: 45%;">
                    <option selected disabled>Gender</option>
                    <option>Male</option>
                    <option>Female</option>
                    <option>Other</option>
                    <option>Don't want to specify</option>  
                </select>
            </div>
            <div class="form-group col-md-6">
                <input type="text" onfocus="(this.type='date')" onfocusout="(this.type='text')"
                    class="form-control text-center" id="dob" name="dob" placeholder="Date of Birth" />
            </div>
        </div>
        <div class="row p-3">
            <div class="form-group col-md-3">
                <select style="text-indent: 25%;" class="form-control text-center" id="state" name="state" >
                 <option selected disabled>--Select State--</option>
                    <option>Maharashtra</option>
                    <option>Delhi</option>
                    <option>Gujrat</option>
                    <option>Madhya Pradesh</option>
                    <option>Rajasthan</option>
                    <!-- add alphabeticalyohk-->
                </select>
            </div>
            <div class="form-group col-md-3">
                <select style="text-indent: 25%;" class="form-control text-center" id="city" name="city" >
                    <option selected disabled>--Select City--</option>
                    <option>Mumbai</option>
                    <option>Jaipur</option>
                    <option>Kolkata</option>
                    <option>Pune</option>
                    <option>Lucknow</option>
                </select>
            </div>
            <div class="form-group col-md-3">
                <input type="text" class="form-control text-center" id="area" name="area" placeholder="Area" />
            </div>
            <div class="form-group col-md-3">
                <input type="text" class="form-control text-center" id="pincode" name="pincode" placeholder="Pincode" />
            </div>
        </div>
        
        <div class="row p-3">
            <div class="form-group col-md-6">
                <input type="email" class="form-control text-center" id="email" name="email" placeholder="Email Id" />
            </div>
            <div class="form-group col-md-6">
                <input type="text" class="form-control text-center" id="mobile" name="mobile" placeholder="Contact Number" />
            </div>
        </div>
        <hr>
        <div class="row p-3">
            <div class="form-group col-md-12">
                <input type="text" class="form-control text-center" id="aadhar" name="aadhar" placeholder="Aadhar Number" />
            </div>
        </div>
        <div class="row p-3">
            <div class="form-group col-md-12">
                <input type="text" class="form-control text-center" id="pancard" name="pancard" placeholder="PAN" />
            </div>
        </div>
        
        <div class="row p-3">
            <div class="form-group col-md-12">
                <input type="text" class="form-control text-center" id="nationality" name="nationality" placeholder="Nationality" />
            </div>
        </div>
        <hr>
        <div class="row p-3">
            <div class="form-group col-md-12">
                <select class="form-control selectpicker" data-style="btn btn-link" id="account_type" name="account_type"
                    style="text-indent: 45%;">
                    <option selected disabled>Account Type</option>
                    <option>Savings</option>
                    <option>Current</option>
                </select>
            </div>
       	</div>
        <div class="row p-3">
            <div class="form-group col-md-12">
                <input type="text" class="form-control text-center" id="username" name="username" placeholder="Username" />
            </div>
        </div>
        <div class="row p-3">
            <div class="form-group col-md-12">
                <input type="password" class="form-control text-center" id="password" name="password" placeholder="Password" />
            </div>
            
        </div>
        
         <div class="row p-3">
            <div class="form-group col-md-12">
		        <button type="submit" name="submit" value="Submit" class="btn btn-primary sbtn" style="width: 49%" >Register</button>
		        <a name="cancel" href="login.jsp" class="btn btn-danger abtn" style="width: 49%">Cancel</a>
		        <!-- <input type="submit" name="submit" value="Submit" class="btn btn-success"  /> -->
	        </div>
            
        </div>
    </form>
    
    </div>
</body>
</html>