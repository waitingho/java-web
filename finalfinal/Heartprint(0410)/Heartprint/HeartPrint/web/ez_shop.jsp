<%-- 
    Document   : ez_shop
    Created on : 2017/12/21, 下午 04:50:25
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    java.net.InetAddress ip = java.net.InetAddress.getLocalHost();
    String myIp = ip.getHostAddress();
%>
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>eShop 模擬購物網站超商取貨</title>
    </head>
    <body>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td height="84" align="center">
                    <div style="font-size:28px"><br><b> <font size=6 color=red>模擬</font> 購物網站超商取貨</b><br><br></div>
                    <img src="http://www.ezship.com.tw/images/store_step.gif" border="0">
                </td>
            </tr>
        </table>
        <hr>
        
            <table width="70%" border="0" cellspacing="3" cellpadding="3" align=center>
                <tr>
                    <td>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="border-collapse: collapse">
                            <tr>
                                <td>
                                    <table width="100%" border="0">
                                        <tr>
                                            <td> >> 填寫訂購資料〈 <font color="#CC0000">付款方式 - 線上刷卡，超商取貨</font> 〉</td>
                                        </tr>
                                    </table>
                                    <table width="100%" border="1" cellspacing="0" cellpadding="0" align="center">
                                        <tr valign="top">
                                            <td bgcolor="#FFFFFF" align="center" height="15">
                                                <table width="95%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td>
                                                            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                                                                <tr>
                                                                    <td width="10" height="15"></td>
                                                                    <td class="title" height="15"></td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="10" bgcolor="#c2c2c2"> </td>
                                                                    <td bgcolor="#c2c2c2"><span><b>消費明細</b></span></td>
                                                                </tr>
                                                            </table>
                                                            <table width=100% border=0 bgcolor='#c2c2c2' cellspacing=1 cellpadding=5>
                                                                <tr bgcolor=#e3ffd7>
                                                                    <td width='68%'><div align=center><b>商品名稱</b></div></td>
                                                                    <td width='10%'><div align=right><b>單價</b></div></td>
                                                                    <td width='10%'><div align=right><b>數量</b></div></td>
                                                                    <td width='12%'><div align=right><b>小計</b></div></td>
                                                                </tr>
                                                                <tr bgcolor=FFFFFF>
                                                                    <td height=20><div align=left><font color=#003399><span>炫光時鐘收音機</span></font></div></td>
                                                                    <td><div align=right><span>299</span></div></td>
                                                                    <td align=right>1</td>
                                                                    <td align=right><span>299</span></td>
                                                                </tr>
                                                                <tr bgcolor=FFFFFF>
                                                                    <td height=20 align=left><font color=000000>運費</font></td>
                                                                    <td></td>
                                                                    <td></td>
                                                                    <td align=right>50</td>
                                                                </tr>
                                                                <tr bgcolor=FFFFFF>
                                                                    <td height=20></td>
                                                                    <td></td>
                                                                    <td colspan=2 align=right><font color=#FF3300><b>消費總金額　299</b></font></td>
                                                                </tr>
                                                            </table>
                                                            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                                                                <tr>
                                                                    <td width="10" height="15"></td>
                                                                    <td height="15"></td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="10" bgcolor="#c2c2c2"> </td>
                                                                    <td bgcolor="#c2c2c2"><span class="title"><b>填寫付款人資料</b></span></td>
                                                                </tr>
                                                            </table>
                                                            <table width=100% border=0 bgcolor='#c2c2c2' cellspacing=1 cellpadding=5>
                                                                <tr>
                                                                    <td bgcolor=#e3ffd7 width='20%' align=right><b>姓名</b></td>
                                                                    <td bgcolor=#FFFFFF height=20>謝無忌</td>
                                                                </tr>
                                                                <tr>
                                                                    <td bgcolor=#e3ffd7 width='20%' align=right><b>E-Mail</b></td>
                                                                    <td bgcolor=#FFFFFF height=20>simulate_receiver@ezship.com.tw</td>
                                                                </tr>
                                                                <tr>
                                                                    <td bgcolor=#e3ffd7 width='20%'><div align=right class='sbody'><b>行動電話</b></div></td>
                                                                    <td bgcolor=#FFFFFF height=20>0967123456</td>
                                                                </tr>
                                                            </table>
                                                            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                                                                <tr>
                                                                    <td width="10" height="15"></td>
                                                                    <td class="title" height="15"><b class="stitle"></b></td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="10" bgcolor="#c2c2c2"> </td>
                                                                    <td bgcolor="#c2c2c2"><span class="title"><b>取貨方式</b></span></td>
                                                                </tr>
                                                            </table>
                                                            <br>
                                                            <a id="nextstep02" href="#">
                                                                <center><input name="Submit2" type="submit" value="選擇門市"></center>
                                                            </a>
                                                            <br><br>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>

        <hr>
    </body>
</html>