<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/js/jquery.min.js" var="jqueryJS"></spring:url>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS"></spring:url>
<meta charset="utf-8">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
<script type="text/javascript" src="${jqueryJS}"></script>
<link href="${bootstrapCSS}" rel="stylesheet" />
<script type="text/javascript" src="${bootstrapJS}"></script>
</head>
<body>
	<div style="width: 100%">

		<tiles:insertAttribute name="header" ignore="false"></tiles:insertAttribute>

	</div>
	<div style="width: 100%; margin: 2%;">
		<tiles:insertAttribute name="body" ignore="false"></tiles:insertAttribute>
	</div>

	<div style="width: 100%">

		<tiles:insertAttribute name="footer" ignore="false"></tiles:insertAttribute>

	</div>

</body>
</html>