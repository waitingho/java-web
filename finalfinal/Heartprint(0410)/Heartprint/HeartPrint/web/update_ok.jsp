<%-- 
    Document   : update_ok
    Created on : 2018/3/29, 下午 01:54:00
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.VIP"%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="icon" type="image/png" href="/HeartPrint/image/logo1616.png" />
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
            <%-----------------------------移動方塊CSS-----------------------------%>
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
                /*font-family: 微軟正黑體;*/
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
            <%---------------------------------中間-----------------------------%>
            .article{
                /*                float: left;
                                width:40%;
                                min-height: 60vh;
                                background:#FFF0F5;
                                border-radius: 50%;
                                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19), 0 8px 30px 0 rgba(0, 0, 0, 0.18);*/

                float: left;
                min-height: 75vh;
                width:75%;
                /*background:url("/HeartPrint/image/1.jpg");*/
                background-repeat: no-repeat;
            }

            <%-----------------------------移動購物車CSS-----------------------------%>
            .aside{
                float:right;
                width: 12%;

            }
            .aside_img{

                background:url("/HeartPrint/image/cart14.gif");
                width:120px;
                height:120px;
                position:fixed;
                top:50%;
                right:10px;

                _position: absolute; /* position fixed for IE6 */
                /*_top:expression(documentElement.scrollTop+100);*/
                /*z-index:3;*/
                text-align:center;
                line-height: 55px;
                font-family: 微軟正黑體;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更改成功</title>
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
            <a href="/HeartPrint/index.jsp"><img src="../image/logo.png"></a>
        </div>    
        <br>
        <div class="section" >
            <div  class="sidenav">
                <a href="/HeartPrint/product1.jsp" class="about">全部商品</a>
                <a href="/HeartPrint/product1.jsp?style=house" class="blog">禮物盒</a>
                <a href="/HeartPrint/product1.jsp?style=card" class="projects">浪漫卡片</a>
                <a href="/HeartPrint/product1.jsp?style=cute" class="contact">可愛小物</a>
            </div>
        </div>
        <div class="article" style="text-align:center;">
            <hr color=pink size="2">
            <h1>更改成功</h1>
            <a href ="/HeartPrint/product1.jsp" ><h2>回到商品區!</h2></a>
            <img src="/HeartPrint/image/1.jpg">
        </div>
        <a href="/HeartPrint/member/cart.jsp">
            <div class="aside_img" style="">
            </div>
        </a>

    </body>
</html>
