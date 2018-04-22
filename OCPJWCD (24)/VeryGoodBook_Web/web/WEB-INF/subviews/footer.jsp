<%@page import="java.util.Calendar" contentType="text/html" pageEncoding="UTF-8"%>
        <div class="footer" style="clear:both">
            <hr>
            版權所有 &copy; 非常好書 2017~<%= Calendar.getInstance().get(Calendar.YEAR) %>
            <span style='float: right'>拜訪人次: 
                <%--<%= application.getAttribute("app.visitors")%>--%>
                ${applicationScope["app.visitors"]}
                ,您是第${sessionScope["app.visitors"]}位訪客</span>
        </div>   