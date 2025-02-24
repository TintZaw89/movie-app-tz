<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.UserDAOImpl"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<div class="container-fluid" style="height: 10px;background-color: #303f9f">
</div>
<div class="container-fluid p-3 bg-light">
<div class="row">
<div class="col-md-3 text-success">
<h3><i class="fas fa-film"></i> MyMovies</h3>
</div>
<div class="col-md-6">
<form class="form-inline my-2 my-lg-0" action="search_movies.jsp" method="post">
      <input class="form-control mr-sm-2" type="search" name="ch" placeholder="Search" aria-label="Search">
      <button class="btn btn-primary my-2 my-sm-0" type="submit" >Search</button>
    </form>
</div>

		<c:if test="${not empty userobj}">

			<div class="col-md-3">
				<a href="cart.jsp" class=""><i
					class="fas fa-cart-plus fa-2x"></i></a>

				<a href="" class="btn btn-success"><i
					class="fas fa-user-plus"></i> ${userobj.name}</a> <a href="logout"
					class="btn btn-primary text-white"><i
					class="fas fa-sign-in-alt"></i> Logout</a>
					<%
					User u = (User)session.getAttribute("userobj");
					UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
					int cash  = dao.checkCash(u.getId());
					%>
					<%if (cash>0) {%> 
					<a href="" class="btn" style="background-color: #e7e7e7;">Credit <i
					class="fas fa-dollar-sign"></i> <%=cash %></a> <%} else {%><a href="" class="btn" style="background-color: #f44336;">Credit <i
					class="fas fa-dollar-sign"></i> <%=cash %></a>  <% }%>
			</div>

		</c:if>

		<c:if test="${empty userobj }">

			<div class="col-md-3">

				<a href="login.jsp" class="btn btn-success"><i
					class="fas fa-sign-in-alt"></i> Login</a> <a href="register.jsp"
					class="btn btn-primary text-white"><i class="fas fa-user-plus"></i>

					Register</a>

			</div>

		</c:if>
		<div class="col-md-3">
<!-- <a href="login.jsp" class="btn btn-success"><i class="fas fa-sign-in-alt"></i> Login</a> <a href="register.jsp" class="btn btn-primary"><i class="fas fa-user-plus"></i> Register</a> -->
</div>
</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark text-white bg-custom">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  <a class="navbar-brand" href="#"> <i class="fas fa-home text-white"></i> </a>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp"> Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="all_recent_movies.jsp"><i class="fas fa-video"></i> Recent Movie</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="all_new_movies.jsp"><i class="fas fa-video"></i> New Movie</a>
      </li>
      
      <li class="nav-item active">
        <a class="nav-link" href="all_old_movies.jsp"><i class="fas fa-video"></i> Old Movie</a>
      </li>
      
      <li class="nav-item active">
        <a class="nav-link" href="my_movie.jsp"><i class="fas fa-video"></i> My Movie</a>
      </li>

    </ul>
    <form class="form-inline my-2 my-lg-0">
      <a href="setting.jsp" class="btn btn-light my-2 my-sm-0" type="submit"><i class="fas fa-cog"></i> Setting</a>
      <button class="btn btn-light my-2 my-sm-0 ml-1" type="submit"><i class="fas fa-phone-square-alt"></i> Contact Us</button>
    </form>
  </div>
</nav>