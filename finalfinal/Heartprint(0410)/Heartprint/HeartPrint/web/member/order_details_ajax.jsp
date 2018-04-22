<%-- 
    Document   : order_details_ajax
    Created on : 2018/4/11, 上午 10:50:47
    Author     : Administrator
--%>


<%@page import="uuu.vgb.entity.Status"%>
<%@page import="uuu.vgb.entity.OrderStatusLog"%>
<%@page import="java.util.List"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page import="uuu.vgb.entity.OrderItem"%>

<%@page import="uuu.vgb.service.OrderService"%>
<%@page import="uuu.vgb.entity.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
    .left{
        /*        float:left;
                width:60%;
                border: 1px solid black;
                min-height: 75vh;
                margin:10px;*/
        padding: 0 18px;
        /*background-color: #e7f3fe;*/
        max-height: 0;
        overflow: hidden;
        transition: max-height 0.2s ease-out;
        font-family: 微軟正黑體;
    }

    .table_product{

        float:left;
        width:100%;
    }
    .table_product td{
        padding:2px;
        text-align: left;
        border-bottom: 2px solid #ddd;
    }
    .table_product tbody tr:nth-child(even) {background-color: #e7f3fe;}
    .table_product tbody tr:nth-child(odd) {background-color: #FFF0F5;}
    .table_img{
        /*float:left;*/
        width:80px;
        height:80px;
        vertical-align:middle ;
        border-radius: 20px;
        padding:5px;
        background:white;
    }
    .accordion { 
        margin-top: 20px;
        /*background-color: #FFF0F5;*/
        /*color: #444;*/
        cursor: pointer;
        /*cursor: auto;*/
        width: 100%;
        /*height:50px;*/
        border: none;
        text-align: center;
        outline: none;
        font-size: 10px;
        transition: 0.4s;
        background-color:#e7f3fe;
        border-left: 6px solid #2196F3;
        border-radius: 5px;
        font-family: 微軟正黑體;

    }

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
    .right{
        /*        float:left;
                width:50%;
                border: 1px solid black;*/
    }
    .man{
        margin:5px;
        background: #FFF0F5;
        border:0;
        border-radius: 5px;
        font-family: 微軟正黑體;
        /*        padding: 5px 10px;*/
    }
    .man legend{
        background: pink;
        border-radius: 5px;
    }
    .payment{
        margin:5px;
        background: #ddffdd;
        border:0;
        border-radius: 5px;
        /*        padding: 5px 10px;*/
    }
    .payment legend{
        background: #4CAF50;
        border-radius: 5px;
    }
    .shipping{
        margin:5px;
        background:#ffffcc;
        border:0;
        border-radius: 5px;
        /*        padding: 5px 10px;*/
    }
    .shipping legend{
        background:#ffeb3b;
        border-radius: 5px;
    }
    .status{display:inline-block;background-color: orange;color:white;
            text-align: center;margin:1em;padding: 2px 10px;border-radius: 5px;font-size: smaller}

</style>
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

<%
    String orderId = request.getParameter("orderId");
    Order order = null;
    List<OrderStatusLog> logList = null;
    if (orderId != null && orderId.matches("\\d+")) {
        System.out.println("orderId = " + orderId);
        OrderService service = new OrderService();
        order = service.getOrderById(Integer.parseInt(orderId));
        System.out.println("order = " + order.getMember().getId().equals(member.getId()));
        if (order != null) {
            logList = service.getOrderStatusLogById(Integer.parseInt(orderId));
        }

    }
%>
<div>
    <div>
        <div class='status'>
            新訂單(處理中)<br><%= order.getOrderTime()%>
        </div>
        <% if (logList != null && logList.size() > 0) {
                for (OrderStatusLog log : logList) {
        %>
        >>>
        <div class='status'>
            <%= Status.values()[log.getNewStatus()].getDescription()%><br><%= log.getUpdateTime()%>
        </div>
        <%}
                    }%>
    </div>
    <button class="accordion" style=""><h2>購物車(<%= order.getTotalQuantity()%>)  合計:<%= Math.ceil(order.getTotalAmount())%>元</button>
    <div class="left">
        <%if (order != null && order.getMember().equals(member)) {%>

        <table class="table_product">
            <tbody>
                <tr>
                    <td>名稱</td>
                    <td>售價</td>
                    <td>數量</td>
                </tr>
                <% for (OrderItem item : order.getOrderItemSet()) {%>
                <tr>
                    <td> <a href="<%= request.getContextPath()%>/product_detail2.jsp?productId=<%= item.getProduct().getId()%>">
                            <img src="<%= item.getProduct().getPhotoUrl()%>" class="table_img"></a><%= item.getProduct().getName()%></td>
<!--                    <td><%--= item.getProduct() instanceof Outlet ? ((Outlet) item.getProduct()).getListPrice() : ""--%></td>
                    <td><%--= item.getProduct() instanceof Outlet ? ((Outlet) item.getProduct()).getDiscountString() : ""--%></td>-->
                    <td><%=  Math.ceil(item.getPrice())%></td>
                    <td><%= item.getQuantity()%></td>
                </tr>
                <%}%>
                <tr >
                    <td colspan="1" style="text-align: right">消費總金額: </td>
                    <td colspan="3"><span id="totalAmountWithFee"><%= Math.ceil(order.getTotalAmount())%></span>元</td>                            
                </tr>
            </tbody>
        </table>
    </div>
    <br>
    <div class="right">
        <fieldset class="man">
            <legend>收件人:</legend>
            姓名: <%=order.getReceiverName()%><br>
            電話: <%=order.getReceiverPhone()%><br>
            電郵: <%=order.getReceiverEmail()%><br>
            地址: <%=order.getShippingAddr()%><br>
        </fieldset>
        <br>
        <fieldset class="payment">
            <legend>付款資訊:</legend>
            付款方式: <%= order.getPaymentType()%><br>
<!--            手續費: <%=order.getPaymentFee()%><br>-->
            付款註記: <%= order.getPaymentNote() == null ? "尚無資料" : order.getPaymentNote()%>
        </fieldset>
        <br>
        <fieldset class="shipping">
            <legend>送貨資訊:</legend>
            貨運方式: <%= order.getShippingType()%><br>
            手續費: <%=order.getShippingFee()%><br>
            貨運註記: <%= order.getShippingNote() == null ? "尚無資料" : order.getShippingNote()%>
        </fieldset>
    </div>
    <%} else {%>
    <p>查無此訂單<%=orderId%></p>
    <%}%>
</div>

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
