<%-- 
    Document   : order_details
    Created on : 2018/4/2, 下午 02:33:35
    Author     : Administrator
--%>
<%@page import="uuu.vgb.entity.OrderItem"%>
<%@page import="uuu.vgb.service.OrderService"%>
<%@page import="uuu.vgb.entity.Order"%>
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>訂單明細</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="訂單明細" />            
        </jsp:include>        
        <%
            String orderId = request.getParameter("orderId");
            Order order = null;
            if (orderId != null && orderId.matches("\\d+")) {
                OrderService service = new OrderService();
                order = service.getOrderById(Integer.parseInt(orderId));
            }
        %>
        <div class="article">
            <%if (order != null && order.getMember().equals(member)) {%>
            <p>
                訂單編號: <%= order.getId()%>, 狀態:<%= order.getStatus()%>, 訂購時間: <%= order.getOrderTime()%>,
                消費總金額(含手續費): <%= Math.ceil(order.getTotalAmount() + order.getPaymentFee() + order.getShippingFee()) %>
            </p>
            <div style="width: 35%;min-width:320px;float: left">
                <fieldset>
                    <legend>付款資訊:</legend>
                    付款方式: <%= order.getPaymentType()%>, 手續費: <%=order.getPaymentFee()%><br>
                    付款註記: <%= order.getPaymentNote() == null ? "尚無資料" : order.getPaymentNote()%>
                </fieldset>
                <fieldset>
                    <legend>貨運資訊:</legend>
                    貨運方式: <%= order.getShippingType()%>, 手續費: <%=order.getShippingFee()%><br>
                    貨運註記: <%= order.getShippingNote() == null ? "尚無資料" : order.getShippingNote()%>
                </fieldset>
                <fieldset>
                    <legend>收件人:</legend>
                    姓名: <%=order.getReceiverName()%>, 電話: <%=order.getReceiverPhone()%><br>
                    電郵: <%=order.getReceiverEmail()%><br>
                    地址: <%=order.getShippingAddr()%><br>
                </fieldset>
            </div>
            <div style="width: 55%;min-width:380px;float:right;font-size: smaller;margin-bottom: 10px">
                <table>
                    <caption>訂購明細</caption>
                    <thead>
                        <tr>
                            <th>名稱</th>
                            <th>顏色</th>
                            <th>價格</th>
                            <th>數量</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (OrderItem item : order.getOrderItemSet()) {%>
                        <tr>
                            <td><img src="<%=item.getProduct().getPhotoUrl() %>" style="width:32px;vertical-align:middle">  <%= item.getProduct().getName() %></td>
                            <td><%= item.getColor()==null?"":item.getColor()%></td>
                            <td><%= item.getPrice()%></td>
                            <td><%= item.getQuantity() %></td>
                        </tr>
                        <%}%>
                    </tbody>
                    <tfoot>
                        <tr class="noborder">
                            <td colspan="1" style="text-align: right">消費總金額: </td>
                            <td colspan="3"><span id="totalAmountWithFee"><%= order.getTotalAmount()%></span>元</td>                            
                        </tr>
                    </tfoot>
                </table>
            </div>
            <%} else {%>
            <p>查無此訂單</p>
            <%}%>
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
