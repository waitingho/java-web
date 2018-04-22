<%-- 
    Document   : ez_shop
    Created on : 2017/12/21, 下午 03:12:51
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%
    //================================ 接收購物網站所需的各項參數 ==================================    
    String processID = request.getParameter("processID") == null ? "" : request.getParameter("processID");  // 訂單編號
    String stCate = request.getParameter("stCate") == null ? "" : request.getParameter("stCate");  // 超商別
    String stCode = request.getParameter("stCode") == null ? "" : request.getParameter("stCode");  // 門市代碼
    String stName = request.getParameter("stName") == null ? "" : request.getParameter("stName");  // 門市名稱
    String stAddr = request.getParameter("stAddr") == null ? "" : request.getParameter("stAddr");  // 門市地址
    String stTel = request.getParameter("stTel") == null ? "" : request.getParameter("stTel");    // 門市電話
    String webPara = request.getParameter("webPara") == null ? "" : request.getParameter("webPara");  // 網站所需額外判別資料。ezShip 將原值回傳，供網站判別使用。
    String params[] = webPara.split("&");
    System.out.println("params:" + Arrays.toString(params));
    String shippingType=(params.length<1?"":params[0].substring(params[0].indexOf("=")+1));
    String paymentType=(params.length<2?"":params[1].substring(params[1].indexOf("=")+1));    
    String receiverName=(params.length<3?"":params[2].substring(params[2].indexOf("=")+1));
    String receiverEmail=(params.length<4?"":params[3].substring(params[3].indexOf("=")+1));
    String receiverPhone=(params.length<5?"":params[4].substring(params[4].indexOf("=")+1));
%>
<form action="member/check_out.jsp" method="post" id="myForm">
    <input name="processID" type="text" value="<%=processID %>">
    <input name="stCate" type="text" value="<%=stCate %>">
    <input name="stCode" type="text" value="<%=stCode%>">    
    <input name="stName" type="text" value="<%=stName %>">
    <input name="stAddr" type="text" value="<%=stAddr %>">
    <input name="stTel" type="text" value="<%=stTel %>">
    
    <input name="shippingType" type="text" value="<%= shippingType %>">
    <input name="paymentType" type="text" value="<%= paymentType%>">
    <input name="name" type="text" value="<%= java.net.URLDecoder.decode(receiverName, "utf-8")%>">
    <input name="email" type="text" value="<%=java.net.URLDecoder.decode(receiverEmail, "utf-8") %>">
    <input name="phone" type="text" value="<%=receiverPhone %>">
    <input name="addr" type="text" value="<%=stCode%>,<%=stName%>,<%=stAddr%> <%=stTel%>">
    <script>
        document.getElementById("myForm").submit();
    </script>    
</form>

