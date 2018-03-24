<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="vgb"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="title" value="會員登入"/>
<%--
    //Thread.sleep(5000);
--%>
<!DOCTYPE html>
<html>
    <head>
        <title>${pageScope.title}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
    </head>
    <body>                
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="${title}" />            
        </jsp:include>
        <div class="section" style="float:left;width:12%;min-width:8ex">
            section
        </div>
        <%--
            Object obj = request.getAttribute("errors");
            List<String> list = null;
            if(obj instanceof List){
                list = (List<String>)obj;
            }
        --%>        
        <div class="article" style="float: left;width:75%;min-width:60ex;min-height:65vh;background-color: lightgray">                      
            <c:if test="${not empty requestScope.errors}">
                ${requestScope.errors}
            </c:if>
            <form action='<c:url  value="/login.do"/>' method="POST">
                <%
                    //read cookie...
                    String id = "";
                    String auto = "";
                    Cookie[] cookies = request.getCookies();
                    if(cookies!=null){
                        for(Cookie cookie : cookies){
                            if(cookie.getName().equals("id")){
                                id = cookie.getValue();
                            }else if(cookie.getName().equals("auto")){
                                auto = cookie.getValue();        
                            }
                        }
                    }
                %>
     
                <p>
                    <label>帳號:</label>
                    <input type='text' name='id' placeholder="請輸入身分證號" required
                           <%--  value='<%= request.getParameter("id")!=null?request.getParameter("id"):id%>'> --%>
                           <%--  value='${not empty param.id?param.id:cookie.id.value}'> --%>
                           value='<c:out value="${param.id}" default="${cookie.id.value}" />'>
                    <input type="checkbox" name="auto" <%= auto %> ><label>記住帳號</label>
                </p>
                <p>
                    <label>密碼:</label>
                    <input type='password' name='pwd' 
                           placeholder="請輸入密碼" minlength="6" maxlength="20" required>
                    <input type='hidden' value='<c:out value="<hello>" />'>
                </p>
                <p>                    
                    <label>驗證:</label>
                    <vgb:captchaInput src="images/captcha.jpg" name='captcha'  />
                </p>               
                <input type='submit' value="登入">                
            </form>
        </div>
        <div class="aside" style="float:right;width:12%">
            aside
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
