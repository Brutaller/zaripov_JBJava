<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
</head>

<body>
<form method="post" action="/calc">
    <input type="text" name="number-1">
<select class="form-control" name="operation" id="select-val">
    <% String[] array = {"+", "-", "*", "/"};
        for (int i = 0; i < array.length; i++) {%>
    <option value="<%=i+1%>">
        <%=array[i]%>
    </option>
    <%}%>
</select>
    <input type="text" name="number-2">
    <input type="submit" name="submit" value="DO IT!">
</form>
<img src="do%20it.jpg">
<div class="message-window">
    <% if (session.getAttribute("error") != null || session.getAttribute("answer") != null) { %>
    <p>
        <%=((session.getAttribute("error") == null) ? ("Result: " + session.getAttribute("answer")) : "Error: " + session.getAttribute("error"))%>
        <% if (session.getAttribute("error") == null) {
            session.removeAttribute("answer");
        } else {
            session.removeAttribute("error");
        }%>
    </p>
    <% } %>
</div>
</body>
</html>