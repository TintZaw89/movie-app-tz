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
    <meta charset="UTF-8" />
    <title>Movie: Index</title>
    <%@include file="components/allCss.jsp" %>
    <style type="text/css">
      .back-img {
        background: url("img/3000.avif");
        height: 50vh;
        width: 100%;
        background-size: cover;
        background-repeat: no-repeat;
      }
      .crd-ho: hover {
      background-color: #fcf7f7;
      }
    </style>
  </head>
  <body style="background-color: #f7f7f7">
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
<c:if test="${not empty addCart}"><div class="alert alert-success" role="alert"> ${addCart }</div><c:remove var="addCart" scope="session" /></c:if>
<c:if test="${not empty failedMsg}"><div class="alert alert-danger" role="alert">${failedMsg }</div><c:remove var="failedMsg" scope="session" /></c:if>
    <%@include file="components/navbar.jsp" %>
    
    <%User u = (User)session.getAttribute("userobj"); %>
    <div class="container-fluid back-img">
      <h1 class="text-center text-danger">Movie Management System</h1>
    </div>
    <!-- Start Recent Book -->
	<div class="container">
		<h3 class="text-center">Recent Movie</h3>

		<div class="row">
			<%
			MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
			List<MovieDtls> list = dao.getRecentMovies();
            int i = 0;
			for (MovieDtls m : list){
			    if (i > 3)
			    {
			    	break;
			    }
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="movie/<%=m.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumbLin" />
						<p><%=m.getMovieName()%></p>
						<p><%=m.getDirector()%></p>
						<p>Category:<%=m.getMovieCategory()%></p>
						<p>
							Price: <a href="" class="btn btn-danger btn-sm"><i
								class="fas fa-dollar-sign"></i> <%=m.getPrice()%></a></p>

						<% if (m.getStatus().equals("Active") && m.getQuantity() > 0) {%>
						<div class="row ml-1">
						<%

if (u == null) {

%>

<a href="login.jsp" class="btn btn-danger btn-sm ml-3"><i
								class="fas fa-cart-plus"></i> Add Cart</a>

<%

} else {

%>

<a href="cart?mid=<%=m.getMovieId()%>&&uid=<%=u.getId()%>&&pid=index" class="btn btn-danger btn-sm mL-3"><i
								class="fas fa-cart-plus"></i> Add Cart</a>

<%

}

%>
							<a href="view_movies.jsp?mid=<%=m.getMovieId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a>
						</div>
						<% } else {%>
						<div class="row ml-3">
								<a href="view_movies.jsp?mid=<%=m.getMovieId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
			<%
			i++;
            }
			%>

		</div>
		<div class="text-center mt-1">
			<a href="all_recent_movies.jsp" class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>
	<!-- End Recent Book -->
    
    <hr>
    
    <!-- Start New Book -->
    <div class="container" >
      <h3 class="text-center">New Movie</h3>

      <div class="row">

			<%
			MovieDAOImpl dao2 = new MovieDAOImpl(DBConnect.getConn());
			List<MovieDtls> list2 = dao2.getNewMovies();
			int j = 0;
			for (MovieDtls m2 : list2) {
				 if (j > 3)
				    {
				    	break;
				    }
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="movie/<%=m2.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumbLin" />
						<p><%=m2.getMovieName()%></p>
						<p><%=m2.getDirector()%></p>
						<p>Category:<%=m2.getMovieCategory()%></p>
						<p>
							Price: <a href="" class="btn btn-danger btn-sm"><i
								class="fas fa-dollar-sign"></i> <%=m2.getPrice()%></a></p>
						<% if (m2.getQuantity() > 0) {%>
						<div class="row ml-1">
						<%

if (u == null) {

%>

<a href="login.jsp" class="btn btn-danger btn-sm ml-3"><i
								class="fas fa-cart-plus"></i> Add Cart</a>

<%

} else {

%>

<a href="cart?mid=<%=m2.getMovieId()%>&&uid=<%=u.getId()%>&&pid=index" class="btn btn-danger btn-sm mL-3"><i
								class="fas fa-cart-plus"></i> Add Cart</a>

<%

}

%>
							<a href="view_movies.jsp?mid=<%=m2.getMovieId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a>
						</div>
						<% } else {%>
						<div class="row ml-3">
								<a href="view_movies.jsp?mid=<%=m2.getMovieId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>

			<%
			j++;
			}
			%>

		</div>
      <div class="text-center mt-1">
      	<a href="all_new_movies.jsp" class="btn btn-danger btn-sm text-white">View All</a>
      </div>
    </div>
    <!-- End New Book -->
    
     <hr>
    
    <!-- Start Old Book -->
    <div class="container" >
      <h3 class="text-center">Old Movie</h3>

      <div class="row">
        <%
			MovieDAOImpl dao3 = new MovieDAOImpl(DBConnect.getConn());
			List<MovieDtls> list3 = dao3.getOldMovies();
   			int k = 0;
			for (MovieDtls m3 : list3) {
				 if (k > 3)
				    {
				    	break;
				    }
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="movie/<%=m3.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumbLin" />
						<p><%=m3.getMovieName()%></p>
						<p><%=m3.getDirector()%></p>
						<p>Category:<%=m3.getMovieCategory()%></p>
						<p>
							Price: <a href="" class="btn btn-danger btn-sm"><i
								class="fas fa-dollar-sign"></i> <%=m3.getPrice()%></a></p>
						<div class="row ml-3">
							 <a
								href="view_movies.jsp?mid=<%=m3.getMovieId()%>" class="btn btn-success btn-sm ml-5">View Details</a>
						</div>
					</div>
				</div>
			</div>

			<%
			k++;
			}
			%>
        
      </div>
      <div class="text-center mt-1">
      	<a href="all_old_movies.jsp" class="btn btn-danger btn-sm text-white">View All</a>
      </div>
    </div>
    <!-- End Old Book -->
    <%@include file="components/footer.jsp" %>
  </body>
</html>
