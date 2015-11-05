<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>${fio}</h2>
зарплата ${salaryOfCurrentEmployee}
<p><c:if test="${dismissalDate == null}">работает</c:if><c:if test="${dismissalDate != null}">работал</c:if>
    с ${employmentDate} по <c:if test="${dismissalDate == null}">нынешнее время</c:if><c:if
            test="${dismissalDate != null}">${dismissalDate}</c:if></p>

<br/>
<a href="/main">На главную</a>
</body>
</html>
