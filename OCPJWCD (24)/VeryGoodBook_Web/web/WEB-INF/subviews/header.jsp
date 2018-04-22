<%@page import="uuu.vgb.entity.Customer" contentType="text/html" pageEncoding="UTF-8"%>
        <div class="header">
            <h1><a href="<%= request.getContextPath() %>">非常好書</a> 
                <sub>
                    <%= request.getParameter("subtitle")==null?"歡迎光臨":request.getParameter("subtitle")%>
                </sub>
            </h1>            
        </div>
        <%  Customer member = (Customer) session.getAttribute("member"); %>
        <div class="nav">
            <a href="${pageContext.request.contextPath}/products_list.jsp">產品清單</a> |             
            <a href="<%= request.getContextPath() %>/member/cart.jsp">
                購物車
            </a>
            <span id="total_quantity">
                <%@include file="/small_cart_ajax.jsp" %>
            </span> | 
            <% if (member == null) {%>
            <a href="<%= request.getContextPath() %>/login.jsp">登入</a> | 
            <a href="<%= request.getContextPath() %>/register.jsp">註冊</a> | 
            <%} else {%>
            <a href="${pageContext.request.contextPath}/logout.do">登出</a> | 
            <a href="${pageContext.request.contextPath}/member/update.jsp">修改會員</a> | 
            <a href="${pageContext.request.contextPath}/member/orders_history.jsp">歷史訂單</a> | 
            <%}%>
            <%--<span id="welcome_span" style="float:right;font-size: smaller">你好!<%= member != null ? member.getName() : ""%></span>--%>
            <span id="welcome_span" style="float:right;font-size: smaller">${sessionScope.member.name} 你好!</span>
            <hr>
        </div>
