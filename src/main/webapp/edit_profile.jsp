<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
	<%@include file="components/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary p-1">Edit Profile</h4>
<c:if test="${not empty failedMsg }"><p class="text-center text-danger">${failedMsg }</p><c:remove var="failedMsg" scope="session" /></c:if>
<c:if test="${not empty succMsg }"><p class="text-center text-success">${succMsg }</p><c:remove var="succMsg" scope="session" /></c:if>

						<form action="update_profile" method="post">
							<input type="hidden" value="${userobj.id}" name="id">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Your Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname" value="${userobj.name}">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email" value="${userobj.email}"> 
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Phone Number</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phno" value="${userobj.phno}">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password" value="${userobj.password}">
							</div>
							<button type="submit" class="btn btn-primary">Edit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="components/footer.jsp"%>
</body>
</html>