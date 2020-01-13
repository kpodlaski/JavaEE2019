<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.01.2020
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Odpowiedz testowa: <br/>
${data}
${data.hashCode()}
<table>
    <tr><td>Imie</td><td>${person.name}</td></tr>
    <tr><td>Nazwisko</td><td>${person.surname}</td></tr>
    <tr><td>Nr. buta</td><td>${person.shoeSize}</td></tr>
</table>
</body>
</html>
