<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dto.Transactions"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ViewTransactions"%>
<%@page import="com.dao.TrancferAmount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="csssteyles/steyle.css">
</head>
<body>
	<%
	HttpSession hs= request.getSession();
	String email= (String) hs.getAttribute("email");	
		Transactions t= ViewTransactions.getAllTransactions(email);
	if(t!=null){
	%>
		<table border="2px">
			<tr>
				<th>EMAIL</th>
				<th>AMOUNT</th> 
				<th>TRANCFER_EMAIL</th>
			</tr>
	<%
	%>
	<tr>
		<td><%=t.getEmail()%></td>
		<td><%=t.getAmont()%></td>
		<td><%=t.getTrancefarec_email()%></td>
	</tr>
	</table>
	<%
	}else {
	%>
	<h1>" NO HISTORY...YOU DID'T TRANCFER THE AMOUNT ANY ONE"</h1>
	<%
	}
	%>
</body>
</html>