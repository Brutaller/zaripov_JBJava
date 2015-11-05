<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${averageSalary}<br/><br/>

<h1>Зарплата работника этой медклиники</h1>

<form action="/average_salary/employee_salary" , method="get">
    <input type="text" name="name" value=${medClinic.name} readonly>
    <select name="fio">
        <core:forEach var="string" items="${stuffList}">
            <option>${string} </option>
            <br>
        </core:forEach>
    </select><br/>
    <input type="submit">
</form>
<a href="/main">На главную</a>
</body>
</html>
