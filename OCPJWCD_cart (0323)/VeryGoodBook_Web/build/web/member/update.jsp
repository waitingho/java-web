<%@page import="uuu.vgb.entity.BloodType"%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page pageEncoding='UTF-8' contentType="text/html" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="vgb"  %>
<%
    String uri = request.getRequestURI();
    Customer member = null;
    if(uri.indexOf(request.getContextPath()+"/member")>=0){
        member = (Customer)session.getAttribute("member");
        if(member==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
    }
%>
<html>
    <head>
        <title>會員修改</title>       
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
    </head>
    <body>
        <jsp:include page="/WEB-INF/subviews/header.jsp">
            <jsp:param name="subtitle" value="會員修改" />            
        </jsp:include>
        <%
            List<String> errors = (List<String>)request.getAttribute("errors");
        %>
        <div class="article" style="float: left;width:75%;min-width:60ex;min-height:65vh;background-color: lightgray">          
            <%= errors!=null && errors.size()>0?errors:""%>
            <form action='update.do' method="POST">
                <p>
                    <label>帳號:</label>
                    <input accesskey="1" type='text' name='id' placeholder="請輸入身分證號" readonly pattern='[A-Z][12]\d{8}'
                           value='<%= request.getParameter("id")==null?member.getId():request.getParameter("id") %>'>
                </p>
                <p>
                    <label>姓名:</label>
                    <input accesskey="2" type='text' name='name' placeholder="請輸入姓名" required
                           value='${not empty param.name?param.name:sessionScope.member.name}'>
                </p>       
                <p>
                    <label>密碼:</label>
                    <input type='password' name='password' placeholder="請輸入原來的密碼" minlength="6" maxlength="20" required
                           value='${param.pwd1}'><br>
                    <fieldset style="width: 25ex">
                        <legend><input type="checkbox" id="changePwd" name="changePwd"><label>修改密碼:</label></legend>
                        <label>密碼:</label>
                        <input type='password' name='pwd1' placeholder="請輸入新的密碼" minlength="6" maxlength="20"
                               value='${param.pwd1}' disabled><br>
                        <label>確認:</label>
                        <input type='password' name='pwd2' placeholder="請輸入確認密碼" minlength="6" maxlength="20"
                               value='${param.pwd2}' disabled>
                    </fieldset>
                </p>
                <p>
                    <label>性別:</label>       
                    <input type="radio" name='gender' id='male' required value='<%= Customer.MALE %>' 
                           <%= request.getParameter("gender")!=null 
                                   && request.getParameter("gender").charAt(0)==Customer.MALE ?"checked":"" %> ><label>男</label>
                    <input type="radio" name='gender' id='female' required value='<%= Customer.FEMALE %>' 
                           <%= request.getParameter("gender")!=null 
                                   && request.getParameter("gender").charAt(0)==Customer.FEMALE ?"checked":"" %>><label>女</label>
                </p>
                <p>
                    <label>生日:</label>
                    <input type="date" name="birthday" required value='${param.birthday}'/>
                </p>
                <p>
                    <label>電郵:</label>
                    <input type="email" name="email" required value='${param.email}'/>
                </p>                
                <p>
                    <label>地址:</label>
                    <input type="text" name="address" value='${param.address}'/>
                </p>                
                <p>
                    <label>電話:</label>
                    <input type="tel" name="phone" value='${param.phone}'/>
                </p>
                <p>
                    <label>婚況:</label>
                    <input type="checkbox" name="married" <%= request.getParameter("married")!=null?"checked":"" %> /><label>已婚</label>
                </p>                
                <p>
                    <label>血型:</label>
                    <select name='blood_type'>
                        <option value=''>請選擇</option>
                        <% for(BloodType bType :BloodType.values()) {%>
                        <option value='<%= bType.name() %>' 
                                <%= bType.name().equals(request.getParameter("blood_type")) ?"selected":""%> ><%= bType %></option>
                        <% } %>
                    </select>                    
                </p>
                <p>                    
                    <label>驗證:</label>
                    <vgb:captchaInput src="../images/register_captcha.jpg"/>
<!--                    <input type='text' name='captcha' placeholder="請輸入驗證碼" required><br>
                    <a href="javascript:refreshCaptcha()">
                        <img id="captcha_img" title="點選即可更新圖片" src='images/register_captcha.jpg' style="vertical-align: middle">
                    </a>
                    <script>
                        function refreshCaptcha(){
                            $("#captcha_img").attr("src", "images/register_captcha.jpg?refresh=" + new Date());
                        }
                    </script>-->
                </p>               
                <input type='submit' value="確定修改">                
            </form>
        </div>
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>
</html>
