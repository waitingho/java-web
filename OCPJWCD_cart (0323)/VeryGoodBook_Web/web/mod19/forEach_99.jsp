<%-- 
    Document   : forEach_99
    Created on : 2018/3/19, 下午 04:00:45
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>        
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            table, td, th{border: 1px solid gray; border-collapse: collapse}
        </style>        
    </head>
    <body>
        <h1>Hello World!</h1>
        <table style="width:85%;max-width:80ex;margin: auto">            
            <caption>JSTL+el 99乘法表</caption>
            <%-- for (int i = 1; i < 10; i++) {--%>            
            <c:forEach begin="1" end="9" var="i">
            <tr>
                <%-- for (int j = 1; j < 10; j++) {--%>
                <c:forEach begin="1" end="9" var="j">
                <td>${i}*${j} = ${i*j}</td>
                </c:forEach>
                <%-- } --%>
            </tr>
            </c:forEach>
            <%-- }--%>
        </table>        
    </body>
</html>
