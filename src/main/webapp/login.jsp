<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie: Login</title>
<%@include file="components/allCss.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="components/navbar.jsp" %>
<div class="container p-2">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-body">
<h3 class="text-center">Login</h3>

<c:if test="${not empty failedMsg }"><p class="text-center text-danger">${failedMsg }</p><c:remove var="failedMsg" scope="session" /></c:if>
<c:if test="${not empty succMsg }"><p class="text-center text-success">${succMsg }</p><c:remove var="succMsg" scope="session" /></c:if>
<form action="login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required" name="email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" required="required" name="password">
  </div>
  <div class="text-center">
  <button type="submit" class="btn btn-primary">Login</button><br>
  <a href="register.jsp">Create Account</a>
  </div>
  
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="checkbss" name="check">
    <label class="form-check-label" for="exampleCheck1">Is BSS User?</label>
  </div>
  
</form>
</div>
</div>
</div>
</div>
</div>
<%@include file="components/footer.jsp" %>
</body>
</html>