<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<h3>Reading Data</h3>
	${sid},${sfee},${sname}
	<hr>
	<!-- Object Data Reading -->
	${Emp1}
	<hr>
	${Emp2.empId}-${Emp2.empName}-${Emp2.sal}
	<hr/>
	<!-- Collection data (List)-->
	${list}<br>
	<c:forEach var="ob" items="${list}">
		${ob}<br>
	</c:forEach>
	<!-- Collection data(Map) -->
	${map}<br>
	<c:forEach items="${map}" var="ob">
		${ob.key}-${ob.value}<br>
	</c:forEach>
</body>
</html>