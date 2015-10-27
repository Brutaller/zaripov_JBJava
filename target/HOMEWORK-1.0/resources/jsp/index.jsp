<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.10.2015
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Students</title>
  </head>
  <body>
  <form action="/sum" method="post">
    <input type="text" name="firstname" placeholder="firstname">
    <input type="text" name="surname" placeholder="surname">
    <input type="text" name="lastname" placeholder="lastname">
    <input type="submit">
  </form>
  <form action="/avg" method="post">
    <input type="text" name="firstname" placeholder="firstname">
    <input type="text" name="surname" placeholder="surname">
    <input type="text" name="lastname" placeholder="lastname">
    <input type="submit">
  </form><br>
  <form action="/subj" method="post">
    <input type="text" name="firstname" placeholder="firstname">
    <input type="text" name="surname" placeholder="surname">
    <input type="text" name="lastname" placeholder="lastname">
    <select name="subject"><br>
      <option selected value=0>MATH</option>
      <option selected value=1>ENGLISH</option>
      <option selected value=2>SCINCE</option>
      <option selected value=3>PI</option>
      <option selected value=4>INFORMATIC</option>
    </select>
    <input type="submit">
  </form>
  </body>
</html>
