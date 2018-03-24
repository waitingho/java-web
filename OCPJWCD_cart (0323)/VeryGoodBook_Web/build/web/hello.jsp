<%-- 
    Document   : hello
    Created on : 2018/3/9, 下午 05:17:55
    Author     : Administrator
--%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Servlet HelloServlet</title>
    </head>
    <body>
        <%! 
            private int i; //attribute
            public int getI(){
                return i;
            }

            public void jspInit(){
                this.log(this.getClass().getName()+ " 建立一個物件");
                String i = this.getInitParameter("i");                
                if(i!=null && i.matches("\\d+")){
                    this.i=Integer.parseInt(i);
                }
            }
        %>
        <%
            int i=1; //local variable
        %>
        <%
            out.println("<h1>你好! " + request.getContextPath() + ", 現在時間是:" + LocalDate.now() + "</h1>");            
        %>
        <p>
            屬性i: <%=  this.i%>            
        </p>
        <p>
            區域變數i: <%=  i%>            
        </p>
        
        <h3 id="rare">config</h3>
        <p>init parameter:<%= this.getInitParameter("i") %></p>
        <p>init parameter:<%= config.getInitParameter("i") %></p>
        
        <%--
            for(int i=1;i<10;i++){
                for(int j=1;j<10;j++){
                    out.println(i+"*"+ j +"=" + i*j + "<br>");                        
                }                
            }
        --%>
    </body>
</html>

