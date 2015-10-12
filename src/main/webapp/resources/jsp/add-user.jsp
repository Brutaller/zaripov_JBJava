<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 10.10.2015
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Добавление нового пользователя</h1>
<sf:form action = "/users/add_user" method="post" modelAttribute="user">
  <sf:label path="name1">Имя: </sf:label><sf:input path="name1"/> <sf:errors path="name1"/> <br>
  <sf:label path="name2">Фамилия: </sf:label><sf:input path="name2"/> <sf:errors path="name2"/> <br>
  <sf:label path="name3">Отчество: </sf:label><sf:input path="name3"/> <sf:errors path="name3"/> <br>
  <sf:label path="birthDay">ДР: </sf:label><sf:input path="birthDay"/><br>
  <sf:label path="gender">Пол: </sf:label><sf:input path="gender"/><br>
  <button type="submit">Добавить</button>
</sf:form>
</body>
</html>
