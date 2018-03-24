<%-- 
    Document   : page1
    Created on : 2018/3/16, 下午 04:09:00
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Page1</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Hello, Page1</h1>
        <%--
            out.flush();
            request.getRequestDispatcher("page2.jsp").forward(request, response);
        --%>
    <%--
            <jsp:forward page="page2.jsp" />
       --%>
        <jsp:include page="page2.jsp" />
        <h1>bye, Page1</h1>
    </body>
</html>
