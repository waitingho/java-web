<%-- 
    Document   : small_cart_ajax
    Created on : 2018/3/26, 上午 10:16:26
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
    Cart cart = (Cart)session.getAttribute("cart");
    if (cart != null) {
        int totalQ = cart.getTotalQuantity();    
%>
 <%=totalQ%>
<%}%>