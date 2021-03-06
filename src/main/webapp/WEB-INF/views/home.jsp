<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Watson - Personality Insights</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<legend class="header">Personality Insights</legend>
	 
	<form action="home" method="POST">
		<p class="panel">
			<textarea name="params" rows="5" cols="100"><c:if test="${!empty text}">${text}</c:if></textarea>
		</p>
		<p class="action">
			<input type="submit" value="Analyze">
		</p>
	</form>
	
	<c:if test="${!empty profile}">
		<h3>Result: </h3>
		<p class="result">${profile}</p>
	</c:if>
		
</body>
</html>