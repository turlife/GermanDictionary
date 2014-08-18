<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<html>
<head>
	<title>Dictionary</title>
</head>
<body>
<h1>
	Dictionary  
</h1>

<a href="${pageContext.request.contextPath}/add.html"><spring:message code="add_word" /></a><br/>


${message}<br/>

<table border="1">
<tr>
<th width="10%">#</th><th width="10%"><spring:message code="article" /></th><th width="15%"><spring:message code="german" /></th><th width="10%"><spring:message code="english" /></th><th width="10%"><spring:message code="actions" /></th>
</tr>
<c:forEach var="word" items="${wordList}" varStatus="theCount">
<tr>
	<td align="center">${theCount.count}</td>
	<td align="center">${word.article}</td>
	<td align="center">${word.word_de}</td>
	<td align="center">${word.word_eng}</td>
	<td align="center">
		<a href="${pageContext.request.contextPath}/edit/${word.id}.html"><spring:message code="edit" /></a><br/>
		<a href="${pageContext.request.contextPath}/delete/${word.id}.html"><spring:message code="delete" /></a><br/>
	</td>
</tr>
</c:forEach>
</table>

</body>
</html>
