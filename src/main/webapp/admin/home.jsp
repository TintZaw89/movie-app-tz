<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Login Page</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj}"> <c:redirect url="../login.jsp"/> </c:if>

	<div class="container">

		<div class="row p-5">

			<div class="col-md-3">
				<a href="add_movies.jsp">
					<div class="card">

						<div class="card-body text-center">

							<i class="fas fa-plus-square fa-3x text-primary"></i><br>

							<h4>Add Movies</h4>
							---------------

						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">

				<a href="all_movies.jsp">

					<div class="card">

						<div class="card-body text-center">

							<i class="fas fa-video fa-3x text-danger"></i><br>

							<h4>All Movies</h4>
							---------------

						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">

				<a href="orders.jsp">

					<div class="card">

						<div class="card-body text-center">

							<i class="fas fa-box-open fa-3x text-warning"></i><br>

							<h4>Orders</h4>
							---------------

						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">
			
			<a data-toggle="modal" data-target="#exampleModalCenter"  onclick="document.getElementById('exampleModalCenter').style.display='block'">

				<div class="card">

					<div class="card-body text-center">

						<i class="fas fa-sign-out-alt fa-3x text-primary"></i><br>

						<h4>Log Out</h4>
						---------------

					</div>
				</div>
			</a>
			</div>
			
		</div>
	</div>
<!-- logout modal -->

<!-- Modal -->

<div class="modal fade" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true" style="display: none;
  visibility: visible;
  opacity: 1;
  overflow: scroll;">

	<div class="modal-dialog modal-dialog-centered" role="document">

		<div class="modal-content">

			<div class="modal-header">

				<h5 class="modal-title" id="exampleModalLongTitle"></h5>

				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">

					<span aria-hidden="true">&times;</span>

				</button>

			</div>

			<div class="modal-body">


				<div class="text-center">

					<h4>Do you want to logout</h4>

					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

					<a href="../logout" type="button"
						class="btn btn-primary text-white">Logout</a>
				</div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>
<!-- end logout modal -->

	<div style="margin-top: 100px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>