<%-- 
    Document   : orders_history
    Created on : 2018/4/10, 下午 04:36:02
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.OrderItem"%>
<%@page import="uuu.vgb.entity.PaymentType"%>
<%@page import="uuu.vgb.entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="uuu.vgb.service.OrderService"%>
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
%>
<!DOCTYPE html>
<html>
    <head>
        <title>歷史訂單</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
      <link rel="stylesheet" type="text/css" href="../fancybox/jquery.fancybox.min.css">
        <script src="../fancybox/jquery.fancybox.min.js"></script>
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

            .article{
                /*background:#FFF0F5;*/
                float: left;
                min-height: 75vh;
                width:75%;
                border: 1px solid black;
            }
            <%-----------------------------最右邊難快-----------------------------%>
            .aside{
                float:right;
                width: 12%;
                /*background: pink;*/
            }
            .table_history{
                /*border-collapse: collapse;*/
                /*width: 100%;*/
                width: 75%;
                margin: auto;
            }
           .table_history td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            /*tr:hover {background-color:#e7f3fe;}*/
          .table_history tbody tr:nth-child(even) {background-color: #e7f3fe;}
          .table_history tbody tr:nth-child(odd) {background-color: #FFF0F5;}
            <%-----------------------------查閱那顆按鈕-----------------------------%>
            .button {
                padding: 5px ;
                text-align: center;
                text-decoration: none;
                outline: none;
                background-color: #FFEBCD;
                border: none;
                border-radius: 10px;
                width: 100%;
            }
            .button:hover {background-color:#FFE4B5}
        </style>
    </head>
    <body>
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
                <a href="/HeartPrint/member/update.jsp">Settings</a>|
                <a href="#">order</a>|
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

        <br><br><br>

        <div class="section" >
            <div  class="sidenav">
                <a href="/HeartPrint/product1.jsp" class="about">全部商品</a>
                <a href="/HeartPrint/product1.jsp?style=house" class="blog">禮物盒</a>
                <a href="/HeartPrint/product1.jsp?style=card" class="projects">浪漫卡片</a>
                <a href="/HeartPrint/product1.jsp?style=cute" class="contact">可愛小物</a>
            </div>
        </div>
        <%
            OrderService service = new OrderService();
            List<Order> list = service.getOrdersByCustomerId(member.getId());
        %>
        <div class="article">  <%if (list != null && list.size() > 0) {%>    
            <table class="table_history">
                <caption>歷史訂單</caption>
                <thead>
                    <tr>
                        <th>訂單號碼</th>
                        <th>訂單日期</th>
                        <th>合計</th>
                        <th>訂單狀態</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <% for (Order order : list) {%>
                    <tr>
                        <td><%= order.getId()%></td> 
                        <td><%= order.getOrderTime()%></td> 
                        <td><%= Math.ceil(order.getTotalAmount() + order.getPaymentFee() + order.getShippingFee())%></td>
                        <td><%= order.getStatus()%></td>
                        <td>
                                  
                         <a href="javascript: getOrderDetails('<%= String.format("%d", order.getId())%>')">
                                <input class="button" type='button' value="查閱" >
                            </a>

                            
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

            <%} else {%>
            <p>查無歷史訂單!</p>
            <%}%>
        </div>
        <div class="aside" ></div>
        <br><br><br>
        <div id="fialog" style="width:50%;" ></div>
        <script>
            function getOrderDetails(orderId) {
                alert("訂單id:" + orderId);
                $.ajax({
                    url: "order_details_ajax.jsp?orderId=" + orderId,
                    method: 'GET'
                }).done(getProductDetailDoneHandler);
            }
            function getProductDetailDoneHandler(result, textStatus, jqXHR) {
//                alert(result);
//                console.log(result);
                $("#fialog").html(result);
                $.fancybox.open({
                    src: '#fialog',
                    type: 'inline'
                });

            }
        </script>        
    </body>
</html>
