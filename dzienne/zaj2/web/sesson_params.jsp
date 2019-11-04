<%@ page import="data.Person" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.10.2019
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="_id" class="data.ReqParameterId" scope="session"> </jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
${_id.id}
<%
    Person p = (Person) session.getAttribute("osoba");
    out.println(p.getPhoto());
%>

</body>
</html>
