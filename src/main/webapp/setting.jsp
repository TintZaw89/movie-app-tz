<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Setting</title>
<%@include file="components/allCss.jsp"%>

<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a: hover {
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #f7f7f7">
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
	<%@include file="components/navbar.jsp"%>
	<div class="container">

<c:if test="${not empty userobj}">
		<h3 class="text-center">Hello, ${userobj.name}</h3>
</c:if>

		<div class="row p-5">

			<div class="col-md-4 mt-3">

				<a href="sell_movie.jsp">

					<div class="card">

						<div class="card-body text-center">

							<div class="text-primary">

								<i class="fas fa-video fa-3x"></i>

							</div>

							<h4>Sell Old Movie</h4>

						</div>
					</div>

				</a>

			</div>
			
			<div class="col-md-4 mt-3">

				<a href="old_movie.jsp">

					<div class="card">

						<div class="card-body text-center">

							<div class="text-primary">

								<i class="fas fa-video fa-3x"></i>

							</div>

							<h4>Old Movie</h4>

						</div>
					</div>

				</a>

			</div>

			<div class="col-md-4 mt-3">

				<a href="edit_profile.jsp">

					<div class="card">

						<div class="card-body text-center">

							<div class="text-primary">

								<i class="fas fa-edit fa-3x"></i>

							</div>

							<h4>Login & Security (Edit Profile)</h4>

						</div>

					</div>

				</a>

			</div>

			<div class="col-md-4 mt-3">

				<a href="user_address.jsp">

					<div class="card">

						<div class="card-body text-center">

							<div class="text-warning">

								<i class="fas fa-map-marker-alt fa-3x"></i>

							</div>

							<h4>Your Address</h4>
							<p>Edit Address</p>

						</div>

					</div>

				</a>

			</div>

			<div class="col-md-4 mt-3">

				<a href="order.jsp">

					<div class="card">

						<div class="card-body text-center">

							<div class="text-danger">

								<i class="fas fa-box-open fa-3x"></i>

							</div>

							<h4>My Order</h4>
							<p>Track Your Order</p>

						</div>

					</div>

				</a>

			</div>

			<div class="col-md-4 mt-3">

				<a href="helpline.jsp">

					<div class="card">

						<div class="card-body text-center">

							<div class="text-primary">

								<i class="fas fa-user-circle fa-3x"></i>

							</div>

							<h4>Help Center</h4>
							<p>24/7 Service</p>

						</div>

					</div>

				</a>

			</div>

		</div>
	</div>
	<%@include file="components/footer.jsp"%>
</body>
</html>