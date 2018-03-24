<%-- 
    Document   : page1
    Created on : 2018/3/12, 下午 04:46:58
    Author     : Administrator
--%>

<%@page import="java.text.SimpleDateFormat" errorPage="/WEB-INF/error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Divid by 0</title>
        <meta charset='UTF-8'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">   
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>            
            1/0: <%= 1 / 0%><!-- unchecked exception --> 
            date: <%= new SimpleDateFormat("yyyy-MM-dd").parse("abcd-12-20")%> <!-- checked exception -->            
        </p>
    </body>
</html>
