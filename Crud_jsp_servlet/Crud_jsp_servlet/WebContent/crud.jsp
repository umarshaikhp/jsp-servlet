<%@page import="java.util.Iterator"%>
<%@page import="com.jsoft.pojo.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="com.jsoft.daoImpl.InsertDaoImpl"%>
<%@page import="com.jsoft.dao.InsertDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
</head>
<body>
	<form action="InsertController" method="post">
		<table align="center" border="1">
			<tr>
				<td>id</td>
				<td><input type="text" name="id" id="id" readonly="readonly"></td>
			</tr>

			<tr>
				<td>username</td>
				<td><input type="text" name="uname" id="uname"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="pwd" id="password"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="email" id="email"></td>
			</tr>
			<tr>
				<td>contact</td>
				<td><input type="text" name="contact" id="contact"></td>
			</tr>
			<tr>
				<td>age</td>
				<td><input type="text" name="age" id="age"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" name="submit" id="submit"></td>
			</tr>

		</table>
	</form>
	<hr>
	<table align="center" border="1">
		<tr>
			<th>ID</th>
			<th>USERNAME</th>
			<th>EMAIL</th>
			<th>PASSWORD</th>
			<th>CONTACT</th>
			<th>AGE</th>
			<th>ACTIONS</th>
		</tr>
		<%
			InsertDao idao = new InsertDaoImpl();
			List<UserBean> list = idao.getValues();
			Iterator<UserBean> itr = list.iterator();
			UserBean ubean = null;
			while (itr.hasNext()) {
				ubean = itr.next();
		%>


		<tr>
			<td><%=ubean.getId()%></td>
			<td><%=ubean.getUname()%></td>
			<td><%=ubean.getEmail()%></td>
			<td><%=ubean.getPwd()%></td>
			<td><%=ubean.getContact()%></td>
			<td><%=ubean.getAge()%></td>
			<td><a href="#"
				onclick="update(<%=ubean.getId()%>,'<%=ubean.getUname()%>','<%=ubean.getPwd()%>','<%=ubean.getContact()%>','<%=ubean.getEmail()%>','<%=ubean.getAge()%>')">Update</a></td>
				<td><a href="InsertController?id=<%=ubean.getId()%>">Delete</a></td>
		</tr>
		
		<%
			}
		%>
	</table>
	<script type="text/javascript">
	function update(id,name, password,contact,email,age) {
		document.getElementById('id').value=id;
		document.getElementById('uname').value=name;
		document.getElementById('password').value=password;
		document.getElementById('email').value=email;
		document.getElementById('contact').value=contact;
		document.getElementById('age').value=age;
		document.getElementById('submit').innerHTML="update";
		document.getElementById('submit').value="update";
		}
	
	</script>

</body>
</html>