<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Package.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="../Images/PurpleLogoPng.png" />
<title>WeCare</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/64d58efce2.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="Customer.css" />
</head>
<%
	DAO dao = new DAO();
	List<doctor_bean> list_doctor = dao.doctor_list();

	HttpSession hs = request.getSession();
	String username = (String) hs.getAttribute("username");
	String aadhar = (String) hs.getAttribute("aadhar_no");
	int aadhar_no = Integer.valueOf(aadhar);
%>
<body>
	<div class="nav-container">
		<nav>
			<span><img id="logo"
				src="PurpleLogoPng.png" alt="Spelec" />
				<h1>WeCare</h1> </span>

			<ul>
				<l1><a>Hello <%=username %></a></l1>
				<li><a href="HomePage.html">Home</a></li>
				<li><a href="Dashboard.html" class="trans-button"><button type="button">Logout</button></a></li>
			</ul>
		</nav>
	</div>
	<div class="customer-form">
		<form method="post" name="f4" action="Servlet_5"
			onsubmit=" return validation()">

			<div>Patient Information</div>

			<div class="form-Element">
				<label>Adhaar No :</label> <input type="text" name="aadhar_no"
					placeholder="Enter Adhaar Number" value="<%=aadhar_no%>" required />
			</div>
			<div class="form-Element">
				<label>Your Name :</label> <input type="text" name="user_name"
					placeholder="Enter Your Name" required value="<%=username%>"
					required />
			</div>
			<div class="form-Element">
				<label>Date of Birth :</label> <input type="date"
					name="date_of_birth" onChange="checkDOB()" required />
			</div>
			<div class="form-Element">
				<label>Age</label> <input type="number" name="age" id="age_id"
					required />
			</div>

			<div class="form-Element">
				<label>Blood Group :</label> <select name="blood_group" required>
					<option value="">Select</option>
					<option value="O +ve">O +ve</option>
					<option value="O -ve">O -ve</option>
					<option value="A +ve">A +ve</option>
					<option value="A -ve">A -ve</option>
					<option value="B +ve">B +ve</option>
					<option value="B -ve">B -ve</option>
					<option value="AB +ve">AB +ve</option>
					<option value="AB -ve">AB -ve</option>
				</select>
			</div>


			<div class="form-Element">
				<label>Gender</label> <input type="radio" name="gender" value="male"
					required> <label>Male</label> <input type="radio"
					name="gender" value="female"> <label>Female</label> <input
					type="radio" name="gender" value="Prefer not to mention"> <label>Prefer
					not to mention</label>

			</div>

			<div class="form-Element">
				<label>Phone no :</label> <input type="text" name="phone"
					placeholder="Enter Your Phone no." required />
			</div>

			<div class="form-Element">
				<label>City :</label> <input type="text" name="city"
					placeholder="Enter Your City Name" required />
			</div>

			<div class="form-Element">
				<label>State :</label> <input type="text" name="state"
					placeholder="Enter Your State Name" required />
			</div>

			<div class="form-Element">
				<label>Zipcode :</label> <input type="text" name="zipcode"
					placeholder="Enter Your zipcode" required />
			</div>

			<div class="form-Element"">
				<label>Is this your first time visiting WeCare? :</label> <input
					type="radio" name="visit" value="Yes" required> <label>Yes</label>
				<input type="radio" name="visit" value="No"> <label>No</label>
			</div>

			<div class="form-Element">
				<label>Upload your Previous Prescription :</label> <input
					type="file" name="prescription" />
			</div>

			<div>Appointment Information</div>

			<div class="form-Element">
				<label>Appointment Date :</label> <input type="date"
					name="appointment_date" onChange="check_date()" required />
			</div>

			<div class="form-Element">
				<label>Preferred Doctor :</label> <select name="doctors" required>
					<option value="">Select</option>
					<%
						for (doctor_bean db : list_doctor) {
					%>
					<option><%=db.getDoctor_name()%></option>

					<%
						}
					%>
				</select>
			</div>

			<div class="form-Element">
				<label>Preferred Appointment Time :</label> <select
					name="appointment_time" required>
					<option value="">Select</option>
					<option value="Morning">Morning</option>
					<option value="Afternoon">Afternoon</option>
					<option value="Evening">Evening</option>
					<option value="No Preference">No Preference</option>
				</select>
			</div>

			<div>
				<button type="submit" value="Submit">Submit</button>
			</div>
		</form>
</body>
<script type="text/javascript">
	function check_date() {

		var dob = document.f4.appointment_date.value;
		var input_dob = new Date(dob);
		var today = new Date();
		if (input_dob < today) {
			alert("You cannot Select a Date From Past");
			return false;
		} else {

			return true;
		}
	}

	function checkDOB() {

		var dob = document.f4.date_of_birth.value;
		var input_dob = new Date(dob);
		var today = new Date();
		var age_id = document.getElementById('age_id');
		if (input_dob > today) {
			alert("You cannot Select a Date From Future");
			return false;
		} else {

			var month_diff = Date.now() - input_dob.getTime();
			var age_dt = new Date(month_diff);
			var year = age_dt.getUTCFullYear();
			var age = Math.abs(year - 1970);

			age_id.setAttribute('value', age);
			age_output.innerHTML = age;
			return true;
		}
	}

	function validation() {

		var phone = document.f4.phone.value;
		if (phone.length != 10) {

			alert("Invalid Phone Number");
			return false;
		} else
			return true;
	}
</script>
</html>