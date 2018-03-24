<%-- 
    Document   : 404
    Created on : 2018/3/16, 下午 02:30:03
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" 
                       value='錯誤代碼:${requestScope["javax.servlet.error.status_code"]}'/>
        </jsp:include>        
        <div class="article" style="min-height: 65vh">
            <image src="<%= request.getContextPath() %>/images/404.jpg">            
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %> 
    </body>
</html>
