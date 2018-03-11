<%-- 
    Document   : hello
    Created on : 2018/3/9, 下午 05:18:02
    Author     : Administrator
--%>

<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Servlet HelloServlet</title>
    </head>
    <body>
        <%
            out.println("<h1>嗨~" + request.getContextPath() +" ,現在時間是:"+LocalDate.now()+ "</h1>");
        %>
        
        <%
            for(int i =1;i<10;i++){
                for(int j=1;j<10;j++){
                    out.println(i+"*"+j+"="+i*j+"<br>");
                }
            }
        %>
    </body>
</html>

