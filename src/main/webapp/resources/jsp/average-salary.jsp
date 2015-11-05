<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AverageSalary</title>
</head>
<body>
<h2>Средняя зарплата учреждения</h2>

<form action="/average_salary_result" method="get">
    <label>Название Медицинского учреждения</label><br/>
    <select name="name">
        <core:forEach var="string1" items="${medClinicNames}">
            <option>${string1}</option>
            <br>
        </core:forEach>
    </select><br/>
    <input type="submit">
</form>
<a href="/main">На главную</a>
</body>
</html>
