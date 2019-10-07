package servlets;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name="FirstServlet", urlPatterns = "/FirstServlet")
public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StringBuffer reqUrl =request.getRequestURL();
        String contextPath = request.getContextPath();
        String hostHeader = request.getHeader("Host");
        response.setHeader("Content-Type","text/html; charset=utf-8");
        response.getWriter().println("<b>Coś tam</b>");
        response.getWriter().println("<br>");
        response.getWriter().println("ReqUrl "+reqUrl+"<br>");
        response.getWriter().println("Cpath "+contextPath+"</br>");
        response.getWriter().println("Host: "+hostHeader);
        response.getWriter().println("Client IP"+request.getRemoteHost());
        response.getWriter().println("Querry str: "+request.getQueryString());
        String html = "<img src='/img?kon.jfif'>";
        response.getWriter().println(html);
    }


}
