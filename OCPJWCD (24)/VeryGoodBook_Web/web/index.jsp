<%-- @page import="uuu.vgb.entity.Customer" --%>
<jsp:directive.page import="uuu.vgb.entity.Customer" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>首頁</title>        
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">                
        <!--<meta http-equiv="refresh" content ="3; url=http://www.uuu.com.tw" />-->
        <%@include file="/WEB-INF/subviews/global_lib.jsp" %>
        <style>
            #my_list>li{
                /*display:list-item;*/
                display: inline-table;
                width: 250px; height: 250px;
                margin: 10px 5px;
                box-shadow: 1px 1px 2px gray
            }

            #my_list h4{
                font-size: smaller;text-align: center
            }

            .product_price{
                font-size: smaller; padding: 0 10px;
            }

            #fake_ul{ padding-left: 30px; }
            #fake_ul>span{
                display: list-item;                       
            }
        </style>
    </head>
    <body>       
        <jsp:include page="/WEB-INF/subviews/header.jsp" />
        <div class="article">
            <div>歡迎, 3秒後將自動轉址http://www.uuu.com.tw
                <script>
    //                document.write(new Date());
                </script>        
            </div>
            <hr>
            <div>清單元素: ul, ol, table
                <hr>
                <h2>無序號清單: ul, li:</h2>
                <ul id="my_list">
                    <li>
                        <div style='width:120px;margin:auto'>
                            <img style='width:120px;' 
                                 src='http://im1.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/077/83/0010778374.jpg&v=5a6ef803&w=348&h=348'>
                        </div>
                        <h4>Android御用語言：比Java還精美的Kotlin</h4>
                        <div class='product_price'>
                            定價：540元<br>
                            優惠價：9折486元
                        </div>
                    </li>
                    <li>
                        <div style='width:120px;margin:auto'>
                            <img style='width:120px;' 
                                 src='http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/077/37/0010773787.jpg&v=5a3101af&w=348&h=348'>
                        </div>
                        <h4>Java SE 9 技術手冊</h4>
                        <div class='product_price'>
                            定價：650元<br>
                            優惠價：79折514元
                        </div>
                    </li>
                    <li>
                        <div style='width:120px;margin:auto'>
                            <img style='width:120px;' 
                                 src='http://im1.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/077/68/0010776862.jpg&v=5a5dd438&w=348&h=348'>
                        </div>
                        <h4>Android 8.X App 開發之鑰：使用Java及Android Studio(附光碟)</h4>
                        <div class='product_price'>
                            定價：680元<br>
                            優惠價：9折612元
                        </div>
                    </li>
                    <li>
                        <div style='width:120px;margin:auto'>
                            <img style='width:120px;' 
                                 src='http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/077/37/0010773787.jpg&v=5a3101af&w=348&h=348'>
                        </div>
                        <h4>Java SE 9 技術手冊</h4>
                        <div class='product_price'>
                            定價：650元<br>
                            優惠價：79折514元
                        </div>
                    </li>                        
                </ul>
            </div>
            <ul type='circle'>
                <li>Item1</li>
                <li>Item2</li>
                <li>Item3</li>
                <li>Item4</li>
                <li>Item5</li>
            </ul>                
            <hr>
            <h2>有序號清單: ol, li:</h2>
            <ol type='i'>
                <li>Item1</li>
                <li>Item2</li>
                <li>Item3</li>
                <li>Item4</li>
                <li>Item5</li>
            </ol>
            <hr>
            <h2>div, span 做出list-item:</h2>
            <div id='fake_ul'>
                <span>Item1</span>
                <span>Item2</span>
                <span>Item3</span>
            </div>
            <hr>
            <h2>table, thead, tbody, tfoot, tr, th, td, caption </h2>        
            <table border='1' cellspacing='1' cellpadding='3'>  
                <caption>購物車</caption>
                <tbody>
                    <tr>
                        <td>Android 8.X App 開發之鑰：使用Java及Android Studio(附光碟)</td>
                        <td>680</td>
                        <td>9折</td>
                        <td>612</td>
                        <td>1</td>
                    </tr>
                    <tr>
                        <td>Java SE 9 技術手冊</td>
                        <td>650</td>
                        <td>79折</td>
                        <td>514</td>
                        <td>1</td>
                    </tr>        
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="3">總金額:</td>
                        <td colspan="2">1126元</td>
                    </tr>            
                </tfoot>
                <thead>
                    <tr>
                        <th>名 稱</th>
                        <th>定 價</th>
                        <th>折 扣</th>
                        <th>售 價</th>
                        <th>數 量</th>
                    </tr>
                </thead>            
            </table>
        </div>        
        <%@include file="/WEB-INF/subviews/footer.jsp" %>
    </body>        
</html>
