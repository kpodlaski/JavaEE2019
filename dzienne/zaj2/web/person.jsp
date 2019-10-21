<%@ page import="data.Person" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.10.2019
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="persons" class="data.PsedoDB" />
<jsp:useBean id="_id" class="data.ReqParameterId"> </jsp:useBean>
<jsp:setProperty name="_id" property="id" />

<html>
<head>
    <title>Strona Pracownika</title>
</head>
<body>
${_id.id}
${persons.getPersonById(_id.id).surname}
<br> To samo z scripletu:<br>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    out.println(id);
    Person p = persons.getPersonById(id);
    out.println("<br>"+p.getName());
%>

</body>
</html>
