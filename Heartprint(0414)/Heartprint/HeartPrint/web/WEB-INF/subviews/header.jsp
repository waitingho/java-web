<%@page import="uuu.vgb.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@page import="uuu.vgb.entity.Customer" contentType="text/html" pageEncoding="UTF-8"%>
        
<% //controller
        String rnd = request.getParameter("rnd");
        
        ProductService service = new ProductService();
        
        List<Product> list = null;
        if(rnd != null) {
            list = service.getProductByRnd();
        }

        
    %>

 <div>
        <% if (list != null && list.size() > 0) {%>
            <ul class="my_list">
                <% for (Product p : list) {%>

                <li>
                    <div  class="container">
                        <a href="javascript: getProductDetail('<%= String.format("%d", p.getId())%>')">
                            <img class="my_list_img"src="<%= p.getPhotoUrl()%>" >
                        </a>

                        <a href="javascript:getMiddleCart('<%= String.format("%d", p.getId())%>') ">    
                            <div class="overlay">加入購物車</div>
                        </a>
                    </div>  
                    <h4 align=center><%= p.getName()%></h4>
                    <h5 align=center>NT$<%= p.getUnitPrice()%></h5>

                </li>
                <% } %>
            </ul>
            <%} else {%>
            查無產品資料!
            <%}%>
        </div>
    
