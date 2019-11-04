<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.10.2019
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="person" class="data.Person"></jsp:useBean>
<jsp:setProperty name="person" property="*" />
<jsp:useBean id="persons" class="data.PsedoDB" scope="application"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST">
    Imie:<input type="text" name="name" value="${person.name}"><br>
    Nazwisko:<input type="text" name="surname" value="${person.surname}"><br>
    Zdjęcie (Url): <input type="text" name="photo" value="${person.photo}"><br>
    <input type="submit" value="Send">
</form>
<%
    persons.getPersons().add(person);
%>
</body>
</html>
