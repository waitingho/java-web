<%@page import="java.util.Arrays"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="uuu.vgb.entity.Book"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%
        String productId = request.getParameter("productId");
        Product p = null;
        ProductService service = new ProductService();
        if (productId != null && productId.matches("\\d+")) {
            p = service.getProduct(Integer.parseInt(productId));
        }
    %>
            <div>
                <%if(p!=null){%>
                    <div style="width:40%;float:left;min-width: 320px">
                        <img src='<%= p.getPhotoUrl() %>'>
                    </div>
                    <div style="width:50%;float:left;min-width: 300px">
                        <h3><%= p.getName() %></h3>
                        <p>
                            <% if(p instanceof Book){
                               Book book = (Book)p; 
                            %>
                            作者： <%= book.getAuthors()!=null?Arrays.toString(book.getAuthors()).substring(1,Arrays.toString(book.getAuthors()).length()-1):"" %><br>
                            出版社：<a href='#'><%= book.getPublisher() %></a><br>
                            出版日期：<%= book.getPublishDate() %><br>
                            語言：<%= book.getLanguage()%><br>
                            <%}%>
                            <%if(p instanceof Outlet){%>
                                定價：<span><%= ((Outlet)p).getListPrice() %>元</span><br>
                            <%}%>
                            優惠價：<%= p instanceof Outlet?((Outlet)p).getDiscountString():""%>
                                        <%= p.getUnitPrice() %>元<br>
                            
                        </p>
                    </div>
                    <div style="clear: both;width:90%;margin: auto">
                        <hr>
                        <div>內容簡介<br>
                            <p><%=p.getDescription() %></p>
                        </div>
                    </div>
                <%}else{%>
                    <p>查無此代號<%= productId!=null ? "("+productId+")":"" %>的商品明細</p>
                <%}%>
            </div>
        
