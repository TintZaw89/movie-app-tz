<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.MovieDAOImpl"%>
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
<title>Recent Movies</title>
<%@include file="components/allCss.jsp"%>
<style type="text/css">
.crd-ho: hover {
	background-color: #fcf7f7;
}
</style>
</head>
<body style="background-color: #f7f7f7">
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
<c:if test="${not empty addCart}"><div class="alert alert-success" role="alert"> ${addCart }</div><c:remove var="addCart" scope="session" /></c:if>
<c:if test="${not empty failedMsg}"><div class="alert alert-danger" role="alert">${failedMsg }</div><c:remove var="failedMsg" scope="session" /></c:if>
<%@include file="components/navbar.jsp"%>
<%User u = (User)session.getAttribute("userobj"); %>
	<div class="container-fluid">
		<div class="row p-3">
			<%
			MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
			List<MovieDtls> list = dao.getRecentMovies();

			for (MovieDtls m : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="movie/<%=m.getPhotoName()%>"
							style="width: 200px; height: 300px" class="img-thumbLin" />
						<p><%=m.getMovieName()%></p>
						<p><%=m.getDirector()%></p>
						<p><%=m.getGenre()%></p>
						<p><%=m.getYear()%></p>
						<p>
							Category: <%=m.getMovieCategory()%></p>
						<p>
							Price: <a href="" class="btn btn-danger btn-sm"><i
								class="fas fa-dollar-sign"></i> <%=m.getPrice()%></a></p>

						<%
						if (m.getStatus().equals("Active") && m.getQuantity() > 0) {
						%>
						<p><a href="cart?mid=<%=m.getMovieId()%>&&uid=<%=u.getId()%>&&pid=all_recent_movies"
						 class="btn btn-danger btn-sm"><i class="fas fa-cart-plus"></i> Add Cart</a> <a href="view_movies.jsp?mid=<%=m.getMovieId()%>" class="btn btn-success btn-sm">View Details</a></p>
						<%
						} else {
						%>
						<p><a href="view_movies.jsp?mid=<%=m.getMovieId()%>" class="btn btn-success btn-sm">View Details</a></p>
						<%
						}
						%>

					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>

</body>
</html>