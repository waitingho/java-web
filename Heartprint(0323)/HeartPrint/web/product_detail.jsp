<%-- 
    Document   : product_detail
    Created on : 2018/3/22, 下午 01:08:46
    Author     : Administrator
--%>
<%@page import="java.util.Arrays"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
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
                border:1px solid black;
            }
            .album{
                margin:0 0 0 10%;
                width:490px;
                height:610px;
                float: left;
                /*                border:1px solid gray;*/
                padding:10px;
                background:pink;
                border-radius: 20px;
                box-shadow:  0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19), 0 8px 30px 0 rgba(0, 0, 0, 0.18);
            }

            .product_title{
                 margin:0 0 0 10%;
                float: left;
                border:1px solid black;
            }

            .mainPic{
                width:480px;
                height:480px;
                border-radius: 50%;
                padding:5px 5px 5px ;
                background:white;
            }

            .smallPic{
                width:100px;
                height:100px;
                padding:5px;
                background:white;
                margin:10px 3px;
                border-radius: 50%;
            }
            .select{
                background: #6DD0CD;
            }
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

        </style>
        <script type="text/javascript" src="./jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(init);
            function init()
            {
                $(".smallPic").click(clickHandler);
                $(".smallPic:first").addClass("select");
            }
            function clickHandler() {
                var image = $(this).attr("src");
                $(".mainPic").attr("src", image);
                $(".smallPic").removeClass("select");
                $(this).addClass("select");
            }
        </script>  
    </head>
    <%
        String productId = request.getParameter("productId");
        Product p = null;
        ProductService service = new ProductService();
        if (productId != null && productId.matches("\\d+")) {
            p = service.getProduct(Integer.parseInt(productId));
        }
    %>
    <body>
        <div id="fiexd-header" >
            <div class="inside">

                <a  href="#" >Cart</a> |
                <a href="/HeartPrint/login.jsp">Logoin</a> |
                <a href="/HeartPrint/register.jsp">Register</a> 
            </div>
        </div>

        <div id="header" >
            <a href="/HeartPrint/index.jsp">
                <img src="./image/logo.png">
            </a>
        </div>   
        <br>
        <hr color=pink size="2">

        <div class="nav">
            <a href="/HeartPrint/product1.jsp" >浪漫手做卡片</a> |
            <a href="">優質可愛小品</a> |
            <a href="">About us</a> 
        </div><br><br><br>


        <div class="section" >
            section
        </div>

        <div class="article"  >
            <div class="album">

                <img class="mainPic" src="https://shoplineimg.com/559785a6e37ec6046a000017/59489f929f9a4fb94b003b77/800x.webp?source_format=jpg"/>
                <div>
                    <img src="https://shoplineimg.com/559785a6e37ec6046a000017/59489f929f9a4fb94b003b77/800x.webp?source_format=jpg" class="smallPic"/>
                    <img src="https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f5956301737000455/800x.webp?source_format=jpg" class="smallPic"/>
                    <img src="https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f6ef2d4d936004576/800x.webp?source_format=jpg" class="smallPic"/>
                    <img src="https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f59563017280004eb/800x.webp?source_format=jpg" class="smallPic"/>
                </div>
            </div>

            <div class="product_title" >
                <h2>甜蜜小屋手作機關禮物盒</h2>
                <p>NT$990<br>
                    設計師手工製作商品<br>採少量現貨 (3-5個工作天) +預購 (7-14個工作天)<br><br>
                    付款方式<br>
                    送貨方式
                </p>
            </div>


        </div>

        <div class="aside" >
            aside
            <a href="#"> <img  src="./image/cart4.gif"></a> 
        </div>

        <br><br> <br><br> <br><br> <br><br> <br><br><br><br> <br><br> <br><br> <br><br> <br><br>
        <br><br> <br><br> <br><br> <br><br> <br><br><br><br> <br><br> <br><br> <br><br> <br><br>
        <div class="footer" style="clear:both; color: gray">
            <hr >
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr><hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>

        </div>


    </body>
</html>
