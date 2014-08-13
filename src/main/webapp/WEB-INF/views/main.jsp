<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Dictionary</title>
</head>
<body>
<h1>
	Dictionary  
</h1>

<a href="${pageContext.request.contextPath}/add.html">Add word</a><br/>

<table>
<c:forEach var="word" items="${wordList}">
<tr>
	<td>${word.id}</td>
	<td>${word.word_de}</td>
	<td>${word.word_eng}</td>
</tr>
</c:forEach>
</table>

</body>
</html>
