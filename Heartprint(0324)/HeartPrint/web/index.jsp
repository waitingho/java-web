<%-- 
    Document   : index.jsp
    Created on : 2018/3/19, 下午 07:19:36
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HeartPrinT</title>
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
            .nav{
                text-align: center;
            }
            .nav a{
                text-decoration:none;
            }
            .nav a:hover{
                font-size: 1.5em;
                text-decoration: overline;
            }


            #header img{
                display: block;
                margin-left: auto;
                margin-right: auto;
                margin-top: 50px;

            }

            #inner img{
                display:block; 
                margin:auto;
                border-radius: 20px;
            }

            .example{
                /*border: 1px solid black;*/
                margin: auto;
                width: 800px;
                height: 500px;
                padding-right: 5%;
                padding-left: 5%;
                color:gray;
            }
            .example div{
                width: 30%;
                height: 80%;
                float: left;
                margin: 10px;
                /*border: 1px solid black;*/
            }
            .example img{
                width:220px;
                height:220px;
                padding: 3px;
                margin: 5px;
                border-radius: 50%;

                box-shadow:  0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19), 0 8px 30px 0 rgba(0, 0, 0, 0.18);
            }

        </style>
    </head>
    <body>

        <%

            Customer member = (Customer) session.getAttribute("member");

        %>
        <div id="fiexd-header" >
            <div class="inside">

                <a  href="#" >Cart</a> |
                <%                    
                    if (member == null) {
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
            <a href="/HeartPrint/product1.jsp" >浪漫手做卡片</a> |
            <a href="">優質可愛小品</a> |
            <a href="">About us</a> 
        </div><br><br><br>

        <div id="inner">
            <img src="./image/product3.png" style="">
        </div>
        <br><br>

        <div class="example">
            <div>  
                <img src="./image/product3-3.png">
                <h3  align=center> 謝謝你總是用相片帶我看見眼前的美好</h3>

            </div> 
            <div> 
                <img src="./image/product3-9.png">
                <h3 align=center> 鏟屎官必備，吐司墊</h3>
            </div>
            <div> 
                <img src="./image/product3-10.png">
                <h3 align=center> 你是不是也受夠了桌上凌凌亂亂的線</h3>
            </div>

        </div>

        <div class="footer" style="clear:both; color: gray">
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>
            <span style='float:right'>拜訪人次:<%= application.getAttribute("app.visitors")%>,
                你是第<%= session.getAttribute("app.visitors") %>位訪客</span>
        </div>
    </body>
</html>
