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


${message}<br/>

<table border="1">
<tr>
<th width="10%">#</th><th width="15%">German</th><th width="10%">English</th><th width="10%">actions</th>
</tr>
<c:forEach var="word" items="${wordList}" varStatus="theCount">
<tr>
	<td align="center">${theCount.count}</td>
	<td align="center">${word.word_de}</td>
	<td align="center">${word.word_eng}</td>
	<td align="center">
		<a href="${pageContext.request.contextPath}/edit/${word.id}.html">Edit</a><br/>
		<a href="${pageContext.request.contextPath}/delete/${word.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</table>

</body>
</html>
