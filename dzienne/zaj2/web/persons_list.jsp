<%@ page import="data.Person" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.10.2019
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="persons" class="data.PsedoDB" />

<html>
<head>
    <title>Lista osób</title>
</head>
<body>
Lista osób<br/>
<%
    for(int id = 0; id<persons.size(); id++){
        Person p = persons.getPersonById(id);
        out.println("<a href='person.jsp?id="+id+"'>");
        out.println(p.getName()+ " "+p.getSurname());
        out.println("</a><br/>");
    }
%>

<jstl:forEach items="${persons.getPersons()}" var="person" varStatus="it">
    <a href="person.jsp?id=${it.index}"> ${person.name} ${person.surname}</a>
</jstl:forEach>
</body>
</html>
