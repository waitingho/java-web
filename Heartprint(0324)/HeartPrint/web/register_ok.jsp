<%-- 
    Document   : register_ok
    Created on : 2018/3/21, 下午 06:51:59
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>註冊成功</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>

            #fiexd-header{
                background:pink;
                width:98.5%;
                position:fixed; /*固定位置定位*/
                top:0; /*距離上方 0 像素*/
                z-index:9999; /*重疊時會在其他元素之上*/
                padding: auto;
                text-align: right;
                vertical-align: bottom;
            }
            .inside a{
                text-decoration:none
            }
            .inside a:link{color:white;}
            .inside a:visited{color: gray;}
            .inside a:hover{color: yellow; }

            .nav a{
                text-decoration:none;
            }
            #header img{
                display: block;
                margin-left: auto;
                margin-right: auto;
                margin-top: 50px;

            }
            .nav{
                text-align: center;
            }
            .section{
                float: left;
                width: 30%;
                min-width:8ex;
            }
            .article{
                float: left;
                width:40%;
                min-height: 60vh;
                background:#FFF0F5;

                border-radius: 10px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19), 0 8px 30px 0 rgba(0, 0, 0, 0.18);
                /*border: 1px solid #BFBFBF;*/

            }
            .aside{
                float:right; 
                width: 30%;
                border: 1px solid #BFBFBF;
            }
        </style>
    </head>
    <%--
        Customer c = (Customer)request.getAttribute("customer");
    --%>
    <body>
        <%

            Customer member = (Customer) session.getAttribute("member");

        %>
        <div id="fiexd-header" >
            <div class="inside">

                <a  href="#" >Cart</a> |
                <%                    if (member == null) {
                %>
                <a href="/HeartPrint/login.jsp">Login</a> |
                <a href="/HeartPrint/register.jsp">Register</a> 
                <%
                } else {
                %>
                <a href="/HeartPrint/login.jsp">Logout</a> |
                <a href="/HeartPrint/register.jsp">Settings</a> 
                Hi!
                <%}%>
                <span id="welcome_span" style="float:right;font-size: smaller"><%= member != null ? member.getName() : ""%></span>
            </div>
        </div>

        <div id="header" >
            <a href="index.jsp"><img src="./image/logo.png"  border="0"></a>


        </div>   
        <br>
        <hr color=pink size="2">

        <div class="nav">
            <a href="/HeartPrint/product1.html" >浪漫手做卡片</a> |
            <a href="">優質可愛小品</a> |
            <a href="">About us</a> 
        </div><br><br><br>
        <div class="section" >
            section
        </div>
        <div class='article'>
            <%--            <h3>歡迎光臨! <%= c==null?c.getName():"" %></h3>            --%>
            <h3>HI!${requestScope.customer.name}　恭喜你已經完成註冊</h3>
        </div>
        <div class="aside" >
            aside
        </div>
        <div class="footer" style="clear:both; color: gray">
            <br><br> 
            <hr>
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>
        </div>

    </body>
</html>
