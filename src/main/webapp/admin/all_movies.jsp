<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.MovieDAOImpl"%>
<%@page import="com.entity.MovieDtls"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: All Movie</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
<c:if test="${empty userobj}"> <c:redirect url="../login.jsp"/> </c:if>
	<h3 class="text-center">Movie List</h3>
	
<c:if test="${not empty failedMsg }"><p class="text-center text-danger">${failedMsg }</p><c:remove var="failedMsg" scope="session" /></c:if>
<c:if test="${not empty succMsg }"><p class="text-center text-success">${succMsg }</p><c:remove var="succMsg" scope="session" /></c:if>
	
	
	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Image</th>
				<th scope="col">Movie Name</th>
				<th scope="col">Director</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th class="text-center" scope="col">Available Unit</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%

			MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());

			List<MovieDtls> list = dao.getAllMovies();

			for (MovieDtls m: list) {

			%>

			<tr>

				<td><%=m.getMovieId()%></td>

				<td><img src="../movie/<%=m.getPhotoName()%>"
					style="width: 50px; height: 50PX;"></td>

				<td><%=m.getMovieName()%></td>

				<td><%=m.getDirector()%></td>

				<td><p>$ <%=m.getPrice()%></p></td>

				<td><%=m.getMovieCategory()%></td>

				<td><%=m.getStatus()%></td>
				
				<td class="text-center"><%=m.getQuantity()%></td>

				<td><a href="edit_movies.jsp?id=<%=m.getMovieId()%>" class="btn btn-sm btn-primary"><i class="fas fa-edit"></i> Edit</a> 
				<a href="../delete?id=<%=m.getMovieId()%>" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i> Delete</a></td>

			</tr>

			<%

			}

			%>
		</tbody>
	</table>
	<div style="margin-top: 240px;">
	<%@include file="footer.jsp" %>
	</div>
</body>
</html>