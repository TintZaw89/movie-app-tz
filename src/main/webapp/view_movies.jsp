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
<title>Insert title here</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7">
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
<c:if test="${not empty addCart}"><div class="alert alert-success" role="alert"> ${addCart }</div><c:remove var="addCart" scope="session" /></c:if>
<c:if test="${not empty failedMsg}"><div class="alert alert-danger" role="alert">${failedMsg }</div><c:remove var="failedMsg" scope="session" /></c:if>

	<%@include file="components/navbar.jsp"%>
<%User u = (User)session.getAttribute("userobj"); %>
	<%
int mid=Integer.parseInt(request.getParameter("mid"));

MovieDAOImpl dao=new MovieDAOImpl(DBConnect.getConn());

MovieDtls m=dao.getMovieById(mid);

%>

	<div class="container p-3">

		<div class="row">

			<div class="col-md-6 text-center p-5 border bg-white">

				<img src="movie/<%=m.getPhotoName() %>"
					style="height: 150px; width: 100px"><br>

				<h4 class="mt-3">

					Movie Name: <span class="text-success"><%=m.getMovieName() %></span>

				</h4>

				<h4>

					Director Name: <span class="text-success"><%=m.getDirector() %></span>

				</h4>

				<h4>

					Category: <span class="text-success"> <%=m.getMovieCategory() %></span>

				</h4>
				
				<h4>

					Genre: <span class="text-success"> <%=m.getGenre() %></span>

				</h4>
				
				<h4>

					Released Year: <span class="text-success"> <%=m.getYear() %></span>

				</h4>

			</div>

			<div class="col-md-6 text-center p-5 border bg-white">

				<h2><%=m.getMovieName() %></h2>
				<%
				if ("Old".equals(m.getMovieCategory())) { %>

				<h5 class="text-primary">Contact To Seller</h5>

				<h5 class="text-primary">

					<i class="far fa-envelope"></i> EMail:

					<%=m.getEmail()%></h5>

				<%
				}
				%>


				<div class="row">

					<div class="col-md-4 text-danger text-center p-2">

						<i class="fas fa-money-bill-wave fa-2x"></i>

						<p>Cash On Delivery</p>

					</div>

					<div class="col-md-4 text-danger text-center p-2">
						<i class="fas fa-undo-alt fa-2x"></i>
						<p>Return Available</p>

					</div>

					<div class="col-md-4 text-danger text-center p-2">

						<i class="fas fa-truck-moving fa-2x"></i>

						<p>Free Shipping</p>

					</div>

				</div>
				<%

if ("Old".equals(m.getMovieCategory())  || m.getQuantity() == 0) {

%>

				<div class=" text-center p-3">

					<a href="index.jsp" class="btn btn-success"><i
						class="fas fa-cart-plus"></i> Continue Shopping</a> <a href=""
						class="btn btn-danger"><i class="fas fa-rupee-sign"></i>200</a>

				</div>

				<%

} else {

%>

				<div class=" text-center p-3">

					<a href="cart?mid=<%=m.getMovieId()%>&&uid=<%=u.getId()%>&&pid=cart" class="btn btn-primary"><i class="fas fa-cart-plus"></i>

						Add Cart</a> <a href="" class="btn btn-danger"><i
						class="fas fa-rupee-sign"></i>200</a>

				</div>

				<%

}

%>
			</div>
		</div>
	</div>



</body>
</html>