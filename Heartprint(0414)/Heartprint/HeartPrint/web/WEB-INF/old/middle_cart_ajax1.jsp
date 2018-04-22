<%-- 
    Document   : middle_cart_ajax
    Created on : 2018/4/3, 上午 10:09:14
    Author     : Administrator
--%>

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
        </style>
    </head>

    <body>
        <div class="article"  >
            <div>
                <div class="album">
                    <img class="mainPic" src='https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a72fdc011ed0043bc/800x.webp?source_format=jpg'>
                    <img src="https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a72fdc011ed0043bc/800x.webp?source_format=jpg" class="smallPic"/>
                    <img src="https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a1cacaf1732000c77/800x.webp?source_format=jpg" class="smallPic"/>
                    <img src="https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a59d524172f000030/800x.webp?source_format=jpg" class="smallPic"/>
                    <img src="https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0b59d524171d00000d/800x.webp?source_format=jpg" class="smallPic"/>
                </div>
                <div class="product_title" >
                    <div class="product_titl_title"><h1>聖誕老公公禮物盒</h1></div><br>
                    <div class="product_titl_price"> 

                        定價：<span>200</span><br>


                        優惠價：300元<br>
                    </div><br>
                    <h3>數量</h3><input type='number' value='1' min="1" max="10" id='quantity'>
                    <input class="button" type='submit' value='加入購物車'>
                </div>

            </div>
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
    </body>
</html>
