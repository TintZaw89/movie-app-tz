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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Movie</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
	<%@include file="components/navbar.jsp"%>
	<div class="container p-1" style="width: 100%" >
		<h3 class="text-center text-success">Your Order</h3>
		<table class="table table-striped table-dark mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Movie Name</th>
					<th scope="col">Director</th>
					<th scope="col">Price($)    </th>
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
					<td><%=m.getOrderId()%></td>
					<td><%=m.getUserName() %></td>
					<td><%=m.getMovieName() %></td>
					<td><%=m.getDirector() %></td>
					<td><%=m.getPrice()%></td>
					<td><%=m.getPaymentType() %></td>
				</tr>
			<% } %>
			</tbody>
		</table>

	</div>

	<%@include file="components/footer.jsp"%>
</body>
</html>