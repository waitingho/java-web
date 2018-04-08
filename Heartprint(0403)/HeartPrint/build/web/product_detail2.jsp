<%-- 
    Document   : product_detail
    Created on : 2018/3/22, 下午 01:08:46
    Author     : Administrator
--%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page import="java.util.List"%>
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



            <%-----------------------------移動方塊CSS-----------------------------%>
            .section{
                float: left;
                width: 12%;
                min-width:8ex;
                border:1px solid black;
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
            <%-----------------------------主畫面CSS-----------------------------%>
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
                background:#6DD0CD;
            }

            <%-----------------------------商品價格CSS-----------------------------%>
            .product_title{
                margin:0 0 0 10%;
                float: left;
                /*border:1px solid black;*/
            }
            .accordion { 
                /*background-color: #FFF0F5;*/
                color: #444;
                cursor: pointer;
                width: 100%;
                border: none;
                text-align: left;
                outline: none;
                font-size: 10px;
                transition: 0.4s;
            }
            /*            .active, .accordion:hover {
                            background-color: pink;
                        }*/
            .accordion:after {
                content: '\2228';
                color: #777;
                font-weight: bold;
                float: right;
                margin-left: 5px;
            }

            .active:after {
                content: "\2227";
            }

            .panel {
                padding: 0 18px;
                /*background-color: #FFF0F5;*/
                max-height: 0;
                overflow: hidden;
                transition: max-height 0.2s ease-out;
            }
            .button {
                padding: 10px ;
                text-align: center;
                text-decoration: none;
                outline: none;
                background-color: #FFF0F5;
                border: none;
                border-radius: 10px;
                width: 100%;
            }
            .button:hover {background-color:#e7f3fe}
            /*            .select{
                            background: #6DD0CD;
                        }*/
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
            <%-----------------------------商品描述CSS-----------------------------%>

            .product_description{

                margin: 0 15% ;
                width:70%;
                border:1px solid black;
                float:left;
            }
            .product_description_title1{
                margin-bottom: 15px;
                padding: 4px 12px;
                color:#aaaaaa;
                background-color: #ddffdd;
                border-left: 6px solid #4CAF50;
            }
            .product_description_title2{
                margin-bottom: 15px;
                padding: 4px 12px;
                color:#aaaaaa;
                background-color: #ffffcc;
                border-left: 6px solid #ffeb3b;
            }
            .product_description_image img{
                margin:0 10% ;
                width:80%;
                border-radius: 30px;
            }
        </style>
    </head>
    <%
        //        Object member = session.getAttribute("member");
        String productId = request.getParameter("productId");
        Product p = null;
        ProductService service = new ProductService();
        if (productId != null && productId.matches("\\d+")) {
            p = service.getProduct(Integer.parseInt(productId));
        }
    %>

    <body>
        <%
            Customer member = (Customer) session.getAttribute("member");

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
            <div>
                <%if (p != null) {%>
                <div class="album">

                    <img class="mainPic" src='<%= p.getPhotoUrl()%>'>
                    <img src="<%= p.getPhotoUrl()%>" class="smallPic"/>
                    <img src="<%= p.getPhotoUrl2()%>" class="smallPic"/>
                    <img src="<%= p.getPhotoUrl3()%>" class="smallPic"/>
                    <img src="<%= p.getPhotoUrl4()%>" class="smallPic"/>
                </div>

                <br><br><br>
                <div class="product_title" >
                    <div class="product_titl_title"><h1><%= p.getName()%></h1></div><br>
                    <div class="product_titl_price"> 
                        <%if (p instanceof Outlet) {%>
                        定價：<span><%= ((Outlet) p).getListPrice()%>元</span><br>
                        <%}%>
                        <br>
                        優惠價：<%= p instanceof Outlet ? ((Outlet) p).getDiscountString() : ""%>
                        <%= p.getUnitPrice()%>元<br>
                    </div><br>
                    <div class="product_titl_waring">
                        <p> 設計師手工製作商品
                            採少量現貨 (3-5個工作天) 
                        </p><br><br>
                    </div>
                    <h3>數量</h3><input type='number' value='1' min="1" max="10" id='quantity'>
                    <br><br><br>

                    <button class="accordion" style="background-color: #FFF0F5;border-left: 6px solid pink;">
                        <h2>付款方式</h2>
                    </button>
                    <div class="panel">
                        <li>信用卡「支援國內外Visa, Master, JCB卡」</li>
                        <li>超商代碼繳費</li>
                    </div>

                    <button class="accordion" style=" background-color: #e7f3fe;border-left: 6px solid #2196F3;">
                        <h2>送貨方式</h2></button>
                    <div class="panel">
                        <li>7-11 取貨 </li>
                    </div>
                    <br><br>
                    <input onclick="addCart(<%= p.getId()%>)" class="button" type='submit' value='加入購物車'>
                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                </div>
                <div class="product_description">

                    <div class="product_description_title1"><h2>商品描述</h2></div>
                    <div style="text-align: center;">
                        <h3>【<%= p.getName()%>】</h3>

                        <p> <%= p.getDescription()%></p>


                    </div>
                    <div class="product_description_title2"><h2>了解更多</h2></div>
                    <div class="product_description_image">
                        <img src="<%= p.getPhotoUrl()%>">
                        <img src="<%= p.getPhotoUrl2()%>">
                        <img src="<%= p.getPhotoUrl3()%>">
                        <img src="<%= p.getPhotoUrl4()%>">
                    </div>
                </div>
                <%} else {%>
                <p>查無此代號<%= productId != null ? "(" + productId + ")" : ""%>的商品明細</p>
                <%}%>
            </div>
        </div>





        <div class="aside" >
            aside
            <a href="/HeartPrint/member/cart.jsp"> <img  src="./image/cart4.gif"></a> 
        </div>

        <br><br> <br><br> <br><br> <br><br> <br><br><br><br> <br><br> <br><br> <br><br> <br><br>
        <br><br> <br><br> <br><br> <br><br> <br><br><br><br> <br><br> <br><br> <br><br> <br><br>
        <br><br> <br><br> <br><br> <br><br> <br><br><br><br> <br><br> <br><br> <br><br> <br><br>
        <br><br> <br><br> <br><br> <br><br> <br><br><br><br> <br><br> <br><br> <br><br> <br><br>
        <div class="footer" style="clear:both; color: gray">
            <hr>
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>

        </div>

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
        <script type="text/javascript">
            function addCart(productId) {
                alert('加入購物車');
////                同步請求
//                location.href = "add_cart.do?quantity=" + $("#quantity").val() + "&productId=" + productId;
//
//            }
                $.ajax({
                    url: "add_cart_ajax.do?quantity="
                            + $("#quantity").val() + "&productId=" + productId,
                    method: "GET"
                }).done(addCartDoneHandler);
            }
            function addCartDoneHandler(result) {
                console.log(arguments[0]);
                if ($("#total_quantity")) {
                    $("#total_quantity").text(result);
                } else {
                    alert(result)
                }
            }

        </script>
        <script type="text/javascript">
            var acc = document.getElementsByClassName("accordion");
            var i;
            for (i = 0; i < acc.length; i++) {
                acc[i].addEventListener("click", function () {
                    this.classList.toggle("active");
                    var panel = this.nextElementSibling;
                    if (panel.style.maxHeight) {
                        panel.style.maxHeight = null;
                    } else {
                        panel.style.maxHeight = panel.scrollHeight + "px";
                    }
                });
            }
        </script> 


    </body>
</html>
