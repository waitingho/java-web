<%-- 
    Document   : orders_history
    Created on : 2018/4/2, 下午 02:31:51
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.PaymentType"%>
<%@page import="uuu.vgb.entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="uuu.vgb.service.OrderService"%>
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
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="歷史訂單" />            
        </jsp:include>        
        <%
            OrderService service = new OrderService();
            List<Order> list = service.getOrdersByCustomerId(member.getId());            
        %>
        <div class="article">
        <%if (list!=null && list.size()>0){%>    
        <table style="width: 75%;margin: auto">
            <caption>歷史訂單</caption>
            <thead>
                <tr>
                    <th>No.</th>
                    <th>訂購時間</th>
                    <th>付款方式</th>
                    <th>貨運方式</th>
                    <th>總金額</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <% for(Order order:list) { %>
                <tr>
                    <td><%= order.getId() %></td> 
                    <td><%= order.getOrderTime()%></td> 
                    <td><%= order.getPaymentType()%> 
                        <% if(order.getStatus()==0 && order.getPaymentType()==PaymentType.ATM){%>
                        <a href="paid.jsp?orderId=<%=order.getId()%>">通知已匯款</a>
                        <%}%>
                    </td> 
                    <td><%= order.getShippingType()%></td> 
                    <td><%= Math.ceil(order.getTotalAmount() + order.getPaymentFee() + order.getShippingFee()) %></td>
                    <td><a href="order_details.jsp?orderId=<%=order.getId()%>">檢視明細</a> </td>                        
                </tr>
                <%}%>
            </tbody>
        </table>
            
        <%}else{%>
            <p>查無歷史訂單!</p>
        <%}%>
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>

