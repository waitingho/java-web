<%-- 
    Document   : el
    Created on : 2018/3/19, 上午 11:13:32
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>EL Demo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>EL Demo</h1>
        <h2>Operators</h2>
        <p>&lt;%= 1/2 %&gt;:  <%= 1/2 %></p>
        <p>\${ 1/2 }: ${1/2}</p>
        <p>&lt;%= 1+2 %&gt;:  <%= 1+2 %></p>
        <p>\${ 1+2 }: ${1+2}</p>
        <p>&lt;%= '1'+'2' %&gt;:  <%= '1'+'2' %></p>
        <p>\${ '1'+'2' }: ${'1' + '2'}</p>
        <p>&lt;%= "1"+"2" %&gt;:  <%= "1" + "2" %></p>
        <p>\${ "1"+"2" }: ${"1" + "2"}</p>
        <p>&lt;%= 'a'+'b' %&gt;:  <%= 'a'+'b' %></p>
        <p>\${ 'a'+'' }: \${'a' + 'b'}</p>
        <p>&lt;%= "a"+"b" %&gt;:  <%= "a" + "b" %></p>
        <p>\${ "a"+"b" }: ${"a"}${"b"}</p>
        <hr>
        <p>&lt;%= 1>2 %&gt;:  <%= 1>2 %></p>
        <p>\${ 1>2 }: ${1>2}</p>
        <p>&lt;%= '1'>'2' %&gt;:  <%= '1'>'2' %></p>
        <p>\${ '1'>'2' }: ${'1' > '2'}</p>
        <p>&lt;%= "1".compareTo("2") %&gt;:  <%= "1".compareTo("2") %></p>
        <p>\${ "1">"2" }: ${"1">"2"}</p>
        <p>\${ "a">"b" }: ${"a">"b"}</p>
        <hr>
        <p>&lt;%= true & true  %&gt; <%= true & true %></p>
        <p>&lt;%= true & false  %&gt; <%= true & false %></p>
        <p>&lt;%= false & true  %&gt; <%= false & true %></p>
        <p>&lt;%= false & false  %&gt; <%= false & false %></p>
        
        <p>\${true && true} ${true && true}</p>
        <p>\${"true" && false} ${"true" && false}</p>
        <p>\${"false" && true} ${"false" && true}</p>
        <p>\${false && false} ${false && false}</p>
        <hr>
        <h2>pageContext</h2>
        <p>&lt;%= pageContext.getSession().getId() %&gt;: <%= pageContext.getSession().getId() %></p>
        <p>\${pageContext.session.id}: ${pageContext.session.id}</p>
        <p>&lt;%= ((HttpServletRequest)pageContext.getRequest()).getContextPath() %&gt;: <%= ((HttpServletRequest)pageContext.getRequest()).getContextPath() %></p>
        <p>\${pageContext.request.contextPath}: ${pageContext.request.contextPath}</p>
        <h2>cookie</h2>
        <p>cookie id: ${cookie.id.value}</p>
        <h2>initParam: Global init parameter</h2>
        <p>&lt;%= application.getInitParameter("app-name") %&gt;: <%= application.getInitParameter("app-name") %> </p>
        <p>\${initParam["app-name"]}: ${initParam["app-name"]}</p>
        <h2>header</h2>
        <p>&lt;%= request.getHeader("user-agent") %&gt;: <%= request.getHeader("user-agent") %>
        <p>\${header["user-agent"]}: ${header["user-agent"]}</p>    
        <h2>param</h2>
        <p>&lt;%= request.getParameter("name") %&gt;: <%= request.getParameter("name") %>
        <p>\${param.name}: ${param.name}</p>    
    </body>
</html>
