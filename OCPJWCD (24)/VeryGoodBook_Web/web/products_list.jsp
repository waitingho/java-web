<%-- 
    Document   : products_list
    Created on : 2018/3/20, 下午 01:33:58
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>產品清單</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
        <link rel="stylesheet" type="text/css" href="fancybox/jquery.fancybox.min.css">
        <script src="fancybox/jquery.fancybox.min.js"></script>
        <style>
            #products_list>li{
                /*display:list-item;*/
                display: inline-table;
                width: 250px; height: 250px;
                margin: 10px 5px;
                box-shadow: 1px 1px 2px gray
            }

            #products_list h4{
                font-size: smaller;text-align: center
            }

            .product_price{
                font-size: smaller; padding: 0 10px;
            }   
        </style>
        <script>
            function refreshProductImg(target) {
                $(target).attr("src", "<%=request.getContextPath()%>/images/product.png");
            }

            function getProductDetail(productId) {
                //送出同步的GET請求
//                location.href="product.jsp?productId="+productId;

                //送出非同步的GET請求(ajax)
                $.ajax({
                    url: "product_ajax.jsp?productId=" + productId,
                    method: 'GET'
                }).done(getProductDetailDoneHandler);
            }

            function getProductDetailDoneHandler(result, textStatus, jqXHR) {
                //alert(result);
//                console.log(result);
                $("#dialog").html(result);
                $.fancybox.open({
                    src: '#dialog',
                    type: 'inline',
                    opts: {caption: '產品明細'
//                            afterShow: function (instance, current) {
//                                console.info('done!');
//                            }
                    }
                });
            }
        </script>        
    </head>
    <% //controller
        String search = request.getParameter("search");
        String type = request.getParameter("type");
        ProductService service = new ProductService();
        List<Product> list = null;

        if ((search == null || search.length() == 0) && (type == null || type.length() == 0)) {
            list = service.getAllProducts();
        } else {
            list = service.getProductsByNameAndType(search, type);
        }
    %>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" value="產品清單" />            
        </jsp:include>
        <div id='dialog'></div>
        <div class='article'>
            <form method="get">
                <input type="search" value="${param.search}" name="search" placeholder="請輸入產品部分名稱...." style="min-width:40ex;width:65%">
                <select name="type">
                    <option value="">全部商品</option>
                    <option value="Book">書籍</option>
                    <option value="Product">一般商品</option>
                    <option value="Outlet">折價品</option>                    
                </select>
                <input type="submit" value="搜尋">
            </form>
            <% if (list != null && list.size() > 0) { %>
            <ul id="products_list">      
                <% for (Product p : list) {%>
                <li>
                    <div style='width:120px;margin:auto'>
                        <a href="javascript: getProductDetail('<%= String.format("%d", p.getId())%>')">
                            <img style='width:120px;' src='<%= p.getPhotoUrl()%>' onerror="refreshProductImg(this)">
                        </a>    
                    </div>
                    <h4><%= p.getName()%></h4>
                    <div class='product_price'>
                        定價：<%= p instanceof Outlet ? ((Outlet) p).getListPrice() : p.getUnitPrice()%>元<br>
                        <% if (p instanceof Outlet) {%>
                        優惠價：<%= ((Outlet) p).getDiscountString()%> <%= p.getUnitPrice()%>元
                        <%}%>
                    </div>
                </li>    
                <% } %>
            </ul>
            <%} else {%>
            查無產品資料!
            <%}%>
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
