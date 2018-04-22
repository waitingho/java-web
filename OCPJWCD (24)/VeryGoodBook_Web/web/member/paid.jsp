<%-- 
    Document   : paid
    Created on : 2018/4/2, 下午 05:12:07
    Author     : Administrator
--%>
<%@page import="java.time.LocalDate"%>
<%@page import="uuu.vgb.entity.PaymentType"%>
<%@page import="uuu.vgb.service.OrderService"%>
<%@page import="uuu.vgb.entity.Order"%>
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
        <title>通知已匯款</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="通知已匯款" />            
        </jsp:include>         
        <%
            String orderId = request.getParameter("orderId");
            Order order = null;
            if(orderId!=null && orderId.matches("\\d+")){
                OrderService service = new OrderService();
                order = service.getOrderById(Integer.parseInt(orderId));                
            }
        %>
        <div class="article">
            <% if(order!=null && order.getMember().equals(member)) {
                    if(order.getStatus()==0 && order.getPaymentType()==PaymentType.ATM){%>            
                    <form action="paid.do" method="POST">
                    <p>
                        <label>訂單編號:</label>
                        <input type="text" value="<%= order.getId() %>" readonly name="orderId">
                    </p>
                    <p>
                        <label>匯款金額:</label>
                        <input type="text" required
                               value="<%= Math.ceil(order.getTotalAmount() + order.getPaymentFee() +order.getShippingFee()) %>" name="amount">
                    </p>                    
                    <p>
                        <label>轉帳銀行:</label>
                        <input type="text" value="" name="bank" required>
                    </p>
                    <p>
                        <label>帳號後5碼:</label>
                        <input type="text" value="" name="fiveCode" required>
                    </p>
                    <p>
                        <label>轉帳日期:</label>
                        <input type="date" value="" name="transferDate" min="<%= order.getOrderTime().toLocalDate() %>">
                        <label>時間:</label>
                        <select name="transferTime">
                            <option value="">請選擇...</option>
                            <% for(int i=0;i<23;i+=2) {%>
                            <option value="<%= i%>:00~<%=i+2%>:00"><%= i%>:00~<%=i+2%>:00</option>
                            <% } %>
                        </select>
                    </p>
                    <input type="submit" value="確定">
                </form>
            <%      }else{ %>
                        <p>此訂單無須已匯款通知</p>
            <%      }
               } else { %>
            <% } %>
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
