<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Pin</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<!-- Material Kit CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/log.css">
</head>
<body>
	<div class="container" style="height: 361px; ">
		<h3>Set PIN</h3>
		<p class="text-warning">* Note : Transaction PIN should be of 4 Numeric Digit</p>
		<form class="form" action="SetPinController" method="post">

			<div class="row p-3">
				<div class="form-group col-md-12">
					<input type="password" pattern="[0-9]{4}" class="form-control "  id="pin" maxlength="4"
						  name="pin" placeholder="Enter Pin" />
				</div>

				<div class="form-group col-md-12">
					<input type="password" pattern="[0-9]{4}"  class="form-control " id="conformPin"
						maxlength="4" accept="number" name="conformPin"
						placeholder="Enter Confirm Pin" />
				</div>

				<div class="form-group col-md-12" style="border: 1px solid inherit;">
					<span class="text-danger"> ${error} </span>
				</div>
				<div class="form-group col-md-12">
					<button class="btn btn-block btn-success" type="submit">Submit</button>
				</div>
			</div>
		</form>

	</div>
</body>
</html>