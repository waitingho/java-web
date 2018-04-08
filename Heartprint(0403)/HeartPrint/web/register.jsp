<%-- 
    Document   : register
    Created on : 2018/3/20, 下午 07:35:08
    Author     : Administrator
--%>

<%@page import="java.util.List"%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTER</title>
        <style>
            #fiexd-header{
                background:pink;
                width:98.5%;
                position:fixed; /*固定位置定位*/
                top:0; /*距離上方 0 像素*/
                z-index:9999; /*重疊時會在其他元素之上*/
                padding: auto;
                text-align: right;
                vertical-align: bottom;
            }
            .inside a{
                text-decoration:none
            }
            .inside a:link{color:white;}
            .inside a:visited{color: gray;}
            .inside a:hover{color: yellow; }

            .nav a{
                text-decoration:none;
            }
            #header img{
                display: block;
                margin-left: auto;
                margin-right: auto;
                margin-top: 50px;

            }
            .nav{
                text-align: center;
            }
            form{
                margin: auto;
                /*border: 1px solid black;*/
                width: 100%
            }
            input {
                width: 100%;
                padding: 12px 20px;
                border-radius: 10px;
                box-sizing: border-box;
                outline: none;
                float: right;
            }


            input:focus {
                background-color: pink;
            }

            .section{
                float: left;
                width: 30%;
                min-width:8ex;
            }
            div.rotate_up {
                float: right;
                -ms-transform: rotate(-7deg); /* IE 9 */
                -webkit-transform: rotate(-7deg); /* Safari */
                transform: rotate(-7deg);

            }
            .polaroid {
                margin: 30px;
                width: 250px;
                padding: 10px 10px 100px 10px;
                border: 1px solid #BFBFBF;
                box-shadow: 10px 10px 5px #aaaaaa;
            }
            .article{
                float: left;
                width:40%;
                min-height: 60vh;
                /*                background:#FFF0F5;*/
                border-radius: 10px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19), 0 8px 30px 0 rgba(0, 0, 0, 0.18);
                /*                -ms-transform: rotate(5deg);  IE 9 
                                -webkit-transform: rotate(5deg);  Safari 
                                transform: rotate(5deg);*/
            }
            .aside{
                float:right; 
                width: 30%;
            }
            table {
                border-collapse: collapse;
                width: 100%;
                margin: auto;
                /*border: 1px solid black;*/
            }

            th, td {
                text-align: left;
                padding: 15px;
            }
            td img{
                float: right;
            }
            tr:nth-child(even) {background-color: #FFF0F5;}
            .button {
                /*display: inline-block;*/
                padding: 15px 25px;
                /*font-size: 24px;*/
                /*cursor: pointer;*/
                text-align: center;
                text-decoration: none;
                outline: none;
                /*color: #fff;*/
                background-color: #FFF0F5;
                border: none;
                border-radius: 15px;
                box-shadow: 0 9px #999;
                width: 100%;
            }

            .button:hover {background-color:#6DD0CD}

            /*            .button:active {
                            background-color: #3e8e41;
                            box-shadow: 0 5px #666;
                            transform: translateY(4px);
                        }*/

        </style>
    </head>
    <body>
        <div id="fiexd-header" >
            <div class="inside">
                <a  href="/HeartPrint/member/cart.jsp" >Cart</a> |
                <a href="/HeartPrint/login.jsp">Logoin</a> |
                <a href="/HeartPrint/register.jsp">Register</a> 
            </div>
        </div>
        <div id="header" >
            <a href="/HeartPrint/index.jsp">
                <img src="./image/logo.png">
            </a>
        </div>   
        <br>
        <hr color=pink size="2">
        <br><br> 
        <div class="section" >
            section
            <div class="polaroid rotate_up">
                <img src="./image/register.png" width="250" height="213">
            </div>
        </div>
        <%
            List<String> errors = (List<String>) request.getAttribute("errors");
        %>
        <div class="article"  >
            <%= errors != null && errors.size() > 0 ? errors : ""%>
            <br> 
            <form action="register.do" method="POST">
                <table>
                    <tr> 
                        <td>身分證字號:</td>
                        <td><input accesskey="1" type="text" name="id" placeholder="身分證字號" pattern='[A-Z][12]\d{8}' required 
                                   value='<%= request.getParameter("id") == null ? "" : request.getParameter("id")%>'></td>
                    </tr>
                    <tr> 
                        <td>姓名:</td>
                        <td> <input type="text" name="name" placeholder="輸入姓名" required
                                    value='${param.name}'></td>
                    </tr> 
                    <tr> 
                        <td>密碼:</td>
                        <td> <input type="password" name="pwd1" placeholder="密碼" minlength="6" maxlength="20" required></td>
                    </tr> 
                    <tr>
                        <td>密碼確認: </td>
                        <td><input type="password" name="pwd2" placeholder="密碼確認" minlength="6" maxlength="20" required> </td>
                    </tr> 
                    <tr>
                        <td>性別:</td> 
                        <td>
                            <input type="radio" name="gender" id="male" required value="M" ><div>Male</div>
                            <input type="radio" name="gender" id="femal" required value="F">Female

                        </td>
                    </tr>

                    <tr>
                        <td>生日:</td>
                        <td><input type="date" name="birthday" required 
                                   value='${param.birthday}'/></td>
                    </tr>

                    <tr>
                        <td>Email:</td>
                        <td><input type="email" name="email" required 
                                   value='${param.email}'/></td>
                    </tr>
                    <tr>
                        <td>地址:</td>
                        <td><input type="text" name="address" value='${param.address}' /></td>
                    </tr>
                    <tr>
                        <td>電話:</td>
                        <td> <input type="tel" name="phone" value='${param.phone}' /></td>
                    </tr>
                    <tr>
                        <td>驗證碼::</td>
                        <td> 
                            <input type="text" name="captcha"  placeholder="請輸入驗證碼" required>
                            <a href="javascript:refreshImage()">
                                <img id="captcha_img" title="點我更新" src="images/register_captcha.jpg" style="vertical-align: middle">
                            </a>

                        </td>

                    </tr>
                    <script>
                        function refreshImage() {
                            var checkImage = document.getElementById("captcha_img");
                            checkImage.src = "images/register_captcha.jpg?get=" + new Date();
                        }
                    </script>
                    <tfoot>
                    <td colspan='2'><input class="button" type='submit' value="註冊"></td>
                        </tfoot>
                </table>
            </form> 
        </div>
        <div class="aside" >
            aside
        </div>
        <div class="footer" style="clear:both; color: gray">
            <br><br> 
            <hr>
            Copyright © 2018 HertPrinT Inc. All rights reserved | 
            Contact information: <a href="mailto:hertprint@gmail.com">hertprint@gmail.com</a>
        </div>
    </body>
</html>
