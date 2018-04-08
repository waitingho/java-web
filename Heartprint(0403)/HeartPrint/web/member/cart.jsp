<%-- 
    Document   : cart
    Created on : 2018/3/23, 上午 11:17:59
    Author     : Administrator
--%>
<%@page import="uuu.vgb.entity.CartItem"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.Cart"%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String uri = request.getRequestURI();
    Customer member = null;
    if (uri.indexOf(request.getContextPath() + "/member") >= 0) {
        member = (Customer) session.getAttribute("member");
        if (member == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
    }
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart != null) {
        cart.setMember(member);
    }


%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HP Cart</title>
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
            <%---------------------------------移動方塊CSS--------------------------------%>
            .section{
                float: left;
                width: 30%;
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
            .article{
                float: left;
                width:40%;
                min-height: 60vh;
                /*background:#e7f3fe;*/
                border-radius: 10px;
            }
            .article_in{
                text-align:center;
            }
            .table{
                border-collapse: collapse;
                width: 100%;
            }
            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            /*tr:hover {background-color:#e7f3fe;}*/
            tbody tr:nth-child(even) {background-color: #e7f3fe;}
            tbody tr:nth-child(odd) {background-color: #FFF0F5;}
            .table_img{
                /*float:left;*/
                width:150px;
                height:150px;
                vertical-align:middle ;
                border-radius: 20px;
                padding:5px;
                background:white;
            }
            .button {
                padding: 10px ;
                text-align: center;
                text-decoration: none;
                outline: none;
                background-color: #FFEBCD;
                border: none;
                border-radius: 10px;
                width: 100%;
            }
            .button:hover {background-color:#FFE4B5}

            .aside{
                float:right; 
                width: 30%;
                border: 1px solid #BFBFBF;
            }
        </style>
    </head>
    <body>

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
                <a href="/HeartPrint/logout.do">Logout</a> |
                <a href="/HeartPrint/member/update.jsp">Settings</a> 
                Hi!
                <%}%>
                <span id="welcome_span" style="float:right;font-size: smaller"><%= member != null ? member.getName() : ""%></span>
            </div>
        </div>

        <div id="header" >
            <a href="/HeartPrint/index.jsp">
                <img src="../image/logo.png">
            </a>
        </div>   
        <br>
        <hr color=pink size="2">
        <div class="section" >
            <div  class="sidenav">
                <a href="/HeartPrint/product1.jsp" class="about">全部商品</a>
                <a href="/HeartPrint/product1.jsp?style=house" class="blog">禮物盒</a>
                <a href="/HeartPrint/product1.jsp?style=card" class="projects">浪漫卡片</a>
                <a href="/HeartPrint/product1.jsp?style=cute" class="contact">可愛小物</a>
            </div>
        </div>

        <div class="article">
            <div class="article_in">
                <%if (cart != null && cart.size() > 0) {%>
                <form method="POST" action="update_cart.do">
                    <table>

                        <thead>
                            <tr>
                                <td>名稱</td>
                                <td>定價</td>
                                <td>折扣</td>
                                <td>售價</td>
                                <td>數量</td>
                                <td>刪除</td>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (CartItem item : cart.getCartItemSet()) {%>
                            <tr>
                                <td>
                                    <img src="<%= item.getProduct().getPhotoUrl()%>" class="table_img">
                                    <%= item.getProduct().getName()%></td>

                                <td><%= item.getProduct() instanceof Outlet ? ((Outlet) item.getProduct()).getListPrice() : ""%></td>
                                <td><%= item.getProduct() instanceof Outlet ? ((Outlet) item.getProduct()).getDiscountString() : ""%></td>
                                <td><%= item.getProduct().getUnitPrice()%></td>
                                <td><input name='quantity_<%=item.getProduct().getId()%>' type='number' min='1' 
                                           max='10'  value='<%= cart.getQuantity(item)%>'></td>
                                <td><input name='delete_<%=item.getProduct().getId()%>' type='checkbox'></td>
                            </tr>
                            <%}%>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="4"><input class="button" type="button" value="回到賣場" onclick="gobackShop()"></td>
                                <td colspan="1"><input class="button" type="submit" name="submit" value="修改購物車"></td>
                                <td colspan="2"><input class="button" type="submit" name="submit" value="我要結帳"></td>
                            </tr>
                        </tfoot>
                    </table>
                </form>
                <%} else {%>
                <p>購物車內容是空的</p>
                <%}%>
            </div>
        </div>
        <script>
            function gobackShop() {
                location.href = "<%= request.getContextPath()%>/product1.jsp";
            }

//            function checkOut(){
//                location.href = "<%= request.getContextPath()%>/member/check_out.jsp";
//            }

        </script>
    </body>
</html>
