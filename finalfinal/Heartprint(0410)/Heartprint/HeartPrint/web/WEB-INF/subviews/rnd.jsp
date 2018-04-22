

<%@page import="uuu.vgb.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@page import="uuu.vgb.entity.Customer" contentType="text/html" pageEncoding="UTF-8"%>
<% //controller
//    String rnd = request.getParameter("productId");
    ProductService service = new ProductService();
    List<Product> list = null;

    list = service.getProductByRnd();

%>
<style>
    .inartical{
        margin: 5% 15% ;
        float:left;
        width:70%;
        /*border:1px solid black;*/
    }
    .my_list li{
        /*background: orange;*/
        display: inline-block;
        width:250px;
        height: 300px;
        margin:10px 25px;
        box-shadow: 1px 1px 2px gray;
        overflow: hidden;
        border-radius: 10px;
    }
    .container {
        position: relative;
        width: 250px;
        max-width: 300px;
    }
    .my_list li img{
        display: block;
        width: 100%;
        height: 190px;
        /*border-radius: 50%;*/
    }
    <%---------------------------------透明加入購物車-----------------------------%>
    .overlay {
        border: none;
        outline: none;
        position: absolute; 
        bottom: 0; 
        background: rgb(0, 0, 0);
        background: rgba(0, 0, 0, 0.5); /* Black see-through */
        color: #f1f1f1; 
        width: 100%;
        transition: 1s ease;
        opacity:0;
        color: white;
        font-size: 20px;
        padding: 10px 0 10px 0;
        text-align: center;
    }
    .container:hover .overlay {
        opacity: 1;
    }

    .my_list h4{
        font-size: smaller;
        text_align:center;
    }
    .my_list_img:hover.overlay {
        opacity: 1;
    }
    #middle_cart{
        display:none;  
    }
    .overlay input{
        width:100%;
        padding: 10px 0 10px 0;
        background: rgba(0, 0, 0, 0.2);
        color: white;
        border: none;
        font-size: 20px;
        text-decoration: none;
        outline: none;
    }
</style>

<div class="inartical">
    <% if (list != null) {%>
    <ul class="my_list">
        
        <h2>等你來加購哦...</h2><hr>
        <% for (Product p : list) {%>
        
        <li>
            <div  class="container">
                <a href="javascript: getProductDetail('<%= String.format("%d", p.getId())%>')">
                    <img class="my_list_img"src="<%= p.getPhotoUrl()%>" >
                </a>
                <div class="overlay"><input onclick="addCart(<%= p.getId()%>)" type='submit' value='加入購物車'></div>
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
<script>
    function getProductDetail(productId) {
        //送出同步的GET請求
        location.href = "product_detail2.jsp?productId=" + productId;
//                $.ajax({
//                    url: "product_detail2_ajax.jsp?productId=" + productId,
//                    method: 'GET'
//                })
    }

</script>
<script type="text/javascript">
    function addCart(productId) {
        alert('順利加入購物車了喔');
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
        if ($("#total_quantity")) {
            $("#total_quantity").text(result);
        } else {
            alert(result)
        }
    }

</script>