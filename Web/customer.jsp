<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Page</title>
</head>
<body>
<h1>Struts 2 + Hibernate example</h1>
 
<h2>Add Customer</h2>
<s:form action="addCustomer" method="post">
	<s:textfield name="name" label="Name" />
	<s:textfield name="age" label="Age" />
	<s:submit value="Add Customer" />
</s:form>
<hr>
<s:form action="listCustomer" method="post">
<s:submit value="List customers" align="center"/>
</s:form>
<h2>All Customers</h2>
<table border="1px" cellpadding="8px">
	<tr>
		<th>Customer Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Action</th>

	</tr>
	<s:iterator value="customerList" status="userStatus">
		<tr>
			<td><s:property value="customerId" /></td>
			<td><s:property value="name" /></td>
			<td><s:property value="age" /></td>
			<td><a href="deleteCustomer?customerId=<s:property value="customerId"/>">delete</a></td>
		</tr>
	</s:iterator>
</table>


<br>
</body>
</html>