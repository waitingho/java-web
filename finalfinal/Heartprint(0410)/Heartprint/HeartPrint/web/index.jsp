<%-- 
    Document   : index.jsp
    Created on : 2018/3/19, 下午 07:19:36
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.VIP"%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HeartPrinT</title>
        <link rel="icon" type="image/png" href="/HeartPrint/image/logo1616.png" />
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
            .inside a:link{color:gray;}
            .inside a:visited{color: gray;}
            .inside a:hover{color: yellow; }
            .header{
                width:100%;
                float:left;
            }
            .header a{
                display: block;
                width:394px;
                margin:50px auto;
            }
            #inner{
                float: left;
                min-height: 40vh;
                width:75%;
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
                font-family: 微軟正黑體;
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

            .aside{
                float:right;
                width: 12%;
                /*background: pink;*/
            }
            <%---------------------------------移動方塊CSS--------------------------------%>
            .section{
                float: left;
                width: 12%;
                min-width:8ex;
                border:1px solid white;
            }
            .sidenav a{
                position:fixed;
                float:left;
                left: -100px;
                transition: 0.3s;
                padding: 15px;
                width: 130px;
                text-decoration: none;
                font-size: 20px;
                color:#999;
                border-radius: 0 5px 5px 0;
                font-family: 微軟正黑體;
            }
            .sidenav a:hover {
                left: 0;
            }
            .about {
                /*float:left;*/
                top:50%;
                background-color: #FFF0F5;
                border-right: 6px solid pink;
            }
            .blog {
                /*float:left;*/
                top: 60%;
                background-color:#e7f3fe;
                border-right: 6px solid #2196F3;
            }
            .projects {
                /*float:left;*/
                top: 70%;
                background-color: #ddffdd;
                border-right: 6px solid #4CAF50;
            }
            .contact {
                /*float:left;*/
                top: 80%;
                background-color: #ffffcc ;
                border-right: 6px solid #ffeb3b;
            }

        </style>
    </head>
    <body>

        <%

            Customer member = (Customer) session.getAttribute("member");

        %>
        <div id="fiexd-header" >
            <div class="inside">

                
                <a  href="/HeartPrint/member/cart.jsp" >Cart</a>
                <span id ="total_quantity">
                    <%@include file="/small_cart_ajax.jsp" %></span>
                |
                 <%                    if (member == null) {
                %>
                <a href="/HeartPrint/login.jsp">Login</a> |
                <a href="/HeartPrint/register.jsp">Register</a> 
                <%
                }else {%>                 
                <a href="/HeartPrint/logout.do">Logout</a> |
                <a href="/HeartPrint/member/update.jsp">Settings</a>|
                <a href="/HeartPrint/member/orders_history.jsp">order</a>|                
                    Hi! <%= member instanceof VIP? "VIP" :"" %>
                <%}%>
                <span id="welcome_span" style="float:right;font-size: smaller"><%= member != null ? member.getName() : ""%></span>
            </div>
        </div>

        <div class="header" >
            <a href="index.jsp"><img src="./image/logo.png"></a>
        </div>    
        <br>
        <hr color=pink size="2">

        <br><br><br>
        <div class="section" >
            <div  class="sidenav">
                <a href="/HeartPrint/product1.jsp" class="about">全部商品</a>
                <a href="/HeartPrint/product1.jsp?style=house" class="blog">禮物盒</a>
                <a href="/HeartPrint/product1.jsp?style=card" class="projects">浪漫卡片</a>
                <a href="/HeartPrint/product1.jsp?style=cute" class="contact">可愛小物</a>
            </div>
        </div>

        <div id="inner">
            <img src="./image/product3.png" style="">
        </div>
        <br><br><br><br><br><br>

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

        <div class="footer" style="clear:both; color: gray;">
            <hr>
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>

        </div>
    </body>
</html>
