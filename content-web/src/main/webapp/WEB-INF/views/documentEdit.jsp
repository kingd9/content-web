<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Document</h2>
<sf:form method="POST" action="../document" modelAttribute="documentModel.document" >
${saved}
<sf:input path="id"/>
<sf:input path="content"/>
<sf:select path="tag" items="${availableTags}"/>
<input type="submit" />
</sf:form>

