<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<style>
form label {
	display: inline-block;
	width: 100px;
}

form div {
	margin-bottom: 10px;
}

.error {
	color: red;
	margin-left: 5px;
}

label.error {
	display: inline;
}
</style>

<script type="text/javascript">
	$(function() {
		//This function is for get Datepicker
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			maxDate : new Date()
		});
	

	//This function validate form elements
	 $('form[id="ssnRegForm"]').validate({
		rules : {
			firstName : 'required',
			lastName : 'required',
			gender : 'required',
			phno : 'required',
			dob : 'required',
				
		},
		messages : {
			firstName : 'This field is required',
			lastName : 'This field is required',
			gender : 'select gender',
			phno : 'This field is required',
			dob : 'This field is required',		
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
</script>

<title>Registration Form</title>
</head>
<body>
	
	<div align="center">
	
	<h2 style="color: gray; text-align: center">SSN REGISTRATION FORM</h2>
	<div style="color:green; text-align: center">${SUCCESS}</div>
	<div style="color:red; text-align: center">${ERROR}</div>
	
	<form:form action="ssnRegistration" method="post" modelAttribute="ssnModel" id="ssnRegForm">
		<div align="center">
			<table>
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstName" id="firstName"/></td>
				</tr>
				
				<tr>
					<td>Last Name :</td>
					<td><form:input path="lastName" /></td>
				</tr>
				
				<tr>
					<td>Gender :</td>
					<td>
						<form:radiobutton path="gender" value="M"/>Male
						<form:radiobutton path="gender" value="F"/>Female
					</td>
				</tr>
				
				<tr>
					<td>Phone :</td>
					<td><form:input path="phno" /></td>
				</tr>

				<tr>
					<td>DOB :</td>
					<td><form:input path="dob" id="datepicker"/></td>
				</tr>

				<tr>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	</div>
</body>
</html>