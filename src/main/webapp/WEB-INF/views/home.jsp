<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/TwentyOne.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
<title>Home</title>

<script>
	$(function() {
		// my ".ready()" code (I miss the earlier jQuery's explicit .ready() style ...)
		console.log("DOM is loaded and ready for us to begin work.");
	});
</script>

</head>

<body>
	<p class="pageheader">Hello World!</p>
	<p>This is the homepage!</p>
</body>

</html>
