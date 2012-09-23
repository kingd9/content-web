<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
${message}
<sf:form method="POST" modelAttribute="searchRequest">
	<ul>
		<li><sf:label path="id">Id</sf:label> <sf:input path="id" /></li>
		<li><sf:label path="term">Content</sf:label> <sf:input
				path="term" /></li>
		<input type="submit" />
	</ul>
</sf:form>
