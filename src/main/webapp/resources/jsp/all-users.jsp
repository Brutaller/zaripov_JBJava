<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 10.10.2015
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Список пользователей</h1>

<c:forEach var="user" items="${users}">
  ${user.name1}
  ${user.name2}
  ${user.name3}
  <c:if test="${!user.birthDay.isEmpty()||user.birthDay!=null}"/><c:out value="${user.birthDay}"/>
  <c:if test="${!user.gender.isEmpty()||user.gender!=null}"/><c:out value="${user.gender}"/> <br>
</c:forEach>
</body>
</html>