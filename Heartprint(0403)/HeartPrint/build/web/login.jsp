<%-- 
    Document   : login
    Created on : 2018/3/19, 下午 07:36:51
    Author     : Administrator
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGING</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            /*            .footer {
                            position: fixed;
                            left: 0;
                            bottom: 0;
                            width: 100%;
                            z-index:-1;
                        }*/
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
            /*            .nav{
                            text-align: center;
                        }*/
            input{
                margin: auto;

                /*width: 30%;*/
                padding: 12px 20px;
                border-radius: 10px;
                box-sizing: border-box;
                outline: none;
            }

            input:focus {
                background-color: #FFF0F5;
            }
            form{
                text-align: center;
            }
            .section{
                float: left;
                width: 30%;
                min-width:8ex;
                /*border: 1px solid #BFBFBF;*/
                /*                      background-color: white;
                                     box-shadow: 10px 10px 5px #aaaaaa;*/
            }
            .article{
                float: left;
                width:40%;
                min-height: 60vh;
                background:#e7f3fe;
                border-radius: 10px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19), 0 8px 30px 0 rgba(0, 0, 0, 0.18);
                /*border: 1px solid #BFBFBF;*/

            }
            .aside{
                float:right; 
                width: 30%;
                border: 1px solid #BFBFBF;
            }
            .polaroid {
                margin: 30px;
                width: 250px;
                padding: 10px 10px 100px 10px;
                border: 1px solid #BFBFBF;

                box-shadow: 10px 10px 5px #aaaaaa;
            }

            div.rotate_up {
                float: right;
                -ms-transform: rotate(-7deg); /* IE 9 */
                -webkit-transform: rotate(-7deg); /* Safari */
                transform: rotate(-7deg);
            }

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
                width: 60%;
            }

            .button:hover {background-color:#6DD0CD}

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
                <img src="./image/login.png" width="250" height="213">
            </div>



            <!--            <div class="polaroid rotate_down">
                            <img src="./image/view.jpg" width="250" height="213">
                        </div>-->
        </div>
        <%
            Object obj = request.getAttribute("errors");
            List<String> list = null;
            if (obj instanceof List) {
                list = (List<String>) obj;
            }
        %>
        <div class="article"  >
            <br>
            <%=list != null && list.size() > 0 ? list : ""%>

            <form action="login.do" method="POST">

                <p>
                    <input type="text" name="id" value="${(empty param.id)?(cookie.id.value):(param.id)}" placeholder="身分證字號" request >
                </p> 
                <p> 
                    <input type='checkbox' name='auto' value="ON" ${cookie.auto.value}/>記住我的帳號
                </p>
                <p>
                    <label></label>
                    <input type="password" name="pwd" placeholder="密碼" minlength="6" maxlength="20" required>
                </p>
                <p>
                    <label></label>
                    <input type="text" name="captcha"  placeholder="請輸入驗證碼" required><br>
                    <a href="javascript:refreshImage()">
                        <img id="captcha_img" title="點我更新" src="images/captcha.jpg" >
                    </a>
                    <script>
                        function refreshImage() {
                            var checkImage = document.getElementById("captcha_img");
                            checkImage.src = "images/captcha.jpg?get=" + new Date();
                        }

                    </script>
                </p>
                <input class="button" type='submit' value='登入'>

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