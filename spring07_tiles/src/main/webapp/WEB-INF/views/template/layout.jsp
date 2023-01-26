<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<style>
<style>
* {
	margin: 0px;
}

header {
	width: 100%;
	height: 100px;
	background-color: aqua;
}

nav {
	height: 670px;
	background-color: teal;
	width: 15%;
	float: left;
}

section {
	background-color: skyblue;
	width: 80%;
	height: 670px;
	float: right;
}

footer {
	background-color: #ffffff;
	clear: both;
}
</style>


</style>
</head>
<body>

<header>
	<tiles:insertAttribute name="header" />
</header>

<nav>
	<tiles:insertAttribute name="menu" />
</nav>

<section>
	<tiles:insertAttribute name="body" />
</section>

<footer>
	<tiles:insertAttribute name="footer" />
</footer>
</body>
</html>