<%-- 
    Document   : product1
    Created on : 2018/3/20, 下午 06:01:38
    Author     : Administrator
--%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>浪漫手做卡片</title>
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
                position: absolute; /* position fixed for IE6 */
                /*_top:expression(documentElement.scrollTop+100);*/
                z-index:3;
            }
            .my_list{
                /*background: cyan;*/

            }
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
            .my_list li img{
                width: 100%;
                height: 190px;
                /* border-radius: 50%;*/
            }


            .my_list h4{
                font-size: smaller;
                text_align:center;
            }

            /*            .product_price{
                            font-size: smaller;
                            padding: 0 10px;
                            
                        }*/

        </style>

    </head>
    <%
//        String productId = request.getParameter("productId");

        List<Product> list = null;
        ProductService service = new ProductService();
        list = service.getAllProducts();
//        if(productId != null && productId.matches("\\d+")){
//            p = service.getProduct(Integer.parseInt(productId));
//        }
    %>
    <body>
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
            <% if (list != null && list.size() > 0) {%>
            <ul class="my_list">
 <% for(Product p:list) { %>
                <li>
                    <div style="margin:auto;width: 100%">
                        <img src="<%= p.getPhotoUrl()%>">
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


        <div class="aside" >
            aside
            <a href="#"> <img  src="./image/cart4.gif"></a> 
        </div>


        <br><br> <br><br> <br><br> <br><br> <br><br>
        <div class="footer" style="clear:both; color: gray">
            <hr >
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr><hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>
            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>


        </div>

    </body>
</html>
