<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
<h1 class="text-bold text-center color-red">Error
</h1>
<c:if test="${not empty failedMsg }"><p class="text-center text-danger">${failedMsg }</p><c:remove var="failedMsg" scope="session" /></c:if>
</body>
</html>