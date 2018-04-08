<%-- 
    Document   : product1
    Created on : 2018/3/20, 下午 06:01:38
    Author     : Administrator
--%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>浪漫手做卡片</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
        <link rel="stylesheet" type="text/css" href="fancybox/jquery.fancybox.min.css">
        <script src="fancybox/jquery.fancybox.min.js"></script>
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


            #header img{
                display: block;
                margin-left: auto;
                margin-right: auto;
                margin-top: 50px;

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
            <%---------------------------------搜尋方塊CSS-----------------------------%>
            input[type=search]{
                margin:0 5%;
                width: 160px;
                box-sizing: border-box;
                border: 2px solid pink;
                border-radius: 4px;
                font-size: 16px;
                background-color: #FFF0F5;
                background-image: url('./image/search3.png');
                background-size:30px 30px;
                background-position: 5px 5px; 
                background-repeat: no-repeat;
                padding: 12px 20px 12px 40px;
                -webkit-transition: width 0.4s ease-in-out;
                transition: width 0.4s ease-in-out;
            }

            input[type=search]:focus {
                width: 50%;
                outline: none;
            }


            .section{
                float: left;
                width: 12%;
                min-width:8ex;
                background: pink;
            }
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
            }
            <%-----------------------------移動購物車CSS-----------------------------%>
            .aside{
                float:right;
                width: 12%;
                /*background: pink;*/
            }
            .aside img{
                /*                background:#FF0066;
                                color:#FFCC99;
                                border:4px solid #FF9999;
                                padding:5px;*/
                width:120px;
                height:120px;
                position:fixed;
                top:50%;
                right:10px;
                _position: absolute; /* position fixed for IE6 */
                /*_top:expression(documentElement.scrollTop+100);*/
                z-index:3;
            }
             <%---------------------------------商品清單-----------------------------%>
            .my_list li{
                /*background: orange;*/
                display: inline-block;
                width:250px;
                height: 300px;
                margin:10px 10px;
                box-shadow: 1px 1px 2px gray;
                overflow: hidden;
                border-radius: 10px;
            }
            .container {
                position: relative;
                width: 250px;
                max-width: 300px;
            }
            .my_list li img{
                display: block;
                width: 100%;
                height: 190px;
                /*border-radius: 50%;*/
            }
            <%---------------------------------透明加入購物車-----------------------------%>
            .overlay {
                border: none;
                outline: none;
                position: absolute; 
                bottom: 0; 
                background: rgb(0, 0, 0);
                background: rgba(0, 0, 0, 0.5); /* Black see-through */
                color: #f1f1f1; 
                width: 100%;
                transition: 1s ease;
                opacity:0;
                color: white;
                font-size: 20px;
                padding: 10px 0 10px 0;
                text-align: center;
            }
            .container:hover .overlay {
                opacity: 1;
            }
            .my_list h4{
                font-size: smaller;
                text_align:center;
            }
            .my_list_img:hover.overlay {
                opacity: 1;
            }
            #middle_cart{
                display:none;  
            }
        </style>

    </head>

    <% //controller
        String search = request.getParameter("search");
        String type = request.getParameter("type");
        String style = request.getParameter("style");
        ProductService service = new ProductService();
        List<Product> list = null;
        if ((search == null || search.length() == 0) && (type == null || type.length() == 0) && (style == null || style.length() == 0)) {
            list = service.getAllProducts();
        } else if (style != null) {
            list = service.getProductByStyle(style);
        } else {
            list = service.getProductsByNameAndType(search, type);
        }


    %>


    <body>

        <%            Customer member = (Customer) session.getAttribute("member");

        %>
        <div id="fiexd-header" >
            <div class="inside">

                <a  href="/HeartPrint/member/cart.jsp" >Cart</a>
                <span id="total_quantity">
                    <%@include file="/small_cart_ajax.jsp" %>
                </span>
                |
                <%                    if (member == null) {
                %>
                <a href="/HeartPrint/login.jsp">Login</a> |
                <a href="/HeartPrint/register.jsp">Register</a> 
                <%
                } else {
                %>
                <a href="/HeartPrint/logout.do">Logout</a> |
                <a href="/HeartPrint/member/update.jsp">Settings</a> 
                Hi!
                <%}%>
                <span id="welcome_span" style="float:right;font-size: smaller"><%= member != null ? member.getName() : ""%></span>
            </div>
        </div>

        <div id="header" >
            <a href="/HeartPrint/index.jsp">
                <img src="./image/logo.png">
            </a>
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

        <div class="article"  >           
            <form method="get">
                <input type="search" value="${param.search}" name="search" placeholder="請輸入商品" >
            </form>

            <% if (list != null && list.size() > 0) {%>
            <ul class="my_list">
                <% for (Product p : list) {%>

                <li>
                    <div  class="container">
                        <a href="javascript: getProductDetail('<%= String.format("%d", p.getId())%>')">
                            <img class="my_list_img"src="<%= p.getPhotoUrl()%>" >
                        </a>
                       
                            <a href="javascript:getMiddleCart('<%= String.format("%d", p.getId())%>') ">    
                             <div class="overlay">    加入購物車</div>
                            </a>
                        
                        <!--                                <input class="button" onclick=" getMiddleCart"  type='submit' value=''>-->


                    </div>  
                    <h4 align=center><%= p.getName()%></h4>
                    <h5 align=center>NT$<%= p.getUnitPrice()%></h5>

                </li>
                <% } %>
            </ul>
            <%} else {%>
            查無產品資料!
            <%}%>
        </div>
        <%---<span id="middle_cart">
            <%@include file="/middle_cart_ajax1.jsp" %>
        </span>--%>

        <div class="aside" >
            aside
            <a href="/HeartPrint/member/cart.jsp"> <img  src="./image/cart4.gif"></a> 
        </div>


        <br><br> <br><br> <br><br> <br><br> <br><br>
        <div class="footer" style="clear:both; color: gray">
            <hr >
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>

        </div>
        <div id='dialog'></div>
        <script>
            function getProductDetail(productId) {
                //送出同步的GET請求
                location.href = "product_detail2.jsp?productId=" + productId;
//                $.ajax({
//                    url: "product_detail2_ajax.jsp?productId=" + productId,
//                    method: 'GET'
//                })
            }

        </script>
        <script>
            function getMiddleCart(productId) {
//                alert("" + productId);
                $.ajax({
                    url: "middle_cart_ajax.jsp?productId=" + productId,
                    method: 'GET'
                }).done(getProductDetailDoneHandler);
            }
            function getProductDetailDoneHandler(result, textStatus, jqXHR) {
//                alert(result);
//                console.log(result);
                $("#dialog").html(result);
                $.fancybox.open({
                    src: '#dialog',
                    type: 'inline'
                });

            }
        </script>        
    </body>
</html>
