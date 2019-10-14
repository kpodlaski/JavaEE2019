<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.10.2019
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="sPrinter" class="data.SimplePrinter" />
<jsp:useBean id="person" class="data.Person" />
<html>
  <head>
    <title>Tytul Strony</title>
  </head>
  <body>
  Tekst na stronie ${2+3}
  <%
    for(int i=0; i<11; i++){

      out.println("Ala ma kota 123<br/>");
      }
  %>
  ===========================<br/>
  ${sPrinter.writeManyTimes(5,"Z obiektu")}
  ===========================<br/>
  <table>
    <tr><td>
      <table><tr><td>${person.name}</td></tr>
        <tr><td>${person.surname}</td></tr></table>
    </td>
    <td>
      <img src="${person.photo}" />
    </td>
    </tr>
  </table>
  </body>
</html>
