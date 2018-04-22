<%-- 
    Document   : check_out
    Created on : 2018/4/9, 上午 10:33:43
    Author     : Administrator
--%>
<%@page import="uuu.vgb.entity.VIP"%>
<%@page import="uuu.vgb.entity.ShippingType"%>
<%@page import="uuu.vgb.entity.PaymentType"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.CartItem"%>
<%@page import="uuu.vgb.entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    java.net.InetAddress theip = java.net.InetAddress.getLocalHost();
    String theMyIp = theip.getHostAddress();

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
<html>
    <head>
        <link rel="icon" type="image/png" href="/HeartPrint/image/logo1616.png" />
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
            .header{
                width:100%;
                float:left;
            }
            .header a{
                display: block;
                width:394px;
                margin:50px auto;
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
                font-family: 微軟正黑體;
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
                font-family: 微軟正黑體;
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
                font-family: 微軟正黑體;
            }
            /*            .accordion:after {
                            content: '\2228';
                            color: #777;
                            font-weight: bold;
                            float: right;
                            margin-left: 5px;
                            margin-top:5px;
                            font-family: 微軟正黑體;
                        }
                        .active:after {
                            content: "\2227";
                        }*/
            <%---------------------------------聯絡人那塊--------------------------------%>
            /*            .panel {
            
                            padding: 0 18px;
                            background-color: #e7f3fe;
                            max-height: 0;
                            overflow: hidden;
                            transition: max-height 0.2s ease-out;
                            font-family: 微軟正黑體;
                        }*/
            .panel{
                /*display:block;*/
                /*border-collapse: collapse;*/
                /*min-width:50%;*/
                float:left;
                margin:0 50px;
                /*background-color: pink;*/
                font-family: 微軟正黑體;
                  /*margin-right:0px;*/
                  /*padding-right: 0px;*/
            }
            .panel input{
                border-radius: 10px;
                outline: none;
                padding: 10px;
                margin:5px;
                font-family: 微軟正黑體;
            }
/*             .panell{
                border-collapse: collapse;
                min-width:50%;
                float:left;
                margin:0 auto;
                background-color: pink;
                font-family: 微軟正黑體;
              
            }
            .panell input{
                border-radius: 10px;
                outline: none;
                padding: 10px;
                margin:5px;
                font-family: 微軟正黑體;
            }*/
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
                ${requestScopr.errors}
                <form method="POST" action="check_out.do" id="cartForm">
                    <table>
                        <tbody>
                            <tr>
                                <td>名稱</td>
                                <td>定價</td>
                                <td>折扣</td>
                                <td>售價</td>
                                <td>數量</td>
                            </tr> <% for (CartItem item : cart.getCartItemSet()) {%>
                            <tr>
                                <td>
                                    <a href="<%= request.getContextPath()%>/product_detail2.jsp?productId=<%= item.getProduct().getId()%>">
                                        <img src="<%= item.getProduct().getPhotoUrl()%>" class="table_img"></a>
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
                                            <option value="<%=pType.name()%>" <%= pType.name().equals(request.getParameter("paymentType")) ? "selected" : ""%>>
                                                <%= pType%>
                                            </option>
                                            <%}%>
                                        </select>
                                    </div>
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
                                            $("#shippingType").append('<option value="">請選擇...</option>');
                                            $("#shippingType").append(result);
                                        <%if (request.getParameter("shippingType") != null) {%>
                                            $("#shippingType").val('<%=request.getParameter("shippingType")%>');
                                            getFee();
                                            showShippingWay("${param.addr}");
                                        <%}%>
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
                                            showShippingWay();
                                        }
                                        function showShippingWay(addr) {
                                            var shipType = $("#shippingType").val();
                                            if (shipType == "<%= ShippingType.STORE.name()%>") {
                                                $("#addr").prop("readOnly", true);
                                                $("#chooseStore").css("display", "inline");
                                                $("#addr").val(addr ? addr : "");
                                                $("#addr").attr("placeholder", "請選擇門市")
                                            } else {
                                                $("#addr").prop('readOnly', false);
                                                $("#chooseStore").css("display", "none");
                                                $("#addr").val(addr ? addr : "");
                                                $("#addr").attr("placeholder", "請輸入收件地址")
                                            }
                                        }
                                        <%if (request.getParameter("shippingType") != null) {%>
                                        //這段程式只有當CheckOutServlet結帳失敗再回到check_out.jsp時才會出現，是為了把shippingType欄位值帶回畫面用的
                                        $(function () {
                                            createShippingOption();
                                            //                                        alert('<%=request.getParameter("shippingType")%>');                                        
                                        }
                                        );
                                        <%}%>
                                    </script>
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

                            <!--                            <td colspan="5"><button class="accordion" style="background-color: #FFEBCD;border-left: 6px solid #FFE4B5;font-family: 微軟正黑體;"><h2>聯絡人資訊</h2></button>-->



                            <tr>  
                                <td colspan="5" >  
                                    <div class="panel">
                                        <legend >訂購人:</legend>
                                        <lable>姓名:</lable><input type="text" value="<%= member.getName()%>" readonly><br>
                                        <lable>電郵:</lable><input type="text" value="<%= member.getEmail()%>" readonly><br>
                                        <lable>電話:</lable><input type="text" value="${sessionScope.member.phone}" readonly><br>
                                        <lable>地址:</lable><input type="text" value="${sessionScope.member.address}" readonly><br>
                                    </div>
                                
                                
                                   <div class="panel">
                                        <legend>收件人:<a href="javascript: copyData()" style="text-decoration:none;color:gray;">&nbsp;同訂購人</a></legend>
                                        <lable>姓名:</lable><input type="text" id="name" name="name" value="${param.name}" required><br>
                                        <lable>電郵:</lable><input type="text" id="email" name="email" value="${param.email}" required><br>
                                        <lable>電話:</lable><input type="text" id="phone" name="phone" value="${param.phone}" required><br>
                                        <lable>地址:</lable><input type="text" id="addr" name="addr" value="${param.addr}" required>
                                        <!--<input id="chooseStore" type="image" src="/HeartPrint/image/fm.png" value='' title="點我選門市" onclick="goEzShip()" style="display: none;width:50px">-->
                                        <input id="chooseStore" type="button" value='...' title="點我選門市" onclick="goEzShip()" style="display: none;background: #FFF0F5;">
                                    </div> 
                                </td>
                            </tr>


                        </tbody>
                        <script>
                            function copyData() {
                                $("#name").val('<%=member.getName()%>');
                                $("#email").val('<%=member.getEmail()%>');
                                $("#phone").val('${sessionScope.member.phone}');
                                if ($("#shippingType").val() == "<%= ShippingType.HOME.name()%>") {
                                    $("#addr").val('${sessionScope.member.address}');
                                }
                            }
                        </script>
                        <tfoot>
                            <tr>
                                <td colspan="2"><input class="button" type='button' value="回到賣場" onclick="goBackShop()"></td>
                                <td colspan="1"><input class="button" type='button' value="回到購物車" onclick="goBackCart()"></td>
                                <td colspan="2"><input class="button" type='submit' name="submit" value="確定結帳"></td>
                            </tr>                                    
                        </tfoot>
                    </table>                
                </form>
                <script>
                    function goEzShip() {
                        $("#name").val($("#name").val().trim());
                        $("#email").val($("#email").val().trim());
                        $("#phone").val($("#phone").val().trim());
                        $("#addr").val($("#addr").val().trim());
//                        alert($("#ezForm").serialize());
                        $("#webPara").val($("#cartForm").serialize());

//                        alert($("#ezForm").serialize());
                        $("#ezForm").submit();
                    }
                </script>
                <form method="post" name="simulation_from" action="http://map.ezship.com.tw/ezship_map_web.jsp" id="ezForm">
                    <input type="hidden" name="suID"  value="test@vgb.com"> <!-- 業主在 ezShip 使用的帳號, 隨便寫 -->
                    <input type="hidden" name="processID" value="VGB201804230000005"> <!-- 購物網站自行產生之訂單編號, 隨便寫 -->
                    <input type="hidden" name="stCate"  value=""> <!-- 取件門市通路代號 -->            
                    <input type="hidden" name="stCode"  value=""> <!-- 取件門市代號 -->            
                    <input type="hidden" name="rtURL" id="rtURL" value=""><!-- 回傳路徑及程式名稱 -->
                    <input type="hidden" id="webPara" name="webPara" value=""><!-- 網站所需額外判別資料。ezShip 將原值回傳，供網站判別用 -->
                    <script>
                        $("#rtURL").val("<%=request.getProtocol().toLowerCase().substring(0, request.getProtocol().indexOf("/"))%>://<%= theMyIp%>:" + location.port + "/HeartPrint/ez_shop_callback.jsp");
                    </script>
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
            function goBackShop() {
                location.href = "<%= request.getContextPath()%>/product1.jsp";
            }

            function goBackCart() {
                location.href = "<%= request.getContextPath()%>/member/cart.jsp";
            }
        </script>        
        <!--    <script type="text/javascript">
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
            </script> -->


    </body>

</html>
