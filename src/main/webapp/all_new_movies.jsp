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
<title>New Movies</title>
<%@include file="components/allCss.jsp"%>
<style type="text/css">
.crd-ho: hover {
	background-color: #fcf7f7;
}

#toast {
	visibility: hidden; /* Hidden by default. Visible on click */
	min-width: 300px; /* Set a default minimum width */
	margin-left: -125px; /* Divide value of min-width by 2 */
	background-color: #333; /* Black background color */
	color: white; /* White text color#fff */
	text-align: center; /* Centered text */
	border-radius: 2px; /* Rounded borders */
	padding: 10px; /* Padding */
	position: fixed; /* Sit on top of the screen */
	font-size: 18px;
	z-index: 1; /* Add a z-index if needed */
	left: 50%; /* Center the snackbar */
	bottom: 30px; /* 30px from the bottom */
	box-shadow: 0px 0px 100px #000
}

/* Show the snackbar when clicking on a button (class added with JavaScript) */
#toast.display {
	visibility: visible; /* Show the snackbar */
	/* Add animation: Take 0.5 seconds to fade in and out the snackbar.
  However, delay the fade out process for 2.5 seconds */
	animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}

@keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>
<body style="background-color: #f7f7f7">
<c:if test="${not empty addCart }"><div id="toast">${addCart}</div><script type="text/javascript">showToast();function showToast(content){$('#toast').addClass("display");$('#toast').html(content);setTimeout(()=>{$("#toast").removeClass("display");},2000)}</script><c:remove var="addCart" scope="session" /></c:if>
<%@include file="components/navbar.jsp"%>

	<%
	User u = (User) session.getAttribute("userobj");
	%>

	<div class="container-fluid">
		<div class="row p-3">
			<%
			MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
			List<MovieDtls> list = dao.getNewMovies();

			for (MovieDtls m : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center text-bold">
						<img alt="" src="movie/<%=m.getPhotoName()%>"
							style="width: 200px; height: 300px" class="img-thumbLin" />
						<p><%=m.getMovieName()%></p>
						<p><%=m.getDirector()%></p>
						<p><%=m.getGenre()%></p>
						<p><%=m.getYear()%></p>
						<p>
							Category:
							<%=m.getMovieCategory()%></p>
						<p>
							Price: <a href="" class="btn btn-danger btn-sm"><i
								class="fas fa-dollar-sign"></i> <%=m.getPrice()%></a>
						</p>

						<%
						if (u == null) {
						%>

						<p>
							<a href="login.jsp" class="btn btn-danger btn-sm"><i
								class="fas fa-cart-plus"></i> Add Cart</a> <a href=""
								class="btn btn-success btn-sm">View Details</a>
						</p>

						<%
						} else {
						%>

						<p>
						<% if (m.getStatus().equals("Active") && m.getQuantity() > 0) {%>
							<a href="cart?mid=<%=m.getMovieId()%>&&uid=<%=u.getId()%>&&pid=all_new_movies"
								class="btn btn-danger btn-sm"><i class="fas fa-cart-plus"></i>
								Add Cart</a> <%} %><a href="view_movies.jsp?mid=<%=m.getMovieId()%>" class="btn btn-success btn-sm">View
								Details</a>
						</p>
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