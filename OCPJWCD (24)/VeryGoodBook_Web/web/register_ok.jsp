<%@page import="uuu.vgb.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>註冊成功</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
    </head>
    <%--
        Customer c = (Customer)request.getAttribute("customer");
    --%>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="註冊成功" />            
        </jsp:include>
        <div class='article'>
<%--            <h3>歡迎光臨! <%= c==null?c.getName():"" %></h3>            --%>
        <h3>${requestScope.customer.name}　恭喜你已經完成註冊</h3>
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
