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
<link rel="icon" href="PurpleLogoPng.png" />
<title>WeCare</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" href="Doctor.css" />
</head>
</head>
<body>
	<div class="nav-container">
		<nav>
			<span><img id="logo"
				src="PurpleLogoPng.png" />
				<h1>WeCare</h1> </span>

			<ul>
				<li><a href="HomePage.html">Home</a></li>
				<li><a href="Register.html">Register</a>
				</li>
				<li><a href="Dashboard.html" class="trans-button"><button type="button">Logout</button></a></li>
			</ul>
		</nav>
	</div>
	<%
		DAO dao = new DAO();
		List<customer_bean> list_customer = dao.customer_list();	
	%>
	<table align="center" border="5" width="1000" id="doc_table">
		<tr>
			<th>Appointment Number</th>
			<th>Customer Name</th>
			<th>Age</th>		
			<th>Gender</th>
			<th>Blood Group</th>
			<th>Date of Birth</th>
			<th>Appointment Date</th>
			<th>Appointment Time</th>
			<th>Preferred Doctor</th>
			<th>Actions</th>
		</tr>
		<%
			for (customer_bean cb : list_customer) {
		%>
		<tr>
			<td><%=cb.getAppointment_id()%></td>
			<td><%=cb.getUser_name()%></td>
			<td><%=cb.getAge()%></td>
			<td><%=cb.getGender()%></td>
			<td><%=cb.getBlood_group()%></td>
			<td><%=cb.getDob() %></td>
			<td><%=cb.getAppointment_date() %></td>
			<td><%=cb.getAppointment_time() %></td>
			<td><%=cb.getPreferred_doctor() %></td>
			<td><a href="Servlet_6?id=<%=cb.getAppointment_id()%>"><button class="butt"onsubmit="">Accept</button></a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
<style>
#doc_table {
	visibility: visible;
}
</style>
</html>