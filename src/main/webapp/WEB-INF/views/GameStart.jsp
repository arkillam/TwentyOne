<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ark"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/TwentyOne.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
<title>${go.title}</title>

<script>
	$(function() {
		// my ".ready()" code (I miss the earlier jQuery's explicit .ready() style ...)
		// console.log("DOM is loaded and ready for us to begin work.");
	});
</script>

</head>

<body>
	<p class="pageheader">${go.title}</p>
	
	<ark:ErrorMessagesTag errorMessages="${go.errorMessages}" />

	<c:if test="${not empty go.message}">
		<p>${go.message}</p>
	</c:if>

	<form method="post" action="/TwentyOne/Game/Play">
		<table>
			<tr>
				<td><b>Name</b></td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td><b>Dollars</b></td>
				<td><input name="money" type="number" value="10"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Let's play!"></td>
			</tr>
		</table>
	</form>

</body>

</html>
