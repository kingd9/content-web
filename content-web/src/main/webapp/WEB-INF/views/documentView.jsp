<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="documentView">
	<div>Id: ${document.id}</div>
	<div>content: ${document.content}</div>
	<div>Labels
	<c:forEach items="${document.tags}" var="tag">
		<div>name: ${tag.name}</div>
	</c:forEach>
	</div>
</div>
