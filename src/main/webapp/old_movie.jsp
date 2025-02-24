<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.MovieDAOImpl"%>
<%@page import="com.entity.MovieDtls"%>
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
<title>User: Old Movie</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
	<%@include file="components/navbar.jsp"%>
	<div class="container p-5" style="width: 100%;">
<c:if test="${not empty failedMsg }"><p class="text-center text-danger">${failedMsg }</p><c:remove var="failedMsg" scope="session" /></c:if>
<c:if test="${not empty succMsg }"><div class="alert alert-success text-center text-success">${succMsg }</div><c:remove var="succMsg" scope="session" /></c:if>

		<table class="table table-bordered table-hover table-striped table-active">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Movie Name</th>
					<th scope="col">Director</th>
					<th scope="col">Price</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
			<%
								User u = (User) session.getAttribute("userobj");

								MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());

								List<MovieDtls> list = dao.getMoviesByOld(u.getEmail(),"Old");

								for (MovieDtls m : list) {
									
				%>

				<tr>
					<td><%=m.getMovieName() %></td>
					<td><%=m.getDirector() %></td>
					<td><%=m.getPrice() %></td>
					<td><a href="delete_old?id=<%=m.getMovieId()%>" class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				
				<%} %>
			</tbody>
		</table>

	</div>

</body>
</html>