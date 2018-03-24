<%-- 
    Document   : scriplet_expression_99
    Created on : 2018/3/12, 上午 10:21:49
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Expression 99乘法表</title>
        <style>
            table, td, th{border: 1px solid gray; border-collapse: collapse}
        </style>
    </head>
    <body>
        <h1>JSP Expression 99乘法表</h1>        
        <%
            for(int i=1;i<10;i++){
                for(int j=1;j<10;j++){
                    out.println(i+"*"+ j +"=" + i*j + "<br>");                        
                }                
            }
        %>        
        <hr>
        <table style="width:85%;max-width:80ex;margin: auto">            
            <caption>JSP Expression 99乘法表</caption>
            <% for(int i=1;i<10;i++){%>            
            <tr>
                <% for(int j=1;j<10;j++){%>
                <td><%= i %>*<%= j %> = <%= i*j %></td>
                <% } %>
            </tr>
            <% } %>
        </table>
    </body>
</html>
