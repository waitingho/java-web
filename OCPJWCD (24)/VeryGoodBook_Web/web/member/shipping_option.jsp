<%-- 
    Document   : shipping_option
    Created on : 2018/3/26, 下午 04:52:35
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.ShippingType"%>
<%@page import="uuu.vgb.entity.PaymentType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String pType = request.getParameter("pType");
    PaymentType paymentType = null;
    if(pType!=null){
        try{
            paymentType = PaymentType.valueOf(pType);
        }catch(Exception ex){}
        
        if(paymentType!=null){
            for(ShippingType sType:paymentType.getShippingTypeArray()){
%>
        <option value="<%= sType.name() %>"><%=sType%></option>
<%
            }
        }
    }
%>
