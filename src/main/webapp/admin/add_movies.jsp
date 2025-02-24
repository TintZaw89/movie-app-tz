<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movies</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container-fluid">

		<div class="row mt-2">

			<div class="col-md-4 offset-md-4">

				<div class="card">

					<div class="card-body">

						<div class="text-center">

							<h5 class="text-primary">Add Movie</h5>

						</div>

						<c:if test="${not empty failedMsg }">
							<p class="text-center text-danger">${failedMsg }</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="../add_movies" method="post"
							enctype="multipart/form-data">

							<div class="form-group">

								<label for="exampleInputEmail1">Movie Name*</label> <input
									name="mname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>

							<div class="form-group">

								<label for="exampleInputEmail1">Director Name*</label><input
									name="author" type="text" class="form-control"
									id="exampleInputEmaill" aria-describedby="emailHelp">

							</div>

							<div class="form-group">

								<label for="exampleInputPassword1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1">

							</div>
							<div class="form-group">

								<label for="inputState">Movie Categories</label> <select
									id="inputState" name="categories" class="form-control">

									<option selected>--select--</option>

									<option value="New">New Movie</option>

									<option value="Old">Old Movie</option>

								</select>

							</div>

							<div class="form-group">

								<label for="inputState">Movie Status</label> <select
									id="inputState" name="status" class="form-control">

									<option selected>--select--</option>

									<option value="Active">Active</option>

									<option value="Inactive">Inactive</option>

								</select>

							</div>
			
							<div class="form-group">

								<div class="control control-expanded">
									<select id="myList" name="genre" onchange="ChooseGenre()"
										style="float: left; width: 50%">
										<option>---Genre---</option>
										<option>Adventure</option>
										<option>Comedy</option>
										<option>Sci-Fi</option>
										<option>War</option>
										<option>Drama</option>
										<option>Historical</option>
										<option>Fantasy</option>
										<option>Superhero</option>
										<option>Action</option>
										<option>Thriller</option>
										<option>Horror</option>
										<option>Mystery</option>
										<option>Romance</option>
										<option>Family</option>
										<option>Adult</option>
									</select> <select id="datedropdown" name="year"
										style="float: left; width: 50%">
									</select>

								</div>

							</div>
							<br/>
							<div class="form-group">
								<br/>
								<label for="exampleInputPassword1">Video</label> <input
									name="video" type="text" class="form-control"
									id="exampleInputPassword1">

							</div>
							
							<div class="form-group">
								<br/>
								<label for="exampleInputPassword1">Quantity</label> <input
									name="quantity" type="number" class="form-control"
									id="exampleInputPassword1">

							</div>

							<div class="form-group">

								<label for="exampleFormControlFile1">Upload Photo</label> <input
									name="mimg" type="file" class="form-control-file"
									id="exampleFormControlFile1" required>

							</div>

							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		let dateDropdown = document.getElementById('datedropdown');

		let currentYear = new Date().getFullYear();
		let earliestYear = currentYear - 99;
		while (currentYear >= earliestYear) {
			let dateOption = document.createElement('option');
			dateOption.text = currentYear;
			dateOption.value = currentYear;
			dateDropdown.add(dateOption);
			currentYear -= 1;
		}
		function ChooseGenre() {
			var mylist = document.getElementById("myList");
			//document.getElementById("favourite").value = mylist.options[mylist.selectedIndex].text;  
		}
	</script>
	<div style="margin-top: 120px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>