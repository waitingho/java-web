<%-- 
    Document   : shipping
    Created on : 2018/3/20, 上午 11:21:02
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>出貨作業</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="出貨作業" />            
        </jsp:include>
        <div class='article'>
            
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
