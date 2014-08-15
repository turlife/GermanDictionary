<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add word page</title>
<%-- <script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<link href="<c:url value="/resources/js/jquery-ui.css" />" rel="stylesheet">

<script>
	$(document).ready(function() {
		$('#de-search').autocomplete({
			serviceUrl : '${pageContext.request.contextPath}/getGerman',
			paramName : "word_de",
			delimiter : ",",
			transformResult : function(response) {
				return {
					//must convert json to javascript object before process
					suggestions : $.map($.parseJSON(response), function(item) {
						return {
							value : item.tagName,
							data : item.id
						};
					})

				};

			}

		});

	});
</script> --%>

</head>
<body>
	<h1>Add word page</h1>
	<p>Here you can add word</p>

	<form:form method="POST" commandName="word"
		action="${pageContext.request.contextPath}/add.html">
		<table>
			<tbody>
				<tr>
					<td><form:label path="article" />Article:</td>
					<td><form:input path="article" /></td>
					<td><form:errors path="article" /></td>
				</tr>
				<tr>
					<td><form:label path="word_de" />German:</td>
					<td><form:input path="word_de" id="de-search" /></td>
					<td><form:errors path="word_de" /></td>
				</tr>
				<tr>
					<td><form:label path="word_eng" />English:</td>
					<td><form:input path="word_eng" /></td>
					<td><form:errors path="word_eng" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<p>
		<a href="${pageContext.request.contextPath}/main.html">Main page</a>
	</p>
</body>
</html>