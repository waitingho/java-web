<%-- 
    Document   : login_ok
    Created on : 2018/3/13, 下午 08:38:51
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.Customer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>       
        <title>登入成功</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            Object obj = session.getAttribute("customer");
            Customer c = null;
            if (obj instanceof Customer) {
                c = (Customer) obj;
            }
        %>
        <div class='header'>
            <h1><a href="/hp/">HeartPrinT</a> <sub>登入成功</sub></h1>
            <hr>
        </div>
        <div class='article'>
            <h3>歡迎光臨!<%= c != null ? c.getName() : ""%> </h3>           
        </div>
    </body>

</html>
