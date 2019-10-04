<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEEs</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<base href="/springboot-pagination/" />
<script>
				var addPhones = (phones) => {
					console.log(phones);
					var table = document.getElementById("mytab1");
					for(let i = 0; i< table.rows.length; i++) {
						if(i === 0) {
							let cls = table.rows[i].cells;
							var x = table.rows[i].insertCell(cls.length);
							x.innerHTML = "<b>PHONES</b>";
						} else {
							let cls = table.rows[i].cells;
							var x = table.rows[i].insertCell(cls.length);
							x.innerHTML = phones(i-1);
						}
					}
				};
			</script>
</head>
<body>
	<div class="container" style="margin-top: 20px;">
		<h1 style="text-align: center;">Employee List</h1>
		<table class="table table-bordered" id="mytab1">
			<tr>
				<th width="20px">ID</th>
				<th>EMPNO</th>
				<th>NAME</th>
				<th>EMAIL</th>
			</tr>
			<c:forEach var="employee" items="${page.content }">
				<tr>
					<td>${employee.id }</td>
					<td>${employee.empno}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			TotalPages: ${page.totalPages }<br /> PageNumber: ${page.number} <br />
			isFirst: ${isFirst} <br /> isLast: ${isLast} <br /> hasNext:
			${hasNext }<br /> hasPrevious: ${hasPrevious}<br />

			<c:set var="pageNumbers" value="2" />
			<%-- offset: <c:out value="${page.offset}"/><br /> --%>
			<ul class="pagination">
				<c:if test="${page.number != 0}">
					<li><a
						href="employee/page?page=${page.number -1}&size=${pageSize}&sort=id,asc&sort=name,desc">
							<< </a></li>
				</c:if>
				<c:forEach begin="0" var="i" end="${pageNumbers - 1 }">
					<c:choose>
						<c:when test="${page.number == i + page.number}">
							<li class="active"><a
								href="employee/page?page=${page.number + i}&size=${pageSize}&sort=id,asc&sort=name,desc">${page.number + i+1}</a></li>
						</c:when>
						<c:when test="${not isLast}">
							<li><a
								href="employee/page?page=${page.number + i}&size=${pageSize}&sort=id,asc&sort=name,desc">${page.number + i+1}</a></li>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${page.number < page.totalPages - 1 }">
					<li><a
						href="employee/page?page=${page.number + 1}&size=${pageSize}&sort=id,asc&sort=name,desc">>></a></li>
				</c:if>
			</ul>
		</div>
		<script>
			addPhones(${phones});
		</script>
	</div>
</body>
</html>