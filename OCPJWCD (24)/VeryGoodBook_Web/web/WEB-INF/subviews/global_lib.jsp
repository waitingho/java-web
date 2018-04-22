<%-- 
    Document   : global_lib
    Created on : 2018/3/19, 上午 09:33:10
    Author     : Administrator
--%>

<%@page import="uuu.vgb.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<%= request.getContextPath()%>/style/vgb.css" rel="stylesheet" type="text/css"/>
<style>
    table, td, th{border: 1px solid gray; border-collapse: collapse}
    .noborder td{border: 0;}
</style>
<script
    src="https://code.jquery.com/jquery-1.12.4.js" 
    integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
    crossorigin="anonymous">
</script> 
<script>
    $(function(){
        console.log($(".section").length, $(".aside").length);
        if($(".section").length==0 && $(".aside").length ==0){
            console.log($(".article").css("margin"));
            $(".article").css("clear", "both");
            $(".article").css("width", "75%");
            $(".article").css("margin", "auto");
        }
    });
    
</script>

