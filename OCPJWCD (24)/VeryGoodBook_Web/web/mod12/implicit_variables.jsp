<%-- 
    Document   : implicit_variables
    Created on : 2018/3/12, 下午 02:10:32
    Author     : Administrator
--%>
<%@page import="java.util.Enumeration" info="隱含變數(Implicit Variables)"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%--
            int i = 1;
                if(i==1){
                    response.sendError(404);
                    return;
                }
        --%>

<!DOCTYPE html>
<%! int i = 100;%>
<html>
    <head>        
        <title><%= this.getServletInfo() %></title>
    </head>
    <body>
        <h1><%= this.getServletInfo() %>: <a href="#req">request</a> | <a href="#res">response, out</a>
            | <a href="#rare">rare</a>
        </h1>
        <hr>
        <h3 id="req">request</h3>
        <p>method type: <%= request.getMethod()%></p>
        <p>URL: <%= request.getRequestURL()%></p>
        <p>URI: <%= request.getRequestURI()%></p>
        <p>protocol: <%= request.getProtocol()%></p>
        <p>host name: <%= request.getLocalName()%></p>
        <p>host address: <%= request.getLocalAddr()%></p>
        <p>port: <%= request.getLocalPort()%></p>
        <p>client name: <%= request.getRemoteHost()%></p>
        <p>client address: <%= request.getRemoteAddr()%></p>
        <p>client port: <%= request.getRemotePort()%></p>
        <fieldset>
            <legend>dump headers</legend>            
            <%
                out.flush();
                Thread.sleep(2000);
                Enumeration<String> names = request.getHeaderNames();
                while (names.hasMoreElements()) {
                    String name = names.nextElement();
                    String value = request.getHeader(name);
            %>
            <p><%= name%>: <%= value%></p>            
            <% }%>
        </fieldset>
        <fieldset>
            <form action="" method="POST">
                <input placeholder="請輸入姓名" name="name">
                <input placeholder="請輸入性別" name="gender">
                <input type="submit" value="OK" >
            </form>            
            <legend>dump form data</legend>            
            <% request.setCharacterEncoding("UTF-8"); 
                Enumeration<String> parameterNames = request.getParameterNames();
                while(parameterNames.hasMoreElements()){
                    String name = parameterNames.nextElement();
                    String value = request.getParameter(name);                
            %>
            <p><%= name %>: <%= value %></p>                        
            <% } %>
        </fieldset>
        <hr>
        <h3 id="res">response, out</h3>
        <p>status: <%= response.getStatus() %></p>
        <p>Content Type: <%= response.getContentType() %></p>
        <p>buffer size: <%= out.getBufferSize() %></p>
        <% out.println("<p>" + "Hello" + "</p>"); %>
        <hr>
        <h3>session</h3>
        <p>session id: <%= session.getId() %></p>
        <h3>application</h3>
        <hr>
        <h3 id="rare">config</h3>
        <p>servlet-name:<%= this.getServletName() %></p>
        <p>servlet-name:<%= config.getServletName() %></p>
        <p>init parameter:<%= this.getInitParameter("fork") %></p>
        <p>init parameter:<%= config.getInitParameter("fork") %></p>
        <h3>pageContext</h3>
        <p>request header: <%= ((HttpServletRequest)(pageContext.getRequest())).getHeader("user-agent") %></p>        
        <h3>page</h3>
        <p>this.i: <%= this.i %>
        <p>page.toString(): <%= page.toString() %>
        <hr>
        <h3 id="exception">exception(這裡不能用，一般JSP中不會宣告這個隱含變數)</h3>
        
    </body>
</html>