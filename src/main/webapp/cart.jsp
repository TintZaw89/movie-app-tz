<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.CartDAOImpl"%>
<%@page import="com.entity.Cart"%>
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
<title>Card Detail</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="components/navbar.jsp"%>
<c:if test="${empty userobj}"><c:redirect url="login.jsp"></c:redirect> </c:if>
<c:if test="${not empty succMsg}"><div class="alert alert-success" role="alert"> ${succMsg }</div><c:remove var="succMsg" scope="session" /></c:if>
<c:if test="${not empty failedMsg}"><div class="alert alert-danger" role="alert">${failedMsg }</div><c:remove var="failedMsg" scope="session" /></c:if>

	<div class="container p-3">

		<div class="row p-2">

			<div class="col-md-6 text-center border bg-white">
				<div class="card" style="width: 100%;">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table table-striped table-dark">
							<thead>
								<tr>
									<th scope="col">Movie Name</th>
									<th scope="col">Director</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								User u = (User) session.getAttribute("userobj");

								CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());

								List<Cart> carts = dao.getMovieById(u.getId());
								
								//String webRootPath = getServletContext().getRealPath("/").replace('\\', '/');
								
								Double totalPrice = 0.00;

								for (Cart c : carts) {
									totalPrice=c.getTotalPrice();
								%>

								<tr>

									<th scope="row"><%=c.getMovieName()%></th>

									<td><%=c.getDirector()%></td>

									<td><%=c.getPrice()%></td>

									<td><a href="remove_card?cid=<%=c.getCartId() %>" class="btn btn-sm btn-danger">Remove</a></td>

								</tr>

								<%

								}

								%>
								
								<tr>
								<td>Total Price </td>
								<td> </td>
								<td> </td>
								<td><%=totalPrice %> </td>
								</tr>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6 text-center p-5 border bg-white">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details for Order</h3>
						<form action="order" method="post">
						<input type="hidden" value="${userobj.id}" name="id">
						<input type="hidden" value="${userobj.cash}" name="cash">
						<input type="hidden" value=<%=totalPrice %> name="totalprice">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										class="form-control" id="inputEmail4" name="username" value="<%=u.getName() %>" readonly="readonly" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email"
										class="form-control" id="inputEmail4" name="email" value="<%=u.getEmail() %>" readonly="readonly" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input
										type="number" class="form-control" name="phno" id="inputEmail4"  value="<%=u.getPhno()%>" 
										readonly="readonly" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input type="text"
										class="form-control" id="inputPassword4" name="address" value="<%=u.getAddress()%>" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text"
										class="form-control" id="inputEmail4" name="landmark" value="<%=u.getLandmark()%>" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input type="text"
										class="form-control" id="inputPassword4" name="city" value="<%=u.getCity()%>" required>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text"
										class="form-control" id="inputEmail4" name="state" value="<%=u.getState()%>" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Pin Code</label> <input type="text"
										class="form-control" id="inputPassword4" name="pincode" value="<%=u.getPincode()%>" required>
								</div>
							</div>

							<div class="form-group">

								<label>Payment Mode</label> <select class="form-control" name="payment">

									<option value="noselect">--Select--</option>

									<option value="COD">Cash On Delivery</option>

								</select>

							</div>

							<div class="text-center">

								<button class="btn btn-warning ml-5">Order Now</button>

								<a href="index.jsp" class="btn btn-success">Continue
									Shopping</a>

							</div>
						</form>

					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>