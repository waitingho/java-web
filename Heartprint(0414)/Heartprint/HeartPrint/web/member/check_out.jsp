<%-- 
    Document   : check_out
    Created on : 2018/4/9, 上午 10:33:43
    Author     : Administrator
--%>
<%@page import="uuu.vgb.entity.ShippingType"%>
<%@page import="uuu.vgb.entity.PaymentType"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.CartItem"%>
<%@page import="uuu.vgb.entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String uri = request.getRequestURI(); // hp/member/check_out.jsp
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
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
        <title>結帳</title>
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
            <%---------------------------------中間那塊--------------------------------%>
            .article{
                float: left;
                width:40%;
                min-height: 60vh;
                /*background:green;*/
                border-radius: 10px;
            }
            .article_in{
                text-align:center;
            }
            table{
                /*border-collapse: collapse;*/
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
     <%---------------------------------右邊那塊--------------------------------%>
            .aside{
                float:right; 
                width: 30%;
                border: 1px solid #BFBFBF;
            }
            .accordion { 
                /*background-color: #FFF0F5;*/
                /*color: #444;*/
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
                margin-top:5px;
            }

            .active:after {
                content: "\2227";
            }
                 <%---------------------------------聯絡人那塊--------------------------------%>
            .panel {
                
                padding: 0 18px;
                background-color: #e7f3fe;
                max-height: 0;
                overflow: hidden;
                transition: max-height 0.2s ease-out;
            }
            .panelll{
                /*border-collapse: collapse;*/
                min-width:50%;
                float:left;
                /*margin:0 auto;*/
                /*background-color: pink;*/
                
            }
            .panelll input{
                border-radius: 10px;
                outline: none;
                padding: 10px;
                margin:5px;
            }
        </style>
    </head>
    <body>
        <div id="fiexd-header" >
            <div class="inside">

                <a  href="/HeartPrint/member/cart.jsp" >Cart</a> |
                <%                    if (member == null) {
                %>
                <a href="/HeartPrint/login.jsp">Login</a> |
                <a href="/HeartPrint/register.jsp">Register</a> 
                <%
                } else {
                %>
                <a href="/HeartPrint/logout.do">Logout</a> |
                <a href="/HeartPrint/member/update.jsp">Settings</a> |
                <a href="/HeartPrint/member/orders_history.jsp">order</a> |
                
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
                <form method="POST" action="check_out.do">
                    <button class="accordion" style="background-color: #FFEBCD;border-left: 6px solid #FFE4B5;"><h2>聯絡人資訊</h2></button>
                    <div class="panel">
                        <div class="panelll">
                            <legend >訂購人:</legend>
                            <lable>姓名:</lable><input value="<%= member.getName()%>" readonly><br>
                            <lable>電郵:</lable><input value="<%= member.getEmail()%>" readonly><br>
                            <lable>電話:</lable><input value="${sessionScope.member.phone}" readonly><br>
                            <lable>地址:</lable><input value="${sessionScope.member.address}" readonly><br>
                        </div>
                        <div class="panelll" >
                            <legend>收件人:<a href="javascript: copyData()">同訂購人</a></legend>
                            <lable>姓名:</lable><input id="name" name="name" value="" required><br>
                            <lable>電郵:</lable><input id="email" name="email" value="" required><br>
                            <lable>電話:</lable><input id="phone" name="phone" value="" required><br>
                            <lable>地址:</lable><input id="addr" name="addr" value="" required><br>
                        </div>
                    </div>
                    <br><br>
                    <table>
                        <tbody>
                            <tr>
                                <td>名稱</td>
                                <td>定價</td>
                                <td>折扣</td>
                                <td>售價</td>
                                <td>數量</td>

                            </tr>


                            <% for (CartItem item : cart.getCartItemSet()) {%>
                            <tr>
                                <td>
                                    <img src="<%= item.getProduct().getPhotoUrl()%>" class="table_img">
                                    <%= item.getProduct().getName()%></td>

                                <td><%= item.getProduct() instanceof Outlet ? ((Outlet) item.getProduct()).getListPrice() : ""%></td>
                                <td><%= item.getProduct() instanceof Outlet ? ((Outlet) item.getProduct()).getDiscountString() : ""%></td>
                                <td><%=  Math.ceil(item.getProduct().getUnitPrice())%></td>
                                <td><%= cart.getQuantity(item)%></td>
                            </tr>
                            <%}%>
                            <tr>
                                <td colspan="5">

                                    <div style="float: right">
                                        <label>貨運方式:</label>
                                        <select id="shippingType" name="shippingType" required onchange="getFee()">
                                            <option value="">請選擇...</option>
                                        </select>                                    
                                    </div>
                                    <div style="float: right">
                                        <label>付款方式:</label>
                                        <select id="paymentType" name="paymentType" 
                                                required onchange="createShippingOption()">
                                            <option value="">請選擇...</option>
                                            <% for (PaymentType pType : PaymentType.values()) {%>
                                            <option value="<%=pType.name()%>"><%= pType%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr class="noborder">
                                <td colspan="5" style="text-align: right">購買了<%= cart.size()%>項商品，共<%= cart.getTotalQuantity()%>件。總金額: 
                                    <span id="totalAmount" ><%= Math.ceil(cart.getTotalAmount())%></span></td>
                            </tr>       
                            <tr class="noborder">                            
                                <td colspan="5" style="text-align: right">總金額(含手續費): 
                                    <span id="totalAmountWithFee"><%=Math.ceil(cart.getTotalAmount())%></span>元</td>
                            </tr>  
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="2"><input class="button" type='button' value="回到賣場" onclick="goBackShop()"></td>
                                <td colspan="1"><input class="button" type='button' value="回到購物車" onclick="goBackCart()"></td>
                                <td colspan="2"><input class="button" type='submit' name="submit" value="確定結帳"></td>
                            </tr>                                    
                        </tfoot>
                    </table>                
                </form>
                <%} else {%>
                <p>購物車內容是空的</p>
                <%}%>            
            </div>
            </div>
             <div class="footer" style="clear:both; color: gray">
            <hr>
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>
            </div>
            <script>
                function copyData() {
                    $("#name").val('<%=member.getName()%>');
                    $("#email").val('<%=member.getEmail()%>');
                    $("#phone").val('${sessionScope.member.phone}');
                    $("#addr").val('<%=member.getAddress()%>');
                }
            </script>
            <script>
                function goBackShop() {
                    location.href = "<%= request.getContextPath()%>/product1.jsp";
                }

                function goBackCart() {
                    location.href = "<%= request.getContextPath()%>/member/cart.jsp";
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
            <script>
                function createShippingOption() {
                    console.log($("#paymentType").val());
                    getFee();
                    $.ajax({
                        url: "shipping_option.jsp?pType=" + $("#paymentType").val(),
                        method: "GET"
                    }).done(creatShippingOptionDoneHandler);
                }
                function creatShippingOptionDoneHandler(result) {
                    $("#shippingType").empty();
//                    $("#shippingType").append('<option value="">請選擇...</option>');
                    $("#shippingType").append(result);
                }
                function getFee() {
                    var pOptionText = $("#paymentType option:selected").text().split('-');
                    console.log(pOptionText);
                    var pFee = 0;
                    if (pOptionText.length > 1) {
                        pFee = pareInt(pOptionText[1].substring(0, pOptionText[1].length - 1))
                        console.log(pFee);
                    }
                    var sOptionText = $("#shippingType option:selected").text().split('-');
                    console.log(sOptionText);
                    var sFee = 0;
                    if (sOptionText.length > 1) {
                        sFee = parseInt(sOptionText[1].substring(0, sOptionText[1].length - 1));
                        console.log(sFee);
                    }
                    $("#totalAmountWithFee").text(parseFloat($("#totalAmount").text()) + sFee + pFee);
                }
            </script>
    </body>

</html>
