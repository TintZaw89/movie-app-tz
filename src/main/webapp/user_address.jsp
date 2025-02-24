<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
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
<title>Edit Address</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
<c:if test="${not empty failedMsg }"><p class="text-center text-danger">${failedMsg }</p><c:remove var="failedMsg" scope="session" /></c:if>
<c:if test="${not empty succMsg }"><p class="text-center text-success">${succMsg }</p><c:remove var="succMsg" scope="session" /></c:if>
	<%@include file="components/navbar.jsp"%>
	<div class="container">
		<div class="row p-3">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-success p-1">Add Address</h3>
					<form action="update_address" method="post">
					<%
						User u = (User) session.getAttribute("userobj");
					%>
					<input type="hidden" value="${userobj.id}" name="id">
					<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input type="text"
										class="form-control" id="inputPassword4" name="address" value="<%=u.getAddress()%>">
								</div>
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text"
										class="form-control" id="inputEmail4" name="landmark" value="<%=u.getLandmark()%>">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">City</label> <input type="text"
										class="form-control" id="inputEmail4" name="city" value="<%=u.getCity()%>">
								</div>
								<div class="form-group col-md-3">
									<label for="inputPassword4">State</label> <input type="text"
										class="form-control" id="inputPassword4" name="state" value="<%=u.getState()%>">
								</div>
								<div class="form-group col-md-3">
									<label for="inputPassword4">Zip</label> <input type="text"
										class="form-control" id="inputPassword4" name ="pincode" value="<%=u.getPincode()%>">
								</div>
							</div>
							
							<div class="text-center">
								<Button class="btn btn-warning text-white">Edit</Button>
							</div>
					
					</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="components/footer.jsp"%>
</body>
</html>