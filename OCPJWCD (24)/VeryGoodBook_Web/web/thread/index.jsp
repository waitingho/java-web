<%-- 
    Document   : index
    Created on : 2017/5/19, 上午 11:21:38
    Author     : Administrator
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private Locale userLocale = null;
    private NumberFormat priceFormat = null;
    private DateFormat dateFormat = null;
%>    
<%    
//    Locale userLocale = null;
//    NumberFormat priceFormat = null;
//    DateFormat dateFormat = null;
    
    String[] locale = request.getHeader("accept-language").split(",")[0].trim().split("-");
//    Locale userLocale = null;
//    NumberFormat priceFormat = null;
//    DateFormat dateFormat = null;
    Date today = new Date();

    if (locale.length == 2) {
        userLocale = new Locale(locale[0], locale[1]);
    } else if (locale.length == 1) {
        userLocale = new Locale(locale[0]);
    }

    //synchronized(userLocale){
    if (userLocale != null) {
        priceFormat = NumberFormat.getCurrencyInstance(userLocale);
        dateFormat = new SimpleDateFormat("yyyy/MM/dd E hh:mm:ss", userLocale);
    } else {
        priceFormat = NumberFormat.getCurrencyInstance();
        dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //Thread.sleep((int)(Math.random() * 3000));
        %>    
        
        <p>accept-language: <%= request.getHeader("accept-language") %></p>
        <p>Thread Name: <%= Thread.currentThread().getName()%><br>
            User Locale: <%= userLocale%><br>
            User Country: <%= userLocale.getDisplayCountry() %><br>
            Today: <%= dateFormat.format(today)%><br>
            Price: <%= priceFormat.format(200.5)%><br>
        </p>
    </body>
    <%//}%>
</html>
