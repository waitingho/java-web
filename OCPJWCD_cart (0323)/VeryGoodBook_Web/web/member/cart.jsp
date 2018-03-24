<%-- 
    Document   : cart
    Created on : 2018/3/20, 上午 11:09:35
    Author     : Administrator
--%>

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
    
    Cart cart = (Cart)session.getAttribute("cart");
    if(cart!=null) cart.setMember(member);    
%>
<!DOCTYPE html>
<html>
    <head>        
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
        <script>
            function goBackShop(){
                location.href = "<%= request.getContextPath() %>/products_list.jsp";
            }
            
        </script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="購物車" />            
        </jsp:include>
        <div class='article'>      
            <% if(cart!=null && cart.size()>0) {%>
            <form method="GET" action="update_cart.do">
                <table border='1' cellspacing='1' cellpadding='3' style='width:75%;margin: auto'>  
                    <caption>購物車</caption>
                    <thead>
                        <tr>
                            <th>名 稱</th>
                            <th>顏 色</th>
                            <th>定 價</th>
                            <th>折 扣</th>
                            <th>售 價</th>
                            <th>數 量</th>
                            <th>刪 除</th>
                        </tr>
                    </thead>                    
                    <tbody>
                        <% for(CartItem item:cart.getCartItemSet()) {%>
                        <tr>
                            <td><%= item.getProduct().getName() %></td>
                            <td></td>                            
                            <td><%= item.getProduct() instanceof Outlet?((Outlet)item.getProduct()).getListPrice():"" %></td>
                            <td><%= item.getProduct() instanceof Outlet?((Outlet)item.getProduct()).getDiscountString():""%></td>                            
                            <td><%= item.getProduct().getUnitPrice() %></td>
                            <td><input name='quantity' type='number' min='1' 
                                       max='<%=item.getProduct().getStock()>10?10:item.getProduct().getStock() %>' 
                                       value='<%= cart.getQuantity(item) %>'></td>
                            <td><input name='delete' type='checkbox'></td>
                        </tr>                       
                        <%}%>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2">購買了<%= cart.size() %>項商品，共<%= cart.getTotalQuantity() %>件</td>
                            <td colspan="2">總金額: </td>
                            <td colspan="3"><%= cart.getTotalAmount() %>元</td>
                        </tr>            
                        <tr>
                            <td colspan="4"><input type='button' value="回到賣場" onclick="goBackShop()"></td>
                            <td colspan="1"><input type='submit' value="修改購物車"></td>
                            <td colspan="2"><input type='button' value="我要結帳"></td>
                        </tr>                                    
                    </tfoot>
                </table>                
            </form>
            <%}else{%>
            <p>購物車內容是空的</p>
            <%}%>
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
