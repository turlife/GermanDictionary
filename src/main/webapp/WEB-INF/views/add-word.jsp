<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add word page</title>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript">
	function doAjax() {
		$.ajax({
			url : 'fillFields',
			type : 'GET',
			data : ({
				word_de : $('#word_de').val()
			}),
			success : function(data) {
				if (data != null) {
					console.log(data);
					$("#word_eng").val(data.split("&")[1]);
					$("#word_article").val(data.split("&")[0]);
				}
			}
		});
	}
</script>


</head>
<body>
	<h1>Add word page</h1>
	<p>Here you can add word</p>

	<form:form method="POST" commandName="word"
		action="${pageContext.request.contextPath}/add.html">
		<table>
			<tbody>

				<tr>
					<th width="10%"><form:label path="article" /> <spring:message
							code="article" />:</th>
					<th width="15%"><form:label path="word_de" /> <spring:message
							code="german" />:</th>
					<th width="10%"><form:label path="word_eng" /> <spring:message
							code="english" />:</th>
				</tr>
				<tr>
					<td align="center"><form:input path="article" id="word_article" /></td>
					<td align="center"><form:input path="word_de" id="word_de" onkeyup="doAjax()"/></td>
					<td align="center"><form:input path="word_eng" id="word_eng" /></td>
				</tr>
				<tr>
					<td align="center"><form:errors path="article" /></td>
					<td align="center"><form:errors path="word_de" /></td>
					<td align="center"><form:errors path="word_eng" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="<spring:message code="add" />" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<p>
		<a href="${pageContext.request.contextPath}/main.html"><spring:message
				code="main_page" /></a>
	</p>
</body>
</html>