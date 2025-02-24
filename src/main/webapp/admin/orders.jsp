<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.MovieOrderDAOImpl"%>
<%@page import="com.entity.MovieOrderView"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Orders</title>
<%@include file="allCss.jsp"%>
</head>
<body>
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
	<%@include file="navbar.jsp"%>
	<h3 class="text-center">Hello Admin</h3>

	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Order ID</th>
				<th scope="col">User Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone No</th>
				<th scope="col">Movie Name</th>
				<th scope="col">Director</th>
				<th scope="col">Price($)</th>
				<th scope="col">Payment Type</th>
			</tr>
		</thead>
		<tbody>
		<%
					User u = (User) session.getAttribute("userobj");

					MovieOrderDAOImpl dao = new MovieOrderDAOImpl(DBConnect.getConn());

					List<MovieOrderView> movieOrders = dao.viewMovieOrder(u.getEmail());

					for (MovieOrderView m : movieOrders) {
		%>
			<tr>
				<td><%=m.getOrderId() %></td>
				<td><%=m.getUserName() %></td>
				<td><%=m.getEmail() %></td>
				<td><%=m.getAddress() %></td>
				<td><%=m.getPhoneNumber() %></td>
				<td><%=m.getMovieName() %></td>
				<td><%=m.getDirector() %></td>
				<td><%=m.getPrice() %></td>
				<td><%=m.getPaymentType() %></td>
			</tr>
			<% }%>
		</tbody>
	</table>
	<div style="margin-top: 240px;">
	<%@include file="footer.jsp" %>
	</div>
</body>
</html>