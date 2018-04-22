<%-- 
    Document   : check_out
    Created on : 2018/3/26, 下午 01:37:04
    Author     : Administrator
--%>
<%@page import="uuu.vgb.entity.ShippingType"%>
<%@page import="uuu.vgb.entity.PaymentType"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.CartItem"%>
<%@page import="uuu.vgb.entity.Cart"%>
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

    Cart cart = (Cart) session.getAttribute("cart");
    if (cart != null) {
        cart.setMember(member);
    }
%>
<!DOCTYPE html>
<html>
    <head>        
        <title>結帳</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
        <script>
            function goBackShop() {
                location.href = "<%= request.getContextPath()%>/products_list.jsp";
            }

            function goBackCart() {
                location.href = "<%= request.getContextPath()%>/member/cart.jsp";
            }

        </script>        
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="結帳作業" />            
        </jsp:include>
        <div class='article'>
            <% if (cart != null && cart.size() > 0) {%>
            ${requestScopr.errors}
            <form method="POST" action="check_out.do">
                <table border='1' cellspacing='1' cellpadding='3' style='width:75%;margin: auto'>  
                    <caption>結帳明細</caption>
                    <thead>
                        <tr>
                            <th>名 稱</th>
                            <th>顏 色</th>
                            <th>定 價</th>
                            <th>折 扣</th>
                            <th>售 價</th>
                            <th>數 量</th>                            
                        </tr>
                    </thead>                    
                    <tbody>
                        <% for (CartItem item : cart.getCartItemSet()) {%>
                        <tr>
                            <td><%= item.getProduct().getName()%></td>
                            <td></td>                            
                            <td><%= item.getProduct() instanceof Outlet ? ((Outlet) item.getProduct()).getListPrice() : ""%></td>
                            <td><%= item.getProduct() instanceof Outlet ? ((Outlet) item.getProduct()).getDiscountString() : ""%></td>                            
                            <td><%= item.getProduct().getUnitPrice()%></td>
                            <td><%= cart.getQuantity(item)%></td>
                        </tr>                       
                        <%}%>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="6">
                                <div style="width:50%;float: left">
                                    <label>付款方式:</label>
                                    <select id="paymentType" name="paymentType" 
                                            required onchange="createShippingOption()">
                                        <option value="">請選擇...</option>
                                        <% for (PaymentType pType : PaymentType.values()) {%>
                                        <option value="<%=pType.name()%>"><%= pType%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div style="width:50%;float: left">
                                    <label>貨運方式:</label>
                                    <select id="shippingType" name="shippingType" required onchange="getFee()">
                                        <option value="">請選擇...</option>
                                    </select>                                    
                                </div>
                                <script>
                                    function createShippingOption() {
                                        console.log($("#paymentType").val());
                                        getFee();
                                        $.ajax({
                                            url: "shipping_option.jsp?pType=" + $("#paymentType").val(),
                                            method: "GET"
                                        }).done(createShippingOptionDoneHandler);
                                    }

                                    function createShippingOptionDoneHandler(result) {
                                        //console.log(result);
                                        $("#shippingType").empty();
                                        $("#shippingType").append('<option value="">請選擇...</option>');
                                        $("#shippingType").append(result);
                                    }

                                    function getFee() {
                                        //console.log($( "#paymentType option:selected" ).text());
                                        var pOptionText = $("#paymentType option:selected").text().split('-');
                                        console.log(pOptionText);
                                        var pFee = 0;
                                        if (pOptionText.length > 1) {
                                            pFee = parseInt(pOptionText[1].substring(0, pOptionText[1].length - 1));
                                            console.log(pFee);
                                        }

                                        //console.log($( "#shippingType option:selected" ).text());
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
                            </td>
                        </tr>
                        <tr class="noborder">
                            <td colspan="4" style="text-align: right">購買了<%= cart.size()%>項商品，共<%= cart.getTotalQuantity()%>件。總金額: </td>
                            <td colspan="2"><span id="totalAmount"><%= cart.getTotalAmount()%></span>元</td>
                        </tr>                                    
                        <tr class="noborder">                            
                            <td colspan="4" style="text-align: right">總金額(含手續費): </td>
                            <td colspan="2"><span id="totalAmountWithFee"><%= cart.getTotalAmount()%></span>元</td>
                        </tr>                                    
                        <tr>
                            <td colspan="6">
                                <fieldset style="width:45%;float:left;">
                                    <legend>訂購人:</legend>
                                    <lable>姓名:</lable><input value="<%= member.getName()%>" readonly><br>
                                    <lable>電郵:</lable><input value="<%= member.getEmail()%>" readonly><br>
                                    <lable>電話:</lable><input value="${sessionScope.member.phone}" readonly><br>
                                    <lable>地址:</lable><input value="${sessionScope.member.address}" readonly><br>
                                </fieldset>
                                <fieldset style="width:45%;float:left">
                                    <legend>收件人:<a href="javascript: copyData()">同訂購人</a></legend>
                                    <lable>姓名:</lable><input id="name" name="name" value="" required><br>
                                    <lable>電郵:</lable><input id="email" name="email" value="" required><br>
                                    <lable>電話:</lable><input id="phone" name="phone" value="" required><br>
                                    <lable>地址:</lable><input id="addr" name="addr" value="" required><br>
                                </fieldset>
                                <script>
                                    function copyData() {
                                        $("#name").val('<%=member.getName()%>');
                                        $("#email").val('<%=member.getEmail()%>');
                                        $("#phone").val('${sessionScope.member.phone}');
                                        $("#addr").val('${sessionScope.member.address}');
                                    }
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4"><input type='button' value="回到賣場" onclick="goBackShop()">
                                <input type='button' value="回到購物車" onclick="goBackCart()"></td>
                            <td colspan="2"><input type='submit' name="submit" value="確定結帳"></td>
                        </tr>                                    
                    </tfoot>
                </table>                
            </form>
            <%} else {%>
            <p>購物車內容是空的</p>
            <%}%>            
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
