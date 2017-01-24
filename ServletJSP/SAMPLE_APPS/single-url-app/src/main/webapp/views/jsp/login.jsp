<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="home" method="post">
		<table>
			<tr>
				<td><label>User Name</label></td>
				<td><input type="text" name="userName" required/></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="password" required/></td>
			</tr>
			<tr>
				<td><input type='submit' value='Submit'/></td>
				<td><input type='reset' value='Reset'/></td>
			</tr>

		</table>
	</form>
</body>
</html>