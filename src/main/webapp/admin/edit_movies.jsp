<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.MovieDAOImpl"%>
<%@page import="com.entity.MovieDtls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Edit Movies</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>
	<div class="container-fluid">

		<div class="row mt-2">

			<div class="col-md-4 offset-md-4">

				<div class="card">

					<div class="card-body">

						<div class="text-center">

							<h5 class="text-primary">Edit Movie</h5>

						</div>
						<c:if test="${not empty failedMsg }"><p class="text-center text-danger">${failedMsg }</p><c:remove var="failedMsg" scope="session" /></c:if>
						
						<%

						int id = Integer.parseInt(request.getParameter("id"));

						MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());

						MovieDtls m = dao.getMovieById(id);

						%>

						<form action="../edit_movies" method="post">
							<input type="hidden" name="id" value="<%=m.getMovieId()%>">

							<div class="form-group">

								<label for="exampleInputEmail1">Movie Name*</label> <input
									name="mname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" value="<%=m.getMovieName() %>">

							</div>

							<div class="form-group">

								<label for="exampleInputEmail1">Director Name*</label><input
									name="author" type="text" class="form-control"
									id="exampleInputEmaill" aria-describedby="emailHelp" value="<%=m.getEmail()%>">

							</div>

							<div class="form-group">

								<label for="exampleInputPassword1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1" value="<%=m.getPrice()%>">

							</div>
							
							<div class="form-group">

								<label for="exampleInputPassword1">Quantity*</label> <input
									name="quantity" type="number" class="form-control"
									id="exampleInputPassword1" value="<%=m.getQuantity()%>">

							</div>

							<div class="form-group">

								<label for="inputState">Movie Status</label> <select
									id="inputState" name="status" class="form-control">

									<%
									if ("Active".equals(m.getStatus())) {
									%>

									<option value="Active">Active</option>

									<option value="Inactive">Inactive</option>

									<%
									} else {
									%>

									<option value="Inactive">Inactive</option>

									<option value="Active">Active</option>

									<%
									}
									%>

								</select>

							</div>

							<button type="submit" class="btn btn-primary">Edit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 120px;">
	<%@include file="footer.jsp" %>
	</div>
</body>
</html>