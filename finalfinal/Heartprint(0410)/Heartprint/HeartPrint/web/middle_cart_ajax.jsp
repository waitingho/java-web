<%-- 
    Document   : middle_cart_ajax
    Created on : 2018/4/3, 上午 10:09:14
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    
/*    .album{
        margin:0 0 0 10%;
        width:490px;
        height:610px;
        float: left;
                        border:1px solid gray;
        padding:10px;
        background:pink;
        border-radius: 20px;
        box-shadow:  0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19), 0 8px 30px 0 rgba(0, 0, 0, 0.18);
    }*/
    .mainPic{
        width:300px;
        height:300px;
        border-radius: 50%;
        padding:2px 2px 2px ;
        background:white;
    }

    .smallPic{
        width:60px;
        height:60px;
        padding:2px;
        background:white;
        margin:10px 3px;
        border-radius: 50%;
    }
    
    .select{
        background:#6DD0CD;
    }
    <%-----------------------------商品價格CSS-----------------------------%>
    .product_title{
        margin:0 0 0 10%;
        float: left;
        /*border:1px solid black;*/
    }
    .button {
        padding: 10px ;
        text-align: center;
        text-decoration: none;
        outline: none;
        background-color: #FFF0F5;
        border: none;
        border-radius: 10px;
        width: 100%;
    }
    .button:hover {background-color:#e7f3fe}
</style>

<%
    //        Object member = session.getAttribute("member");
    String productId = request.getParameter("productId");
    Product p = null;
    ProductService service = new ProductService();
    if (productId != null && productId.matches("\\d+")) {
        p = service.getProduct(Integer.parseInt(productId));
    }
%>
<div >
    <%if (p != null) {%>
    <div class="album">

        <img class="mainPic" src='<%= p.getPhotoUrl()%>'>
        <img src="<%= p.getPhotoUrl()%>" class="smallPic"/>
        <img src="<%= p.getPhotoUrl2()%>" class="smallPic"/>
        <img src="<%= p.getPhotoUrl3()%>" class="smallPic"/>
        <img src="<%= p.getPhotoUrl4()%>" class="smallPic"/>
    </div>
    <div class="product_title" >
        <div class="product_titl_title"><h1><%= p.getName()%></h1></div>
        <div class="product_titl_price"> 
            <%if (p instanceof Outlet) {%>
            定價：<span><%= ((Outlet) p).getListPrice()%>元</span>
            <%}%>
            
            優惠價：<%= p instanceof Outlet ? ((Outlet) p).getDiscountString() : ""%>
            <%=  Math.ceil(p.getUnitPrice())%>元
        </div><br>
        <input type='number' value='1' min="1" max="10" id='quantity'>
        <br><br>
        <input onclick="addCart(<%= p.getId()%>)" class="button" type='submit' value='加入購物車'>
    </div>
    <%} else {%>
    <p>查無此代號<%= productId != null ? "(" + productId + ")" : ""%>的商品明細</p>
    <%}%>
</div>

<script type="text/javascript">
    $(document).on("click", ".smallPic", clickHandler);
    $(".smallPic:first").addClass("select");
    
    function clickHandler() {
        var image = $(this).attr("src");
        $(".mainPic").attr("src", image);
        $(".smallPic").removeClass("select");
        $(this).addClass("select");
    }
</script>
 <script type="text/javascript">
function addCart(productId) {
                alert('順利加入購物車了喔');
                //location.href='product1.jsp';
////                同步請求
//                location.href = "add_cart.do?quantity=" + $("#quantity").val() + "&productId=" + productId;
//
//            }
                $.ajax({
                    url: "add_cart_ajax.do?quantity="
                            + $("#quantity").val() + "&productId=" + productId,
                    method: "GET"
                }).done(addCartDoneHandler);
            }
            function addCartDoneHandler(result) {
                console.log(arguments[0]);
                location.href='product1.jsp';
//                if ($("#total_quantity")) {
//                    $("#total_quantity").text(result);
//                } else {
//                    alert(result);
//                }
            }

        </script>
        
