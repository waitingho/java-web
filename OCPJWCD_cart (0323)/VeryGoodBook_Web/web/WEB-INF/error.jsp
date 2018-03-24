<%@page contentType="text/html" isErrorPage="true"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
        <title>錯誤訊息</title>
        <script>
            var s1 = "block";
            var s2 = "width:80%;display:blocked;font-size:60%;color:blue";
            function show_details() {
                var d = document.getElementById("details");
                try {
                    d.style.setAttribute("display", s1);
                    if (s1 == "none") {
                        s1 = "block";
                    } else {
                        s1 = "none";
                    }
                } catch (err) {
                    d.setAttribute("style", (s2 == null ? "width:80%;display:none;" : s2));
                    if (s2 == null) {
                        s2 = "width:80%;display:blocked;font-size:60%;color:blue";
                    } else {
                        s2 = null;
                    }
                }
            } 
        </script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp" >
            <jsp:param name="subtitle" 
                       value='錯誤訊息:${requestScope["javax.servlet.error.status_code"]}' />            
        </jsp:include>
        <div class="article" style="min-height: 65vh">
            <p style='font-size:80%'>執行<span style='color:darkred'>
                    <%= request.getAttribute("javax.servlet.error.request_uri")%> </span>時發生下列錯誤：<br/>
                    <% if (exception != null) {
                            out.println(exception.getClass().getName() + ":\t" + exception.getMessage());%>
                <a href="javascript:show_details()">details...</a><br/>
                <span id='details' style="width:60%;display:none;color:blue">
                    <%
                        this.log("系統發生非預期錯誤", exception);
                        exception.printStackTrace(new java.io.PrintWriter(out));
                    %>
                </span>
                <% }%>          
            </p>
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>             
    </body>
</html>