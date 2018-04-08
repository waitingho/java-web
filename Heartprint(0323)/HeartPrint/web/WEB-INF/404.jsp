<%-- 
    Document   : 404
    Created on : 2018/3/21, 下午 08:31:16
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--todo-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404</title>
    </head>
    <body>
        <h1>錯誤訊息<sub>錯誤訊息<%= request.getAttribute("javax.servelt.error.status_code")!= null ? request.getAttribute("javax.servelt.error.status_code"):""%></h1>
    </body>
</html>
