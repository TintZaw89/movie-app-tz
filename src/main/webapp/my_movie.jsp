<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.MovieOrderDAOImpl"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.MovieDtls"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Movie</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7">
<c:if test="${not empty succMsg}"><div class="alert alert-success" role="alert"> ${succMsg }</div><c:remove var="succMsg" scope="session" /></c:if>
<c:if test="${not empty failedMsg}"><div class="alert alert-danger" role="alert">${failedMsg }</div><c:remove var="failedMsg" scope="session" /></c:if>
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
	<%@include file="components/navbar.jsp"%>
<%User u = (User)session.getAttribute("userobj"); %>

	<div class="container-fluid">
		<div class="row p-3">
			<%
			MovieOrderDAOImpl dao = new MovieOrderDAOImpl(DBConnect.getConn());
			List<MovieDtls> list = dao.viewMovieById(u.getId());
			
			for (MovieDtls m : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-left">
						<img alt="" src="movie/<%=m.getPhotoName()%>"
							style="width: 200px; height: 300px" class="img-thumbLin" />
						<p>Movie 	: <%=m.getMovieName()%></p>
						<p>Director : <%=m.getDirector()%></p>
						<p>Genre	: <%=m.getGenre()%></p>
						<p>Year		: <%=m.getYear()%></p>
						<% if (m.getQuantity() > 1) {%>
							<label class="text-danger">You bought same movie for <%=m.getQuantity()%> times  
							<a href="return?uid=<%=u.getId() %>&&mid=<%=m.getMovieId() %>" 
							class="btn btn-danger btn-sm"> Return</a>
							</label>
						<%} %>
						<p>
							<a href="video.jsp" class="btn btn-primary btn-sm">Watch</a>
						</p>

						
					</div>
				</div>
			</div>
			<% } %>
		</div>
	</div>
</body>
</html>