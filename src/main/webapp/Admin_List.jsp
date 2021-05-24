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
<link rel="stylesheet" href="AdminList.css" />
</head>
<body>
	<div class="nav-container">
		<nav>
			<span><img id="logo"
				src="PurpleLogoPng.png" alt="Spelec" />
				<h1>WeCare</h1> </span>

			<ul>
				<li><a href="HomePage.html">Home</a></li>
				<li><a href="Register.html">Register</a>
				</li>
				<li><a href="Login.html" class="trans-button"><button type="button">Login</button></a></li>
			</ul>
		</nav>
	</div>
	<%
		DAO dao = new DAO();
		List<doctor_bean> list_doctor = dao.doctor_list();
		List<user_bean> list_user = dao.user_list();
	%>
	<button onclick="display_doctor()" id="doc-but">Doctor List</button>
        <button onclick="doctor_close()" id="doc-close-but">Close</button>
	<table align="center" border="5" width="700" id="doc_table">
		<tr>
			<th>License Number</th>
			<th>Doctor Name</th>
			<th>Email Id</th>
			<th>Password</th>
			<th>Phone Number</th>
		</tr>
		<%
			for (doctor_bean db : list_doctor) {
		%>
		<tr>
			<td><%=db.getLicense_no()%></td>
			<td><%=db.getDoctor_name()%></td>
			<td><%=db.getEmail_id()%></td>
			<td><%=db.getPassword()%></td>
			<td><%=db.getPhone_no()%></td>
		</tr>
		<%
			}
		%>
	</table>

	<button onclick="display_user()" id="user-but">User List</button>
    <button onclick="user_close()" id="user-close-but">Close</button>
	<table align="center" border="5" width="700" id="user_table">
		<tr>
			<th>Aadhar Number</th>
			<th>User Name</th>
			<th>Email Id</th>
			<th>Password</th>
			<th>Phone Number</th>
		</tr>
		<%
			for (user_bean ub : list_user) {
		%>
		<tr>
			<td><%=ub.getAadhar_no()%></td>
			<td><%=ub.getUser_name()%></td>
			<td><%=ub.getEmail_id()%></td>
			<td><%=ub.getPassword()%></td>
			<td><%=ub.getPhone_no()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
    <script>
        function display_doctor() {
            document.getElementById('doc_table').style.visibility = 'visible';
            document.getElementById('doc-close-but').style.visibility =
                'visible';
        }
        function doctor_close() {
            document.getElementById('doc_table').style.visibility = 'hidden';
            document.getElementById('doc-close-but').style.visibility =
                'hidden';
        }
        function display_user() {
            document.getElementById('user_table').style.visibility = 'visible';
            document.getElementById('user-close-but').style.visibility =
                'visible';
        }
        function user_close() {
            document.getElementById('user_table').style.visibility = 'hidden';
            document.getElementById('user-close-but').style.visibility =
                'hidden';
        }
    </script>
<style>
#doc_table {
	visibility: hidden;
}

#user_table {
	visibility: hidden;
}
</style>
</html>